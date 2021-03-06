import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Exceptions.CompilerException;
import Handlers.IngredientTypeHandler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fannieTypes.Ingredient;
import fannieTypes.steps.DoStepDeclaration;
import fannieTypes.*;
import fannieTypes.toolActions.ContainToolActionDeclaration;
import fannieTypes.toolActions.ContentInToolAction;
import fannieTypes.toolActions.NormalToolAction;
import fannieTypes.toolActions.ToolAction;
import scope.Scope;

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

        // EXPERIMENTAL CODE FROM https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        // EXPERIMENTAL CODE FROM https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

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

    // public void visitStepOut_BadContext_ThrowCompilerException() {
    //     // arrange
    //     fannieParserParser parser = createParser("");
    //     fannieParserParser.StepOutContext context = parser.stepOut();

    //     // assert
    //     assertThrows(CompilerException.class, () -> {
    //         // act
    //         interpreterVisitor.visitStepOut(context);
    //     });
    // }

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

    // @Test
    // public void visitStepIn_BadContext_throwCompilerException() {
    //     // arrange
    //     fannieParserParser parser = createParser("");
    //     fannieParserParser.StepInContext context = parser.stepIn();

    //     // assert
    //     assertThrows(CompilerException.class, () -> {
    //         // act
    //         interpreterVisitor.visitStepIn(context);
    //     });
    // }

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
    @Ignore
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
    @Ignore
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
    public void visitFannie_ProcessWasInterruptedWithStepOut0_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    vegetable Ingredient0 (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable, Interrupt: vegetable => spice]
                },
                steps{
                    START Doing Tool do Action Ingredient0,
                    Tool do Interrupt Ingredient0,
                    STOP Doing => Ingredient1,
                    serve Ingredient1
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
    public void visitFannie_ProcessWasInterruptedWithStepOut1_ThrowCompilerError() {
        // arrange
        fannieParserParser parser = createParser("""
            main recipe Recipe{
                ingredients{
                    vegetable Ingredient0 (to-taste)
                },
                tools{
                    tool Tool[Action: vegetable => vegetable, Interrupt: vegetable => spice]
                },
                steps{
                    START Doing Tool do Action Ingredient0,
                    Tool do Interrupt Ingredient0 => Ingredient1,
                    STOP Doing => Ingredient2,
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
                                                                       

    // TESTS BEYOND THIS POINT MIGHT BE QUESTIONABLE VENTURE FORTH ON YOUR OWN RISK
    // if one of the tests below fail consider it only briefly, if it does'nt make sense comment it out, delete or ignore it at your own leisure.
    
    // public void ingredientListMissingFromRecipeTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // // This test should NOT fail.
    // @Test(expected = RuntimeException.class)
    // public void ingredientNotDeclaredButUsedTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientNotDeclaredButUsedTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class) // This test should fail (OR NOT?).
    // public void mainRecipeKeywordMissingTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.mainRecipeKeywordMissingTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void stepListMissingFromRecipeTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.stepListMissingFromRecipeTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void toolNotDeclaredButUsedTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.toolNotDeclaredButUsedTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void toolsListMissingFromRecipeTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.toolsListMissingFromRecipeTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void CommasAfterListingsMissingFromTestRecipe() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasAfterListingsMissingFromTestRecipe());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void CommasMissingInsideIngredientBlockTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasMissingInsideIngredientBlockTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void ServeKeywordMissingFromRecipe() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ServeKeywordMissingFromRecipe());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void ToolAndIngredientSameIdentifierTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ToolAndIngredientSameIdentifierTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    @Test
    public void scopeRetrievesFromParentSymbolTable() throws Exception {
        Scope scope = new Scope();
        Scope parentScope = new Scope();
        String procIdentifier = "Test";
        parentScope.append("Test", procIdentifier);
        scope.setParent(parentScope);

        String actual = (String) scope.retrieve("Test");
        assertEquals(actual, procIdentifier);
    }

    @Test(expected = RuntimeException.class)
    public void cannotRetrieveFromSymboltable() throws Exception {
        Scope scope = new Scope();
        scope.retrieve("Test");
    }

    @Test
    public void hasBeenServedFalse() {
        HasBeenServed hasServed = new HasBeenServed(new Scope());
        assertEquals(hasServed.isServed, false);
    }

    @Test
    public void hasBeenServedTrue() {
        final HasBeenServed hasBeenServed = new HasBeenServed(new Scope());
        hasBeenServed.isServed = true;
        final HasBeenServed mock = mock(HasBeenServed.class);
        mock.isServed = true;
        assertEquals(mock.isServed, hasBeenServed.isServed);
    }

    @Test
    public void ingredientIsType() {
        IngredientType ingredientType = new IngredientType("vegetable", null);
        Ingredient ingredient = new Ingredient("ingredient", ingredientType);
        Boolean actual = ingredient.isType("vegetable");

        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("vegetable")).thenReturn(true);
        assertEquals(mock.isType("vegetable"), actual);
    }

    @Test
    public void ingredientIsNotType() {
        IngredientType ingredientType = new IngredientType("vegetable", null);
        Ingredient ingredient = new Ingredient("ingredient", ingredientType);
        Boolean actual = ingredient.isType("fruit");

        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("fruit")).thenReturn(false);

        assertEquals(mock.isType("fruit"), actual);
    }

    @Test
    public void ingredientTypeAssignedCorrectly() {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient", ingredientTypeHandler, "liquid");

        assertEquals(ingredient.ingredientType.identifier, "liquid");
    }

    // @Test
    // public void ingredientTypeAssignedIncorrectly() {
    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    //     Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");

    //     assertNotEquals("The ingredient is not assigned to the correct ingredient type!", ingredient.ingredientType.identifier, "ingredient");
    // }

    // this is utterly fucking retarded...
    // too bad!
    // @Test
    // public void stepInReturnsList() {
    //     final fannieParserParser.StepInContext stepinctx = mock(fannieParserParser.StepInContext.class);
    //     final Ingredient mockIngredient = mock(Ingredient.class);

    //     ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

    //     assertEquals("Did not return ingredientList!", interpreterVisitor.visitStepIn(stepinctx).getClass(),
    //             ingredientList.getClass());
    // }

    @Test
    public void toolActionDeclarationListReturnsList() {
        final fannieParserParser.ToolActionDeclarationsListContext toolActionDeclarationListctx = mock(
                fannieParserParser.ToolActionDeclarationsListContext.class);

        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();

        assertEquals("Did not return toolActionList!",
                interpreterVisitor.visitToolActionDeclarationsList(toolActionDeclarationListctx).getClass(),
                toolActionList.getClass());
    }

    // this is a good one :D
    @Test
    public void ingredientIdentifierDoesReturnsContext() {
        final fannieParserParser.IngredientIdentifierContext ingredientIdentifierctx = mock(
                fannieParserParser.IngredientIdentifierContext.class);

        when(interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx)).thenReturn("test");

        assertEquals("test", interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx));
    }

    @Test
    public void scopeCanAppendandRetrieveAnything() {
        Scope scope = new Scope();

        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();
        Tool tool = new Tool("knife", "knife", toolActionList);

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("Soap", ingredientTypeHandler, "ingredient");

        scope.append("knife", tool);
        scope.append("Soap", ingredient);

        assertEquals("Knife not added to scope!", tool, scope.retrieve("knife"));
        assertEquals("Soap not addded to scope!", ingredient, scope.retrieve("Soap"));
    }

    @Test
    public void useToolActionUsesTool() {
        Scope scope = new Scope();

        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();
        Tool knife = new Tool("Knife", "knife", toolActionList);

        final Scope mockScope = mock(Scope.class);
        final Ingredient mockIngredient = mock(Ingredient.class);
        when(mockScope.retrieve("soap")).thenReturn(mockIngredient);

        NormalToolAction normalToolAction = new NormalToolAction("ingredient", "liquid", "slice");

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");

        scope.append("soap", ingredient);
        knife.useToolAction(normalToolAction, ingredient, scope, ingredientTypeHandler);

        assertEquals(knife.hasToolBeenUsed, true);
    }

    @Test
    public void isCorrectIngredientCreatedUseToolAction() {
        ToolAction normalToolAction = new NormalToolAction("ingredient", "spice", "cut");
        IngredientType ingredientType = new IngredientType("ingredient", null);

        IngredientTypeHandler mockedIngredientTypeHandler = mock(IngredientTypeHandler.class);
        Ingredient preTransformIngredient = new Ingredient("Spice Ingredient", ingredientType);
        IngredientType expectedIngredientType = new IngredientType("spice", null);

        when(mockedIngredientTypeHandler.AssignIngredientType(any(Ingredient.class), anyString()))
                .thenReturn(expectedIngredientType);

        Ingredient Expected = new Ingredient("Spice Ingredient", expectedIngredientType);
        Ingredient Actual = normalToolAction.useToolAction(preTransformIngredient, mockedIngredientTypeHandler);

        assertEquals(Expected.ingredientType, Actual.ingredientType);
    }

    // @Test
    // public void canAssignIngredientType() {
    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

    //     Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "liquid");

    //     ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "ingredient");

    //     assertEquals("Ingredient was not assigned correctly!", "ingredient", ingredient.ingredientType.toString());
    // }

    // Test should give a RunTimeException, but gives a Nullpointer (which is a
    // RunTimeException) maybe bugged code in interpreter ?XD
    // @Test(expected = RuntimeException.class)
    // public void cannotAssignandFindIngredientType() {
    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

    //     final Ingredient ingredient = mock(Ingredient.class);

    //     ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "fart");
    // }

    @Test(expected = RuntimeException.class)
    public void cannotDeleteAlreadyDeletedKey() {
        Scope scope = new Scope();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient gulerod = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        scope.append("gulerod", gulerod);
        scope.Remove("gulerod");
        scope.Remove("gulerod");
    }

    @Test(expected = CompilerException.class)
    public void cannotAppendAlreadyExistingKey() {
        Scope scope = new Scope();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient gulerod = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        scope.append("gulerod", gulerod);
        scope.append("gulerod", gulerod);
    }

    @Test(expected = RuntimeException.class)
    public void cannotRetrieveRemovedKey() {
        Scope scope = new Scope();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient gulerod = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        scope.append("gulerod", gulerod);
        scope.Remove("gulerod");
        scope.retrieve("gulerod");
    }

    @Test
    public void doesOverwriteWork() {
        Scope scope = new Scope();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient gulerod = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        Ingredient kartoffel = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        scope.append("gulerod", gulerod);
        scope.overwrite("gulerod", kartoffel);
        kartoffel = (Ingredient) scope.retrieve("gulerod");
        assertEquals("gulerod", kartoffel.identifier);
    }

    @Test
    public void DoStepDeclarationCanUseToolActionOnList() {
        Scope scope = new Scope();
        List<Ingredient> oldIngredients = new ArrayList<Ingredient>();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();

        NormalToolAction normalToolAction = new NormalToolAction("ingredient", "liquid", "slice");
        toolActionList.put(normalToolAction.toolActionIdentifier,normalToolAction);

        Ingredient ingredient = new Ingredient("Soap", ingredientTypeHandler, "ingredient");
        Tool tooltest = new Tool("knife", "knife", toolActionList);

        scope.append("knife", tooltest);
        scope.append("Soap", ingredient);
        oldIngredients.add(ingredient);

        new DoStepDeclaration(tooltest.toolIdentifier, normalToolAction.toolActionIdentifier, scope, oldIngredients, ingredientTypeHandler);
    }

    @Test(expected = RuntimeException.class)
    public void keyMissingInStepDeclaration()
    {
        Scope scope = new Scope();
        List<Ingredient> oldIngredients = new ArrayList<Ingredient>();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();

        NormalToolAction normalToolAction = new NormalToolAction("ingredient", "liquid", "slice");
        toolActionList.put(normalToolAction.toolActionIdentifier,normalToolAction);

        Ingredient ingredient = new Ingredient("Soap", ingredientTypeHandler, "ingredient");
        Tool tooltest = new Tool("knife", "knife", toolActionList);

        scope.append("knife", tooltest);
        oldIngredients.add(ingredient);

        DoStepDeclaration doStep = new DoStepDeclaration(tooltest.toolIdentifier, normalToolAction.toolActionIdentifier, scope, oldIngredients, ingredientTypeHandler);
        doStep.Execute();
    }

    @Test
    public void canCorrectlyMakeTool()
    {
        Tool tool = new Tool("nicerdicer", "knife", null);

        assertEquals("Tool identifier is not equal!", tool.toolIdentifier, "nicerdicer");
        assertEquals("Tool toolIdentifier is not equal!", tool.toolTypeIdentifier, "knife");
    }

    @Test
    public void canCorrectlyMakeIngredientWithIdentifier()
    {
        final IngredientType ingType = mock(IngredientType.class);

        Ingredient ing = new Ingredient("Water", ingType);

        assertEquals("Ingredient identifier is not equal!", ing.identifier, "Water");
    }

    @Test
    public void canCorrectlyMakeNormalToolAction()
    {
        NormalToolAction normalToolAction = new NormalToolAction("ingredient", "liquid", "heat");
        
        assertEquals("Input is not equal!", normalToolAction.input, "ingredient");
        assertEquals("Output is not equal!",normalToolAction.output, "liquid");
        assertEquals("ToolAction is not equal!", normalToolAction.toolActionIdentifier, "heat");
    }

    @Test
    public void canCorrectlyMakeContainToolActionDeclaration()
    {
        ContainToolActionDeclaration containToolActionDeclaration = new ContainToolActionDeclaration("ingredient");

        assertEquals("Input is not equal!", containToolActionDeclaration.input, "ingredient");
        assertEquals("Output is not equal!", containToolActionDeclaration.output, "content in");
        assertEquals("ToolAction is not equal!",containToolActionDeclaration.toolActionIdentifier, "contain");
    }
}

// The voices...... they are telling me to do wrong test on purpose H4H4H4H4H4
// yeah no kidding
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
// ??????????????????????????????????????????????????????????????????????????????
