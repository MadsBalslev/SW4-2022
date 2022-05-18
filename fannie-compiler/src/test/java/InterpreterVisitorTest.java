import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.HashMap;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Exceptions.CompilerException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fannieTypes.Ingredient;
import fannieTypes.*;
import fannieTypes.toolActions.ContainToolActionDeclaration;
import fannieTypes.toolActions.ContentInToolAction;
import fannieTypes.toolActions.NormalToolAction;
import fannieTypes.toolActions.ToolAction;

public class InterpreterVisitorTest {
    InterpreterVisitor interpreterVisitor;

    // private <T extends RuleContext> T mockForVisitorResult(final Class<T> nodeType, final String visitResult) {
    //     final T mock = mock(nodeType);
    //     when(mock.accept(interpreterVisitor)).thenReturn(visitResult);
    //     return mock;
    // }

    private fannieParserParser createParser(String str) {
        CharStream input = CharStreams.fromString(str);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        return parser;
    }

    @Before
    public void init() throws IOException {
        interpreterVisitor = new InterpreterVisitor();
    }

    @Test
    public void visitStepOut_IngredientCollectionNotNull_ReturnListWithStrings() {
        // arrange
        fannieParserParser parser = createParser("{ I0 }");
        fannieParserParser.StepOutContext context = parser.stepOut();

        // act
        List<String> actual = interpreterVisitor.visitStepOut(context);

        // assert
        final int expectedSize = 1;
        assertEquals(expectedSize, actual.size());
        assertEquals("I0", actual.get(0));
    }
    
    @Test
    public void visitStepOut_IngredientIdentifierNotNull_ReturnListWithString() {
        // arrange
        fannieParserParser parser = createParser("I0");
        fannieParserParser.StepOutContext context = parser.stepOut();

        // act
        List<String> actual = interpreterVisitor.visitStepOut(context);

        // assert
        final int expectedSize = 1;
        assertEquals(expectedSize, actual.size());
        assertEquals("I0", actual.get(0));
    }

