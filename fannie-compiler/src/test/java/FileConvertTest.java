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

    @Before
    public void init() throws IOException {
        InputStream fileContent = ReadFile.read("../RecipeExamples/Test.fannie");
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        tree = parser.fannie();
        cgv = new CodeGeneratorVisitor();
        HTML = FileConvert.MDToHTML(cgv.markdownFormat);
    }

    @Test
    public void doesMDConvertToHTML() {

        assertTrue("File was not converted to HTML correctly.", HTML.contains("<h> tissemand"));
    }
}