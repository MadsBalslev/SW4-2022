import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
// import org.junit.Rule;
import org.junit.Test;
// import org.junit.rules.TemporaryFolder;

import Handlers.IngredientTypeHandler;
// import fannieParserParser.IngredientIdentifierContext;
// import fannieParserParser.ToolDeclarationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import fannieTypes.Ingredient;
import fannieTypes.*;
import scope.Scope;
// import Handlers.IngredientTypeHandler;


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

    @Test(expected = RuntimeException.class)
    public void ingredientListMissingFromRecipeTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());

        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
    }

    public ToolAction createToolAction(fannieParserParser.ToolActionDeclarationContext context) {
        ToolAction toolAction = new ToolAction();
        if (context.getChild(0) instanceof TerminalNode)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = "content in";
            toolAction.toolActionIdentifier = "contain";
        }
        /* we have to check if the first ingredienttype identifier is  contentin,
        since it changes whether ingredienttypeidentifier(0) is the original or transformed ingredient */
        else if (context.getChild(2) instanceof fannieParserParser.ContentInContext) {
            toolAction.ingredientTypeIdentifier = context.contentIn().CONTENT_IN().getText();
            toolAction.transformedIngredientTypeIdentifier= context.ingredientTypeIdentifier(0).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
        } 
        else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = context.ingredientTypeIdentifier(1).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
        }
        
        return toolAction;
    }



    // @Test(expected = RuntimeException.class)
    // public void ingredientListMissingFromRecipeTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    // @Test(expected = RuntimeException.class)
    // public void ingredientNotDeclaredButUsedTest() throws IOException {
    //     CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());

    //     fannieParserLexer lexer = new fannieParserLexer(input);
    //     CommonTokenStream tokens = new CommonTokenStream(lexer);
    //     fannieParserParser parser = new fannieParserParser(tokens);
    //     ParseTree tree = parser.fannie();

    //     interpreterVisitor.visit(tree);
    // }

    @Test(expected = RuntimeException.class)
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
    public void ingredientDeclarationReturnsIngredient()
    {
        fannieParserParser.IngredientDeclarationContext ingredientDeclarationctx = mock(fannieParserParser.IngredientDeclarationContext.class);

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient", ingredientTypeHandler, "onion", new Scope());

        when(interpreterVisitor.visitIngredientDeclaration(ingredientDeclarationctx)).thenReturn(ingredient);
    }
    
    @Test(expected = RuntimeException.class)
    public void ToolAndIngredientSameIdentifierTest() throws IOException {
        CharStream input = CharStreams.fromStream(RecipeTestStrings.ToolAndIngredientSameIdentifierTest());

    }
    
    @Test
    public void scopeRetrievesFromParentSymbolTable () throws Exception
    {
        Scope scope = new Scope();
        Scope parentScope = new Scope();
        ProcIdentifier procIdentifier = new ProcIdentifier("Test");
        parentScope.append("Test", procIdentifier);
        scope.setParent(parentScope);
                
        ProcIdentifier actual = (ProcIdentifier)scope.retrieve("Test");
        assertEquals(actual, procIdentifier);
    }
    @Test(expected = RuntimeException.class)
    public void cannotRetrieveFromSymboltable() throws Exception
    {
        Scope scope = new Scope();
        scope.retrieve("Test");
    }
    
    @Test
    public void isDefaultIngredient()
    {
        IngredientType ingredientType = new IngredientType("ingredient", null);
        Boolean actual = ingredientType.isDefaultType("ingredient");
        assertEquals(true, actual);
    }
    @Test
    public void isNotDefaultIngredient()
    {
        IngredientType ingredientType = new IngredientType("Ingredient", null);
        Boolean actual = ingredientType.isDefaultType("Ingredient");
        assertEquals(actual, false);
    }
    @Test
    public void hasBeenServedFalse()
    {
        HasBeenServed hasServed = new HasBeenServed(new Scope());
        assertEquals(hasServed.isServed, false);
    }
    @Test
    public void hasBeenServedTrue()
    {
        final HasBeenServed hasBeenServed = new HasBeenServed(new Scope());
        hasBeenServed.isServed = true;
        final  HasBeenServed mock = mock(HasBeenServed.class);
        mock.isServed = true;
        assertEquals(mock.isServed, hasBeenServed.isServed);
    }

    @Test
    public void ingredientIsType()
    {
        IngredientType ingredientType = new IngredientType("vegetable", null);
        Ingredient ingredient = new Ingredient("ingredient", ingredientType, new Scope());
        Boolean actual = ingredient.isType("vegetable");
        
        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("vegetable")).thenReturn(true);
        assertEquals(mock.isType("vegetable"), actual);
    }

    @Test 
    public void ingredientIsNotType()
    {
        IngredientType ingredientType = new IngredientType("vegetable", null);
        Ingredient ingredient = new Ingredient("ingredient", ingredientType, new Scope());
        Boolean actual = ingredient.isType("fruit");
        
        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("fruit")).thenReturn(false);

        assertEquals(mock.isType("fruit"), actual);
    }

    @Test 
    public void ingredientTypeAssignedCorrectly()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient",ingredientTypeHandler,"liquid", new Scope());

        assertEquals(ingredient.ingredientType.Identifier, "liquid");
    }
    @Test(expected = RuntimeException.class)
    public void ingredientTypeAssignedIncorrectly()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient",ingredientTypeHandler,"mushroom", new Scope());

        assertEquals(ingredient.identifier, "liquid");
    }

    @Test(expected = RuntimeException.class)
    public void toolActionisnotToolAction()
    {
        final fannieParserParser.ToolActionDeclarationContext toolactionctx = mock(fannieParserParser.ToolActionDeclarationContext.class);
        ToolAction fakeToolAction = createToolAction(toolactionctx);

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient",ingredientTypeHandler,"mushroom", new Scope());

        assertEquals("ToolAction is not equal to type Ingredient!",ingredient, fakeToolAction);
    }

    @Test
    public void stepInReturnsList()
    {
        final fannieParserParser.StepInContext stepinctx = mock(fannieParserParser.StepInContext.class);
        final Ingredient mockIngredient = mock(Ingredient.class);

        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

        assertEquals("Did not return ingredientList!",interpreterVisitor.visitStepIn(stepinctx).getClass(), ingredientList.getClass());

    }

    @Test
    public void toolActionDeclarationListReturnsList()
    {
        final fannieParserParser.ToolActionDeclarationsListContext toolActionDeclarationListctx = mock(fannieParserParser.ToolActionDeclarationsListContext.class);

        List<ToolAction> toolActionList = new ArrayList<ToolAction>();

        assertEquals("Did not return toolActionList!",interpreterVisitor.visitToolActionDeclarationsList(toolActionDeclarationListctx).getClass(), toolActionList.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void ingredientIdentifierDoesNotReturnOldIngredient()
    {
        final fannieParserParser.IngredientIdentifierContext ingredientIdentifierctx = mock(fannieParserParser.IngredientIdentifierContext.class);

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient oldIngredient = new Ingredient("Potato", ingredientTypeHandler, "ingredient", new Scope());


        assertEquals(interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx), oldIngredient.getClass());
    }

    @Test
    public void toolDeclarationAddedToScope()
    {
        List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();
        Scope scope = new Scope();
        Tool tool = new Tool("knife", "knife", toolActionDeclarationsList, scope);

        scope.append(tool.toolIdentifier, tool);
        assertEquals("Knife not added to scope!", tool, scope.retrieve(tool.toolTypeIdentifier));
    }

    @Test
    public void canCreateIngredient()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", new Scope());
    }
   
    @Test(expected = RuntimeException.class)
    public void cannotCreateIngredientDueToType()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "non-existent type", new Scope());
    }

    @Test
    public void procIdentiferReturnsValue()
    {
        ProcIdentifier procIdentifier = new ProcIdentifier("Value");

        assertEquals("Value", procIdentifier.getValue());
    }

    @Test
    public void procIdentifierReturnsWrongValue()
    {
        ProcIdentifier procIdentifier = new ProcIdentifier("Value");

        assertEquals("getValue is not equal to expected string!","fakeValue", procIdentifier.getValue());
    }

    @Test
    public void canCreateTool()
    {
        List<ToolAction> toolActionList = new ArrayList<ToolAction>();
        Tool tool = new Tool("Knife", "knife", toolActionList, new Scope());
    }

    @Test
    public void canCreateToolActionAndAssignValues()
    {
        ToolAction toolAction = new ToolAction();
        toolAction.toolActionIdentifier = "slice";
        toolAction.toolIdentifier = "Knife";
        toolAction.transformedIngredientTypeIdentifier = "sliced";
        toolAction.ingredientTypeIdentifier = "ingredient";
    }

    @Test
    public void useToolActionUsesTool()
    {
        Scope scope = new Scope();

        List<ToolAction> toolActionList = new ArrayList<>();
        Tool knife = new Tool("Knife", "knife", toolActionList, scope);

        ToolAction toolAction = new ToolAction();
        toolAction.toolActionIdentifier = "slice";
        toolAction.toolIdentifier = "Knife";
        toolAction.transformedIngredientTypeIdentifier = "liquid";
        toolAction.ingredientTypeIdentifier = "ingredient";

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


        knife.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);

        assertEquals(knife.hasToolBeenUsed, true);
    }

    @Test(expected = RuntimeException.class)
    public void useToolActionTransformsToIngredientOutOfScope()
    {
        Scope scope = new Scope();

        List<ToolAction> toolActionList = new ArrayList<>();
        Tool knife = new Tool("Knife", "knife", toolActionList, scope);

        ToolAction toolAction = new ToolAction();
        toolAction.toolActionIdentifier = "slice";
        toolAction.toolIdentifier = "Knife";
        toolAction.transformedIngredientTypeIdentifier = "sliceddicer";
        toolAction.ingredientTypeIdentifier = "ingredient";

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


        knife.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);

        assertEquals(knife.hasToolBeenUsed, true);
    }

    @Test(expected = RuntimeException.class)
    public void useToolActionUsesWrongScope()
    {
        Scope scope = new Scope();
        Scope wrongScope = new Scope();

        List<ToolAction> toolActionList = new ArrayList<>();
        Tool knife = new Tool("Knife", "knife", toolActionList, scope);

        ToolAction toolAction = new ToolAction();
        toolAction.toolActionIdentifier = "slice";
        toolAction.toolIdentifier = "Knife";
        toolAction.transformedIngredientTypeIdentifier = "";
        toolAction.ingredientTypeIdentifier = "ingredient";

        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


        knife.useToolAction(toolAction, ingredient, wrongScope, ingredientTypeHandler);

        assertEquals(knife.hasToolBeenUsed, true);
    }

    @Test
    public void canGetHasToolBeenUsedValue()
    {
        Scope scope = new Scope();

        List<ToolAction> toolActionList = new ArrayList<>();
        Tool knife = new Tool("Knife", "knife", toolActionList, scope);

        // ToolAction toolAction = new ToolAction();
        // toolAction.toolActionIdentifier = "slice";
        // toolAction.toolIdentifier = "Knife";
        // toolAction.transformedIngredientTypeIdentifier = "liquid";
        // toolAction.ingredientTypeIdentifier = "ingredient";

        // IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        // Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


        // knife.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);

        knife.getHasToolBeenUsed();
    }

    @Test(expected = RuntimeException.class)
    public void cannotGetHasToolBeenUsedValue()
    {
        Scope scope = new Scope();
        Scope wrongScope = new Scope();

        List<ToolAction> toolActionList = new ArrayList<ToolAction>();
        Tool knife = new Tool("Knife", "knife", toolActionList, scope);

        // ToolAction toolAction = new ToolAction();
        // toolAction.toolActionIdentifier = "slice";
        // toolAction.toolIdentifier = "Knife";
        // toolAction.transformedIngredientTypeIdentifier = "liquid";
        // toolAction.ingredientTypeIdentifier = "ingredient";

        // IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        // Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


        // knife.useToolAction(toolAction, ingredient, wrongScope, ingredientTypeHandler);

        knife.getHasToolBeenUsed();
    }


    
}
