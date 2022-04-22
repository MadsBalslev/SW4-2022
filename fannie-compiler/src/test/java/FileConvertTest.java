import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

public class FileConvertTest {

    ParseTree tree;
    CodeGeneratorVisitor cgv;
    File file;
    String HTML;

    String[] ingredients = {
            "<li>Testingredient (1kg, 1 whole)</li>",
            "<li>Testingredient2 (1g, 1 tbsp)</li>",
            "<li>Testingredient3 (1g, 1 tsp)</li>",
            "<li>Testingredient4 (1g, 1 pinch)</li>",
            "<li>Testingredient5 (1g, 1 whole)</li>",
            "<li>Testingredient6 (1g, 1 half)</li>",
            "<li>Testingredient7 (1g, 1 third)</li>",
            "<li>Testingredient8 (1g, 1 quarter)</li>",
            "<li>Testingredient9 (1g, 1 eight)</li>",
            "<li>Testingredient10 (to-taste)</li>",
            "<li>TestingredientG (1g)</li>",
            "<li>TestingredientKG (1kg)</li>",
            "<li>TestingredientML (1ml)</li>",
            "<li>TestingredientDL (1dl)</li>",
            "<li>TestingredientL (1l)</li>",
            "<li>TestingredientMG (1mg)</li>",
            "<li>TestingredientLB (1lb)</li>",
            "<li>TestingredientOZ (1oz)</li>",
            "<li>TestingredientING (1g)</li>",
            "<li>TestingredientVEG (1g)</li>",
            "<li>TestingredientFRU (1g)</li>",
            "<li>TestingredientMEA (1g)</li>",
            "<li>TestingredientLIQ (1g)</li>",
            "<li>TestingredientSPI (1g)</li>",
            "<li>TestingredientNUT (1g)</li>",
            "<li>TestingredientDRY (1g)</li>",
            "<li>TestSubrecipe</li>",
    };

    String[] tools = {
            "<li>TestPOT</li>",
            "<li>TestSTOVE</li>",
            "<li>Knife</li>",
    };

    String[] steps = {
            "<li>Put TestingredientLIQ in TestPOT</li>",
            "<li>Slice TestingredientMEA with Knife</li>",
            "<li>Put TestingredientMEA in TestPOT</li>",
            "<li>Put TestSubrecipe in TestPOT</li>",
            "<li>serve the content in TestPOT</li>",
    };

    @Before
    public void init() throws IOException {
        InputStream fileContent = ReadFile.read("../RecipeExamples/Test.fannie");
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        tree = parser.fannie();
        cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);
        HTML = FileConvert.MDToHTML(cgv.markdownFormat);
    }

    @Test
    public void doesHTMLContainHeader() {
        assertTrue("HTML does not contain correct header", HTML.contains("<h1>Test</h1>"));
    }

    @Test
    public void doesHTMLContainIngredients() {
        for (String ingredient : ingredients) {
            assertTrue(ingredient + "was not converted to HTML!", HTML.contains(ingredient));
        }
    }

    @Test
    public void doesHTMLContainIngredientHeader() {
        assertTrue("Does not contain correct ingredient header!", HTML.contains("<h3>Ingredients</h3>"));
    }

    @Test
    public void doesHTMLContainTools() {
        for (String tool : tools) {
            assertTrue(tool + " was not converted to HTML!", HTML.contains(tool));
        }
    }

    @Test
    public void doesHTMLContainToolHeader() {
        assertTrue("message", HTML.contains("<h3>Tools</h3>"));

    }

    @Test
    public void doesHTMLContainSteps() {
        for (String step : steps) {
            assertTrue(step + " was not converted to HTML!", HTML.contains(step));

        }
    }

    @Test
    public void doesHTMLContainStepHeader() {
        assertTrue("StepHeader was not converted to HTML!", HTML.contains("<h3>Steps</h3>"));
    }

    @Test
    public void doesHTMLContainSubRecipe() {
        assertTrue("Subrecipe header was not converted to HTML!", HTML.contains("<h1>TestSubrecipe</h1>"));
    }
}