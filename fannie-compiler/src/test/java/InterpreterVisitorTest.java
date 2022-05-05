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
import fannieTypes.toolActions.ToolAction;
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

    // public ToolAction createToolAction(fannieParserParser.ToolActionDeclarationContext context) {
    //     NormalToolAction toolAction = new NormalToolAction();
    //     if (context.getChild(0) instanceof TerminalNode)
    //     {
    //         toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
    //         toolAction.transformedIngredientTypeIdentifier = "content in";
    //         toolAction.toolActionIdentifier = "contain";
    //     }
    //     /* we have to check if the first ingredienttype identifier is  contentin,
    //     since it changes whether ingredienttypeidentifier(0) is the original or transformed ingredient */
    //     else if (context.getChild(2) instanceof fannieParserParser.ContentInContext) {
    //         toolAction.ingredientTypeIdentifier = context.contentIn().CONTENT_IN().getText();
    //         toolAction.transformedIngredientTypeIdentifier= context.ingredientTypeIdentifier(0).getText();
    //         toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
    //     } 
    //     else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
    //     {
    //         toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
    //         toolAction.transformedIngredientTypeIdentifier = context.ingredientTypeIdentifier(1).getText();
    //         toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
    //     }
        
    //     return toolAction;
    // }

    @Test(expected = Exception.class)
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
        Ingredient ingredient = new Ingredient("ingredient", ingredientType);
        Boolean actual = ingredient.isType("vegetable");
        
        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("vegetable")).thenReturn(true);
        assertEquals(mock.isType("vegetable"), actual);
    }

    @Test 
    public void ingredientIsNotType()
    {
        IngredientType ingredientType = new IngredientType("vegetable", null);
        Ingredient ingredient = new Ingredient("ingredient", ingredientType);
        Boolean actual = ingredient.isType("fruit");
        
        final Ingredient mock = mock(Ingredient.class);
        when(mock.isType("fruit")).thenReturn(false);

        assertEquals(mock.isType("fruit"), actual);
    }

    @Test 
    public void ingredientTypeAssignedCorrectly()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("ingredient",ingredientTypeHandler,"liquid");

        assertEquals(ingredient.ingredientType.Identifier, "liquid");
    }
    @Test
    public void ingredientTypeAssignedIncorrectly()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap",ingredientTypeHandler,"ingredient");

        assertEquals("The ingredient is not assigned to the correct ingredient type!",ingredient.typeIdentifier, "liquid");
    }

    // @Test(expected = RuntimeException.class)
    // public void toolActionisnotToolAction()
    // {
    //     final fannieParserParser.ToolActionDeclarationContext toolactionctx = mock(fannieParserParser.ToolActionDeclarationContext.class);
    //     ToolAction fakeToolAction = createToolAction(toolactionctx);

    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    //     Ingredient ingredient = new Ingredient("ingredient",ingredientTypeHandler,"mushroom");

    //     assertEquals("ToolAction is not equal to type Ingredient!",ingredient, fakeToolAction);
    // }

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

    @Test
    public void ingredientIdentifierDoesReturnsContext()
    {
        final fannieParserParser.IngredientIdentifierContext ingredientIdentifierctx = mock(fannieParserParser.IngredientIdentifierContext.class);

        when(interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx)).thenReturn("test");

        assertEquals("test", interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx));
    }

    @Test
    public void ingredientIdentifierDoesNotReturnsCorrectContext()
    {
        final fannieParserParser.IngredientIdentifierContext ingredientIdentifierctx = mock(fannieParserParser.IngredientIdentifierContext.class);

        when(interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx)).thenReturn("wrong text");

        assertEquals("The returned context is not correct!","test", interpreterVisitor.visitIngredientIdentifier(ingredientIdentifierctx));
    }

    // @Test
    // public void toolDeclarationAddedToScope()
    // {
    //     List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();
    //     Scope scope = new Scope();
    //     Tool tool = new Tool("knife", "knife", toolActionDeclarationsList, scope);

    //     scope.append(tool.toolIdentifier, tool);
    //     assertEquals("Knife not added to scope!", tool, scope.retrieve(tool.toolTypeIdentifier));
    // }

    @Test
    public void canCreateIngredient()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");
    }
   
    @Test(expected = RuntimeException.class)
    public void cannotCreateIngredientDueToType()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "non-existent type");
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
        Tool tool = new Tool("Knife", "knife", toolActionList);
    }

    // @Test
    // public void canCreateToolActionAndAssignValues()
    // {
    //     ToolAction toolAction = new ToolAction();
    //     toolAction.toolActionIdentifier = "slice";
    //     toolAction.toolIdentifier = "Knife";
    //     toolAction.transformedIngredientTypeIdentifier = "sliced";
    //     toolAction.ingredientTypeIdentifier = "ingredient";
    // }

    // @Test
    // public void useToolActionUsesTool()
    // {
    //     Scope scope = new Scope();

    //     List<ToolAction> toolActionList = new ArrayList<>();
    //     Tool knife = new Tool("Knife", "knife", toolActionList);

    //     ToolAction toolAction = new ToolAction();
    //     toolAction.toolActionIdentifier = "slice";
    //     toolAction.toolIdentifier = "Knife";
    //     toolAction.transformedIngredientTypeIdentifier = "liquid";
    //     toolAction.ingredientTypeIdentifier = "ingredient";

    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    //     Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");


    //     knife.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);

    //     assertEquals(knife.hasToolBeenUsed, true);
    // }

    // @Test(expected = RuntimeException.class)
    // public void useToolActionTransformsToIngredientOutOfScope()
    // {
    //     Scope scope = new Scope();

    //     List<ToolAction> toolActionList = new ArrayList<>();
    //     Tool knife = new Tool("Knife", "knife", toolActionList);

    //     ToolAction toolAction = new ToolAction();
    //     toolAction.toolActionIdentifier = "slice";
    //     toolAction.toolIdentifier = "Knife";
    //     toolAction.transformedIngredientTypeIdentifier = "sliceddicer";
    //     toolAction.ingredientTypeIdentifier = "ingredient";

    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    //     Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient");


    //     knife.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);

    //     assertEquals(knife.hasToolBeenUsed, true);
    // }

    // @Test(expected = RuntimeException.class)
    // public void useToolActionUsesWrongScope()
    // {
    //     Scope scope = new Scope();
    //     Scope wrongScope = new Scope();

    //     List<ToolAction> toolActionList = new ArrayList<>();
    //     Tool knife = new Tool("Knife", "knife", toolActionList, scope);

    //     ToolAction toolAction = new ToolAction();
    //     toolAction.toolActionIdentifier = "slice";
    //     toolAction.toolIdentifier = "Knife";
    //     toolAction.transformedIngredientTypeIdentifier = "";
    //     toolAction.ingredientTypeIdentifier = "ingredient";

    //     IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    //     Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "ingredient", scope);


    //     knife.useToolAction(toolAction, ingredient, wrongScope, ingredientTypeHandler);

    //     assertEquals(knife.hasToolBeenUsed, true);
    // }

    // @Test
    // public void canGetHasToolBeenUsedValue()
    // {
    //     Scope scope = new Scope();

    //     List<ToolAction> toolActionList = new ArrayList<>();
    //     Tool knife = new Tool("Knife", "knife", toolActionList, scope);

    //     knife.getHasToolBeenUsed();
    // }

    @Test
    public void canCreateIngredientTypeHandler()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    }

    @Test
    public void canCreateDefaultIngredientTypes()
    {
            ArrayList<IngredientType> defaultIngredientTypes = new ArrayList<IngredientType>();
            IngredientType ingredient = new IngredientType("ingredient", null);
            IngredientType spice = new IngredientType("spice", ingredient);
            IngredientType liquid = new IngredientType("liquid", ingredient);
            IngredientType vegetable = new IngredientType("vegetable", ingredient);
            IngredientType fruit = new IngredientType("fruit", ingredient);
            IngredientType meat = new IngredientType("meat", ingredient);
            IngredientType dry = new IngredientType("dry", ingredient);
            IngredientType nut = new IngredientType("nut", ingredient);
            IngredientType contentIn = new IngredientType("content in", ingredient);
            defaultIngredientTypes.add(ingredient);
            defaultIngredientTypes.add(spice);
            defaultIngredientTypes.add(liquid);
            defaultIngredientTypes.add(vegetable);
            defaultIngredientTypes.add(fruit);
            defaultIngredientTypes.add(meat);
            defaultIngredientTypes.add(dry);
            defaultIngredientTypes.add(nut);
            defaultIngredientTypes.add(contentIn);
    }

    @Test
    public void canCreateIngredientType()
    {
        final IngredientType ingredientTypeParent = mock(IngredientType.class);
        IngredientType ingredientType = new IngredientType("ingredient", ingredientTypeParent);
    }


    @Test
    public void canAssignIngredientType()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

        Ingredient ingredient = new Ingredient("soap", ingredientTypeHandler, "liquid");

        ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "ingredient");

        assertEquals("Ingredient was not assigned correctly!","ingredient", ingredient.ingredientType.toString());
    }

    // Test should give a RunTimeException, but gives a Nullpointer (which is a RunTimeException) maybe bugged code in interpreter ?XD
    @Test(expected = RuntimeException.class)
    public void cannotAssignandFindIngredientType()
    {
        IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();

        final Ingredient ingredient = mock(Ingredient.class);

        ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, "fart");
    }

    @Test
    public void canCreateIngredientList()
    {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
    }
    @Test
    public void canCheckIsIngredientListEmpty()
    {
        
    }


}

// =^w^= <---- meow cat catnip with estrogen miaw miaw miaw


// I will be happy =D
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