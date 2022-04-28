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
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class InterpreterVisitorTest {
      InterpreterVisitor interpreterVisitor;

      @Before
      public void init() throws IOException {
         interpreterVisitor = new InterpreterVisitor();
      }

      @Test(expected = RuntimeException.class)
      public void ingredientListMissingFromRecipeTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void ingredientNotDeclaredButUsedTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.ingredientListMissingFromRecipeTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void mainRecipeKeywordMissingTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.mainRecipeKeywordMissingTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void stepListMissingFromRecipeTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.stepListMissingFromRecipeTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void toolNotDeclaredButUsedTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.toolNotDeclaredButUsedTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void toolsListMissingFromRecipeTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.toolsListMissingFromRecipeTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void CommasAfterListingsMissingFromTestRecipe() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasAfterListingsMissingFromTestRecipe());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void CommasMissingInsideIngredientBlockTest() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.CommasMissingInsideIngredientBlockTest());
         
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

         interpreterVisitor.visit(tree);
      }

      @Test(expected = RuntimeException.class)
      public void ServeKeywordMissingFromRecipe() throws IOException
      {
         CharStream input = CharStreams.fromStream(RecipeTestStrings.ServeKeywordMissingFromRecipe());
        
         fannieParserLexer lexer = new fannieParserLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         fannieParserParser parser = new fannieParserParser(tokens);
         ParseTree tree = parser.fannie();

        interpreterVisitor.visit(tree);
      }



      // Casper er wack. Skal vi kicke ham? [X] Ja [ ] Nej
      // Skal vi lave en handleplan til ham? [ ] Ja [ ] Nej
}