    @Test
    public void visitStepOut_BadContext_ThrowCompilerException() {
        // arrange
        fannieParserParser parser = createParser("");
        fannieParserParser.StepOutContext context = parser.stepOut();

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitStepOut(context);
        });
    }

    @Test
    public void visitStepIn_IngredientCollectionIsNotNull_ReturnIngredientList() {
        // arrange
        fannieParserParser parser = createParser("{ I0 }");
        fannieParserParser.StepInContext context = parser.stepIn();
        Ingredient ingredient0 = new Ingredient("I0", null);
        interpreterVisitor.scope.append(ingredient0.identifier, ingredient0);

        // act
        List<Ingredient> actual = interpreterVisitor.visitStepIn(context);

        // assert
        final int expectedSize = 1;
        assertEquals(expectedSize, actual.size());
        assertEquals(ingredient0, actual.get(0));
    }

    @Test
    public void visitStepIn_IngredientCollectionIdentifierNotInScope_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("{ I0 }");
        fannieParserParser.StepInContext context = parser.stepIn();

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitStepIn(context);
        });
    }

    @Test
    public void visitStepIn_IngredientIdentifierIsNotNull_ReturnsIngredientList() {
        // arrange
        fannieParserParser parser = createParser("I0");
        fannieParserParser.StepInContext context = parser.stepIn();
        Ingredient ingredient0 = new Ingredient("I0", null);
        interpreterVisitor.scope.append(ingredient0.identifier, ingredient0);

        // act
        List<Ingredient> actual = interpreterVisitor.visitStepIn(context);

        // assert
        final int expectedSize = 1;
        assertEquals(expectedSize, actual.size());
        assertEquals(ingredient0, actual.get(0));
    }

    @Test
    public void visitStepIn_IngredientIdentifierNotInScope_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("I0");
        fannieParserParser.StepInContext context = parser.stepIn();

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitStepIn(context);
        });
    }

    @Test
    public void visitStepIn_ContentInIsNotNull_ReturnsIngredientList() {
        // arrange
        fannieParserParser parser = createParser("content in T0");
        fannieParserParser.StepInContext context = parser.stepIn();
        Ingredient ingredient0 = new Ingredient("content inT0", null);
        interpreterVisitor.scope.append(ingredient0.identifier, ingredient0);

        // act
        List<Ingredient> actual = interpreterVisitor.visitStepIn(context);

        // assert
        final int expectedSize = 1;
        assertEquals(expectedSize, actual.size());
        assertEquals(ingredient0, actual.get(0));
    }

    @Test
    public void visitStepIn_ContentInNotInScope_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("content in I0");
        fannieParserParser.StepInContext context = parser.stepIn();

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitStepIn(context);
        });
    }

    @Test
    public void visitStepIn_BadContext_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("");
        fannieParserParser.StepInContext context = parser.stepIn();

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitStepIn(context);
        });
    }

    @Test
    public void visitDeterministicIngredientDeclaration_GoodDeterministicIngredientDeclaration_AddIngredientToScope() {
        // arrange
        fannieParserParser parser = createParser("ingredient I0 (to-taste)");
        fannieParserParser.DeterministicIngredientDeclarationContext context = parser
                .deterministicIngredientDeclaration();

        // act
        interpreterVisitor.visitDeterministicIngredientDeclaration(context);

        // assert
        final Ingredient I0 = (Ingredient) interpreterVisitor.scope.retrieve("I0");
        assertEquals("I0", I0.identifier);
        assertEquals("ingredient", I0.ingredientType.identifier);
    }

    @Test
    public void visitDeterministicIngredientDeclaration_DuplicateDeclaration_ThrowCompilerException() {
        // arrange
        fannieParserParser parser = createParser("ingredient I0 (to-taste)");
        fannieParserParser.DeterministicIngredientDeclarationContext context = parser
                .deterministicIngredientDeclaration();
        interpreterVisitor.scope.append("I0", new Ingredient("I0", null));

        // assert
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitDeterministicIngredientDeclaration(context);
        });
    }

    @Test
    public void visitDeterministicIngredientDeclaration_BadType_ThrowCompilerException() {
        // arrange
        fannieParserParser parser = createParser("IT0 I0 (to-taste)");
        fannieParserParser.DeterministicIngredientDeclarationContext context = parser.deterministicIngredientDeclaration();

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitDeterministicIngredientDeclaration(context);
        });
    }

    @Test
    public void visitIngredientTypeDeclaration_Good_AddTypeToTypeHandler() {
        // arrange
        fannieParserParser parser = createParser("ingredient I0");
        fannieParserParser.IngredientTypeDeclarationContext context = parser.ingredientTypeDeclaration();

        // act
        interpreterVisitor.visitIngredientTypeDeclaration(context);

        // assert
        Ingredient mockIngredient = mock(Ingredient.class);
        IngredientType ingredientType = interpreterVisitor.ingredientTypeHandler.AssignIngredientType(mockIngredient, "I0");
        assertEquals("I0", ingredientType.identifier);
    }

    @Test
    public void visitIngredientTypeDeclaration_Duplicate_ThrowCompilerException() {
        // arrange
        fannieParserParser parser = createParser("ingredient I0");
        fannieParserParser.IngredientTypeDeclarationContext context = parser.ingredientTypeDeclaration();
        interpreterVisitor.visitIngredientTypeDeclaration(context);

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitIngredientTypeDeclaration(context);
        });
    }

    @Test
    public void visitIngredientTypeDeclaration_InvalidLHS_ThrowCompilerException() {
        // arrange
        fannieParserParser parser = createParser("IAmError I0");
        fannieParserParser.IngredientTypeDeclarationContext context = parser.ingredientTypeDeclaration();

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitIngredientTypeDeclaration(context);
        });
    }

    @Test
    public void visitToolActionDeclaration_GoodContainAction_ReturnContainAction() {
        // arrange
        fannieParserParser parser = createParser("contain: ingredient");
        fannieParserParser.ToolActionDeclarationContext context = parser.toolActionDeclaration();

        // act
        ToolAction actual = interpreterVisitor.visitToolActionDeclaration(context);

        // assert
        assertTrue(actual instanceof ContainToolActionDeclaration);
        assertEquals("contain", actual.toolActionIdentifier);
        assertEquals("ingredient", actual.input);
        assertEquals("content in", actual.output);
    }

    @Test 
    public void visitToolActionDeclaration_GoodContentInAction_ReturnContentInToolAction() {
        // arrange
        fannieParserParser parser = createParser("Action: content in Tool => ingredient");
        fannieParserParser.ToolActionDeclarationContext context = parser.toolActionDeclaration();

        // act
        ToolAction actual = interpreterVisitor.visitToolActionDeclaration(context);

        // assert
        assertTrue(actual instanceof ContentInToolAction);
        assertEquals("Action", actual.toolActionIdentifier);
        assertEquals("content in", actual.input);
        assertEquals("ingredient", actual.output);
    }
    
    @Test
    public void visitToolActionDeclaration_GoodNormalToolAction_ReturnNormalToolAction() {
        // arrange
        fannieParserParser parser = createParser("Action: ingredient => ingredient");
        fannieParserParser.ToolActionDeclarationContext context = parser.toolActionDeclaration();

        // act
        ToolAction actual = interpreterVisitor.visitToolActionDeclaration(context);

        // assert
        assertTrue(actual instanceof NormalToolAction);
        assertEquals("Action", actual.toolActionIdentifier);
        assertEquals("ingredient", actual.input);
        assertEquals("ingredient", actual.output);
    }

    @Test
    public void visitToolActionDeclarationList_goodContainAction_returnHashMap() {
        // arrange
        fannieParserParser parser = createParser("[contain : ingredient]");
        fannieParserParser.ToolActionDeclarationsListContext context = parser.toolActionDeclarationsList();

        // act
        HashMap<String, ToolAction> actual = interpreterVisitor.visitToolActionDeclarationsList(context);

        // assert
        assertEquals(1, actual.size());
    }

    @Test
    public void visitToolActionDeclarationList_normalAction_returnHashMap() {
        // arrange
        fannieParserParser parser = createParser("[Action : ingredient => ingredient]");
        fannieParserParser.ToolActionDeclarationsListContext context = parser.toolActionDeclarationsList();

        // act
        HashMap<String, ToolAction> actual = interpreterVisitor.visitToolActionDeclarationsList(context);

        // assert
        assertEquals(1, actual.size());
    }
        
    @Test
    public void visitToolDeclaration_inheritFromTool_addToolToScope() {
        // arrange
        fannieParserParser parser = createParser("tool NewTool[Action : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext context = parser.toolDeclaration();

        // act
        interpreterVisitor.visitToolDeclaration(context);  
        
        // assert
        Tool actualTool = (Tool)interpreterVisitor.scope.retrieve("NewTool");
        assertEquals("NewTool", actualTool.toolIdentifier);
        assertEquals("tool", actualTool.toolTypeIdentifier);

        ToolAction actualAction = actualTool.getToolAction("Action");
        assertEquals("Action", actualAction.toolActionIdentifier);
        assertEquals("ingredient", actualAction.input);
        assertEquals("ingredient", actualAction.output);
    }
    @Test
    public void visitToolDeclaration_inheritFromDeclaredTool_addToolToScope() {
        // arrange
        fannieParserParser parser = createParser("tool Tool0[Action0 : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext context = parser.toolDeclaration();
        interpreterVisitor.visitToolDeclaration(context);  

        parser = createParser("Tool0 Tool1[Action1 : ingredient => ingredient]");
        context = parser.toolDeclaration();
        
        // act
        interpreterVisitor.visitToolDeclaration(context);  
        
        // assert
        Tool actualTool = (Tool)interpreterVisitor.scope.retrieve("Tool1");
        assertEquals("Tool1", actualTool.toolIdentifier);
        assertEquals("Tool0", actualTool.toolTypeIdentifier);

        ToolAction actualAction = actualTool.getToolAction("Action0");
        assertEquals("Action0", actualAction.toolActionIdentifier);
        assertEquals("ingredient", actualAction.input);
        assertEquals("ingredient", actualAction.output);

        actualAction = actualTool.getToolAction("Action1");
        assertEquals("Action1", actualAction.toolActionIdentifier);
        assertEquals("ingredient", actualAction.input);
        assertEquals("ingredient", actualAction.output);
    }

    @Test
    public void visitToolDeclaration_duplicateToolDeclaration_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("tool Tool0[Action0 : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext context = parser.toolDeclaration();
        interpreterVisitor.visitToolDeclaration(context);  

        parser = createParser("tool Tool0[Action1 : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext ActContext = parser.toolDeclaration();
        

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitToolDeclaration(ActContext);  
        });
    }

    @Test
    public void visitToolDeclaration_duplicateActionDeclaration_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("tool Tool0[Action: ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext context = parser.toolDeclaration();
        interpreterVisitor.visitToolDeclaration(context);  

        parser = createParser("Tool0 Tool1[Action : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext ActContext = parser.toolDeclaration();
        

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitToolDeclaration(ActContext);  
        });
    }

    @Test
    public void visitToolDeclaration_nonDeclaredParentTool_throwCompilerException() {
        // arrange
        fannieParserParser parser = createParser("OldTool NewTool[Action : ingredient => ingredient]");
        fannieParserParser.ToolDeclarationContext context = parser.toolDeclaration();

        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitToolDeclaration(context);  
        });
    }

    @Test
    public void visitFannie_goodNormalDoStepIdentifierNoStepOut_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient,
                    serve Ingredient
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodNormalDoStepCollectionNoStepOut_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action { Ingredient },
                    serve { Ingredient } 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodNormalDoStepIdentifierToIdentifier_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient => Ingredient0,
                    serve Ingredient0
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodNormalDoStepCollectionToCollection_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action { Ingredient } => { Ingredient0 },
                    serve Ingredient0
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodNormalDoStepCollectionToIdentifier_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action { Ingredient } => Ingredient0,
                    serve Ingredient0
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }
    
    @Test
    public void visitFannie_goodNormalDoStepIdentifierToCollection_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient => { Ingredient0 },
                    serve Ingredient0
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodContainCollectionStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient0 (to-taste),
                    ingredient Ingredient1 (to-taste)
                },
                tools{
                    tool Tool[contain: ingredient]
                },
                steps{
                    Tool do contain { Ingredient0, Ingredient1 },
                    serve content in Tool
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }
    
    @Test
    public void visitFannie_goodContainStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[contain: ingredient]
                },
                steps{
                    Tool do contain Ingredient,
                    serve content in Tool
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodContainContentInStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool0[contain: ingredient],
                    tool Tool1[contain: ingredient]
                },
                steps{
                    Tool0 do contain Ingredient,
                    Tool1 do contain content in Tool0, 
                    serve content in Tool1
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodRemoveStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient0 (to-taste)
                },
                tools{
                    tool Tool[contain: ingredient]
                },
                steps{
                    Tool do contain Ingredient0,
                    Tool do remove Ingredient1,
                    serve Ingredient1 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodDoOnContentInWithoutContentInAction_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool0[contain: ingredient],
                    tool Tool1[Action: ingredient => ingredient]
                },
                steps{
                    Tool0 do contain Ingredient,
                    Tool1 do Action content in Tool0,
                    serve content in Tool0 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodDoOnContentInWithContentInAction_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool0[contain: ingredient],
                    tool Tool1[Action: content in Tool0 => ingredient]
                },
                steps{
                    Tool0 do contain Ingredient,
                    Tool1 do Action content in Tool0,
                    serve content in Tool0 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodDoOnContentInWithContentInActionAndInheritance_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool0[contain: ingredient],
                    Tool0 Tool1[None: ingredient => ingredient],
                    tool Tool2[Action: content in Tool0 => ingredient]
                },
                steps{
                    Tool0 do contain Ingredient,
                    Tool1 do contain content in Tool0,
                    Tool2 do Action content in Tool1,
                    serve content in Tool1 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_normalActionUsingInheritedAction_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool0[Action: ingredient => ingredient],
                    Tool0 Tool1[None: ingredient => ingredient]
                },
                steps{
                    Tool0 do Action Ingredient,
                    Tool1 do Action Ingredient,
                    serve Ingredient  
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodStartStopStepNoOutStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    START Proc1 Tool do Action Ingredient,
                    STOP Proc1, 
                    serve Ingredient 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodStartStopStepWithStepOut_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    START Proc1 Tool do Action Ingredient,
                    STOP Proc1 => Ingredient0, 
                    serve Ingredient0
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodNormStepWithTypeConversion_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    spice Ingredient (to-taste)
                },
                tools{
                    tool Tool0[Action: spice => liquid],
                    tool Tool1[Action: liquid => ingredient]
                },
                steps{
                    Tool0 do Action Ingredient,
                    Tool1 do Action Ingredient,
                    serve Ingredient 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_goodStartStopStepWithOutStep_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient0 (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    START Proc1 Tool do Action Ingredient0,
                    STOP Proc1 => Ingredient1, 
                    serve Ingredient1 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);

        // assert
        assertEquals(true, actual);
    }

    @Test
    public void visitFannie_serveMissing_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_typeMismatch_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    spice Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable]
                },
                steps{
                    Tool do Action Ingredient,
                    serve Ingredient
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_typeMismatchContainAction_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    spice Ingredient (to-taste)
                },
                tools{
                    tool Tool[contain: vegetable]
                },
                steps{
                    Tool do contain Ingredient,
                    serve content in Tool
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_partialTypeMismatchContainAction_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    spice Ingredient0 (to-taste),
                    vegetable Ingredient1 (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable]
                },
                steps{
                    Tool do Action { Ingredient0, Ingredient1 } => Ingredient2,
                    serve Ingredient2
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_ContentActionTypeMismatch_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    vegetable Ingredient (to-taste)
                },
                tools{
                    tool Tool[contain: vegetable, Action: content in Tool => spice]
                },
                steps{
                    Tool do contain Ingredient,
                    Tool do Action content in Tool,
                    serve content in Tool
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_processNotStopped_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    START Doing Tool do Action  Ingredient,
                    serve Ingredient 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_ProcessWasInterrupted_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    vegetable Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable, Interrupt: vegetable => spice]
                },
                steps{
                    START Doing Tool do Action Ingredient,
                    Tool do Interrupt Ingredient,
                    STOP Doing,
                    serve Ingredient 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_duplicateProcess_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    vegetable Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable]
                },
                steps{
                    START Doing Tool do Action Ingredient,
                    START Doing Tool do Action Ingredient,
                    STOP Doing,
                    STOP Doing,
                    serve Ingredient 
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_ingredientNotDeclared_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient,
                    Tool do Action DoesNotExist,
                    serve { Ingredient, DoesNotExist }
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_toolNotDeclared_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do Action Ingredient,
                    DoesNotExist do Action Ingredient,
                    serve Ingredient
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_actionNotDeclared_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    ingredient Ingredient (to-taste)
                },
                tools{
                    tool Tool[Action: ingredient => ingredient]
                },
                steps{
                    Tool do DoesNotExist Ingredient,
                    serve Ingredient
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_contentInContainTypeMismatch_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    spice Ingredient (to-taste)
                },
                tools{
                    tool SpiceContainer[contain: spice],
                    tool VegetableContainer[contain: vegetable]
                },
                steps{
                    SpiceContainer do contain Ingredient,
                    VegetableContainer do contain content in SpiceContainer,
                    serve content in VegetableContainer
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // assert 
        assertThrows(CompilerException.class, () -> {
            // act
            interpreterVisitor.visitFannie(context);  
        });
    }

    @Test
    public void visitFannie_canUseComplexIngredient_returnTrue() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    liquid Sauce,
                    Sauce BrownSauce (to-taste)
                },
                tools{
                    tool Tool[Action: Sauce => Sauce]
                },
                steps{
                    Tool do Action BrownSauce,
                    serve BrownSauce
                }
            }
        """);
        fannieParserParser.FannieContext context = parser.fannie();
        
        // act
        Boolean actual = interpreterVisitor.visitFannie(context);  

        // assert 
        assertTrue(actual);
    }
                                                                           
                                                                           
    //                          .i;;;;i.                                  
    //                        iYcviii;vXY:                                
    //                      .YXi       .i1c.                              
    //                     .YC.     .    in7.                             
    //                    .vc.   ......   ;1c.                            
    //                    i7,   ..        .;1;                            
    //                   i7,   .. ...      .Y1i                           
    //                  ,7v     .6MMM@;     .YX,                          
    //                 .7;.   ..IMMMMMM1     :t7.                         
    //                .;Y.     ;$MMMMMM9.     :tc.                        
    //                vY.   .. .nMMM@MMU.      ;1v.                       
    //               i7i   ...  .#MM@M@C. .....:71i                       
    //              it:   ....   $MMM@9;.,i;;;i,;tti                      
    //             :t7.  .....   0MMMWv.,iii:::,,;St.                     
    //            .nC.   .....   IMMMQ..,::::::,.,czX.                    
    //           .ct:   ....... .ZMMMI..,:::::::,,:76Y.                   
    //           c2:   ......,i..Y$M@t..:::::::,,..inZY                   
    //          vov   ......:ii..c$MBc..,,,,,,,,,,..iI9i                  
    //         i9Y   ......iii:..7@MA,..,,,,,,,,,....;AA:                 
    //        iIS.  ......:ii::..;@MI....,............;Ez.                
    //       .I9.  ......:i::::...8M1..................C0z.               
    //      .z9;  ......:i::::,.. .i:...................zWX.              
    //      vbv  ......,i::::,,.      ................. :AQY              
    //     c6Y.  .,...,::::,,..:t0@@QY. ................ :8bi             
    //    :6S. ..,,...,:::,,,..EMMMMMMI. ............... .;bZ,            
    //   :6o,  .,,,,..:::,,,..i#MMMMMM#v.................  YW2.           
    //  .n8i ..,,,,,,,::,,,,.. tMMMMM@C:.................. .1Wn           
    //  7Uc. .:::,,,,,::,,,,..   i1t;,..................... .UEi          
    //  7C...::::::::::::,,,,..        ....................  vSi.         
    //  ;1;...,,::::::,.........       ..................    Yz:          
    //   v97,.........                                     .voC.          
    //    izAotX7777777777777777777777777777777777777777Y7n92:            
    //      .;CoIIIIIUAA666666699999ZZZZZZZZZZZZZZZZZZZZ6ov.              
                                                                       

    // BEWARE 
    // TESTS BEYOND THIS POINT MIGHT BE QUESTIONABLE VENTURE FORTH ON YOUR OWN RISK



}
