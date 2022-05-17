import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.RuleContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Exceptions.CompilerException;
import Handlers.IngredientTypeHandler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import fannieTypes.Ingredient;
import fannieTypes.steps.DoStepDeclaration;
import fannieTypes.*;
import fannieTypes.toolActions.ContainToolActionDeclaration;
import fannieTypes.toolActions.NormalToolAction;
import fannieTypes.toolActions.ToolAction;
import scope.Scope;
import Handlers.IngredientTypeHandler;

public class InterpreterVisitorTest {
    InterpreterVisitor interpreterVisitor;

    private <T extends RuleContext> T mockForVisitorResult(final Class<T> nodeType, final String visitResult) {
        final T mock = mock(nodeType);
        when(mock.accept(interpreterVisitor)).thenReturn(visitResult);
        return mock;
    }

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

    // This is a bad test: the fannieParser is throwing an exception here!
    @Test(expected = Exception.class)
    @Ignore
    public void visit_ingredientListMissingFromRecipe_throwException() throws IOException {
        // arrange
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        // act
        interpreterVisitor.visit(tree);
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
        assertEquals(actual.size(), expectedSize);
        assertEquals(actual.get(0), "I0");
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
        assertEquals(actual.size(), expectedSize);
        assertEquals(actual.get(0), "I0");
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
        assertEquals(actual.size(), expectedSize);
        assertEquals(actual.get(0), ingredient0);
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
        assertEquals(actual.size(), expectedSize);
        assertEquals(actual.get(0), ingredient0);
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
        assertEquals(actual.size(), expectedSize);
        assertEquals(actual.get(0), ingredient0);
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
        assertEquals(I0.identifier, "I0");
        assertEquals(I0.ingredientType.identifier, "ingredient");
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
        assertEquals(ingredientType.identifier, "I0");
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

    
}
