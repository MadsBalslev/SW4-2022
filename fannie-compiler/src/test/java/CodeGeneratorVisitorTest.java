import static org.junit.Assert.assertTrue;

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

public class CodeGeneratorVisitorTest {
    ParseTree tree;
    CodeGeneratorVisitor cgv;
    File file;
    File testFile = new File("/fannie-compiler/fannie.md");
    String[] ingredients = {
            "- Testingredient (1kg, 1 whole)",
            "- Testingredient2 (1g, 1 tbsp)",
            "- Testingredient3 (1g, 1 tsp)",
            "- Testingredient4 (1g, 1 pinch)",
            "- Testingredient5 (1g, 1 whole)",
            "- Testingredient6 (1g, 1 half)",
            "- Testingredient7 (1g, 1 third)",
            "- Testingredient8 (1g, 1 quarter)",
            "- Testingredient9 (1g, 1 eight)",
            "- Testingredient10 (to-taste)",
            "- TestingredientG (1g)",
            "- TestingredientKG (1kg)",
            "- TestingredientML (1ml)",
            "- TestingredientDL (1dl)",
            "- TestingredientL (1l)",
            "- TestingredientMG (1mg)",
            "- TestingredientLB (1lb)",
            "- TestingredientOZ (1oz)",
            "- TestingredientING (1g)",
            "- TestingredientVEG (1g)",
            "- TestingredientFRU (1g)",
            "- TestingredientMEA (1g)",
            "- TestingredientLIQ (1g)",
            "- TestingredientSPI (1g)",
            "- TestingredientNUT (1g)",
            "- TestingredientDRY (1g)"
    };

    String[] tools = {
            "- TestPOT",
            "- TestSTOVE",
            "- Knife"
    };

    String[] steps = {
            "1. Put TestingredientLIQ in TestPOT",
            "2. Slice TestingredientMEA with Knife",
            "3. Put TestingredientMEA in TestPOT",
            "4. serve the content in TestPOT",
    };

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void init() throws IOException {
        InputStream fileContent = ReadFile.read("../RecipeExamples/Test.fannie");
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        tree = parser.fannie();
        cgv = new CodeGeneratorVisitor();
        file = new File(folder.getRoot() + "/Pasta.test.md");
        cgv.visit(tree);
    }

    @Test
    public void shouldCreateFile() throws IOException {
        WriteToFile.write(file.getAbsolutePath(), cgv.markdownFormat.toString());
        assertTrue("File was created", file.exists());
    }

    @Test
    public void shouldHaveHeading() {
        String S = cgv.markdownFormat.toString();

        assertTrue("Does not contain Test heading", S.contains("# Test"));
    }

    @Test
    public void shouldHaveIngredientHeader() {
        String S = cgv.markdownFormat.toString();

        assertTrue("Does not contain Ingredients heading", S.contains("### Ingredients"));
    }

    @Test
    public void shouldHaveCorrectIngredients() {
        String S = cgv.markdownFormat.toString();
        for (String ing : ingredients) {
            assertTrue("Does not contain " + ing, S.contains(ing));
        }
    }

    @Test
    public void shouldHaveToolheader() {
        String S = cgv.markdownFormat.toString();

        assertTrue("Does not contain Tools heading", S.contains("### Tools"));
    }

    @Test
    public void shouldHaveCorrectTools() {
        String S = cgv.markdownFormat.toString();

        for (String tool : tools) {
            assertTrue("Does not contain " + tool, S.contains(tool));
        }
    }

    @Test
    public void shouldHaveStepheader() {
        String S = cgv.markdownFormat.toString();

        assertTrue("Does not contain Steps heading", S.contains("### Steps"));
    }

    @Test
    public void shouldhaveCorrectSteps() {
        String S = cgv.markdownFormat.toString();

        for (String step : steps) {
            assertTrue("Does not contain" + step, S.contains(step));
        }
    }
}
