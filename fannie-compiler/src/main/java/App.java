import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        InputStream fileContent = ReadFile.read(args[0]);
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        ParseTree tree = parser.fannie();

        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);
        // System.out.println(cgv.markdownFormat);

        WriteToFile.write("fannie.md", cgv.markdownFormat);
    }
}
