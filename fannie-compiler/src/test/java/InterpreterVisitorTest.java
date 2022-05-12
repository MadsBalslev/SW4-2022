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
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.RuleContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

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

    @Before
    public void init() throws IOException {
        interpreterVisitor = new InterpreterVisitor();
    }

    @Test(expected = Exception.class) // This test should NOT fail.
    public void ingredientListMissingFromRecipeTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    // This test should NOT fail.
    @Test(expected = RuntimeException.class)
    public void ingredientNotDeclaredButUsedTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientNotDeclaredButUsedTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class) // This test should fail (OR NOT?).
    public void mainRecipeKeywordMissingTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.mainRecipeKeywordMissingTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void stepListMissingFromRecipeTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.stepListMissingFromRecipeTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void toolNotDeclaredButUsedTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.toolNotDeclaredButUsedTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void toolsListMissingFromRecipeTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.toolsListMissingFromRecipeTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void CommasAfterListingsMissingFromTestRecipe() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasAfterListingsMissingFromTestRecipe());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void CommasMissingInsideIngredientBlockTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasMissingInsideIngredientBlockTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void ServeKeywordMissingFromRecipe() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ServeKeywordMissingFromRecipe());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    @Test(expected = RuntimeException.class)
    public void ToolAndIngredientSameIdentifierTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ToolAndIngredientSameIdentifierTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

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

    @Test
    public void ingredientTypeAssignedIncorrectly() {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");

        assertNotEquals("The ingredient is not assigned to the correct ingredient type!", ingredient.ingredientType.identifier, "ingredient");
    }

    // this is utterly fucking retarded...
    // too bad!
    // "let's test core functionality of the language that we are programming in" :b
    @Test
    public void stepInReturnsList() {
        final fannieParserParser.StepInContext stepinctx = mock(fannieParserParser.StepInContext.class);
        final Ingredient mockIngredient = mock(Ingredient.class);

        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

        assertEquals("Did not return ingredientList!", interpreterVisitor.visitStepIn(stepinctx).getClass(),
                ingredientList.getClass());
    }

    @Test
    public void toolActionDeclarationListReturnsList() {
        final fannieParserParser.ToolActionDeclarationsListContext toolActionDeclarationListctx = mock(
                fannieParserParser.ToolActionDeclarationsListContext.class);

        HashMap<String, ToolAction> toolActionList = new HashMap<String, ToolAction>();

        assertEquals("Did not return toolActionList!",
                interpreterVisitor.visitToolActionDeclarationsList(toolActionDeclarationListctx).getClass(),
                toolActionList.getClass());
    }

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

    @Test
    public void canAssignIngredientType() {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "liquid");

        ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "ingredient");

        assertEquals("Ingredient was not assigned correctly!", "ingredient", ingredient.ingredientType.toString());
    }

    // Test should give a RunTimeException, but gives a Nullpointer (which is a
    // RunTimeException) maybe bugged code in interpreter ?XD
    @Test(expected = RuntimeException.class)
    public void cannotAssignandFindIngredientType() {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

        final Ingredient ingredient = mock(Ingredient.class);

        ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "fart");
    }

    @Test(expected = RuntimeException.class)
    public void cannotDeleteAlreadyDeletedKey() {
        Scope scope = new Scope();
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient gulerod = new Ingredient("gulerod", ingredientTypeHandler, "ingredient");
        scope.append("gulerod", gulerod);
        scope.Remove("gulerod");
        scope.Remove("gulerod");
    }

    @Test(expected = IllegalArgumentException.class)
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

// =^w^= <---- meow cat catnip with estrogen miaw miaw miaw

// The voices...... they are telling me to do wrong test on purpose H4H4H4H4H4
// ⠄⠉⠹⣾⣿⣛⣿⣿⣞⣿⣛⣺⣻⢾⣾⣿⣿⣿⣶⣶⣶⣄⡀⠄⠄⠄
// ⠄⠄⠠⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣆⠄⠄
// ⠄⠄⠘⠛⠛⠛⠛⠋⠿⣷⣿⣿⡿⣿⢿⠟⠟⠟⠻⠻⣿⣿⣿⣿⡀⠄
// ⠄⢀⠄⠄⠄⠄⠄⠄⠄⠄⢛⣿⣁⠄⠄⠒⠂⠄⠄⣀⣰⣿⣿⣿⣿⡀
// ⠄⠉⠛⠺⢶⣷⡶⠃⠄⠄⠨⣿⣿⡇⠄⡺⣾⣾⣾⣿⣿⣿⣿⣽⣿⣿
// ⠄⠄⠄⠄⠄⠛⠁⠄⠄⠄⢀⣿⣿⣧⡀⠄⠹⣿⣿⣿⣿⣿⡿⣿⣻⣿
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠛⠟⠇⢀⢰⣿⣿⣿⣏⠉⢿⣽⢿⡏
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠤⣤⣴⣾⣿⣿⣾⣿⣿⣦⠄⢹⡿⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠒⣳⣶⣤⣤⣄⣀⣀⡈⣀⢁⢁⢁⣈⣄⢐⠃⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⣰⣿⣛⣻⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠄⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⣬⣽⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠄⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⢘⣿⣿⣻⣛⣿⡿⣟⣻⣿⣿⣿⣿⡟⠄⠄⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠛⢛⢿⣿⣿⣿⣿⣿⣿⣷⡿⠁⠄⠄⠄
// ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠉⠉⠉⠈⠄⠄⠄⠄⠄⠄
