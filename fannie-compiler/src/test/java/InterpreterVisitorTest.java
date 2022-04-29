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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import Handlers.IngredientTypeHandler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import fannieTypes.Ingredient;
import fannieTypes.*;
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

    @Test
    public void correctIngredientReturned()
    {
        final Ingredient mockIngredient = mock(Ingredient.class);
        fannieParserParser.IngredientDeclarationContext ingredientDeclarationNode = mock(fannieParserParser.IngredientDeclarationContext.class);
        when(interpreterVisitor.visitIngredientDeclaration(ingredientDeclarationNode)).thenReturn(mockIngredient);

        final Ingredient actual = interpreterVisitor.visitIngredientDeclaration(ingredientDeclarationNode);

        assertEquals(actual, mockIngredient);
    }
    
    // @Test
    // public void wrongToolActionDeclaration ()
    // {
    
    //     // public IngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
	// 	//	super(parent, invokingState);
	// 	// }
        
    //     final fannieParserParser.ToolActionDeclarationContext mockToolActionDeclarationContext = mock(fannieParserParser.ToolActionDeclarationContext.class);
    //     when(mockToolActionDeclarationContext.getChild(0)).thenReturn();

    // }
    
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
    }
   
}
