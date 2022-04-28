import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor();
        InputStream fileContent = ReadFile.read(args[0]);
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        ParseTree tree = parser.fannie();
        interpreterVisitor.visit(tree);

        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        //cgv.visit(tree);
        // System.out.println(cgv.markdownFormat);
        String HTML = FileConvert.MDToHTML(cgv.markdownFormat);
        try {
            FileConvert.HTMLToPDF(HTML);
        } catch (Exception e) {
            System.out.println("Could not generate PDF");
        }
        //System.out.println(tree.toStringTree(parser));

        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);
        // System.out.println(cgv.markdownFormat);
        String HTML = FileConvert.MDToHTML(cgv.markdownFormat);
        try {
            FileConvert.HTMLToPDF(HTML);
        } catch (Exception e) {
            System.out.println("Could not generate PDF");
        }
        WriteToFile.write("../output/output.html", HTML);
        WriteToFile.write("../output/output.md", cgv.markdownFormat.toString());
    }
}
