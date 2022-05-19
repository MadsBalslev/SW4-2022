import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import Exceptions.CompilerException;

public class App {
    public static void main(String[] args) throws Exception {
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor();
        InputStream fileContent = ReadFile.read(args[0]);
        CharStream input = CharStreams.fromStream(fileContent);
        fannieParserLexer lexer = new fannieParserLexer(input);

        // ERROR LISTENER FROM
        // https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);

        // ERROR LISTENER FROM
        // https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        ParseTree tree = parser.fannie();
        try {
            interpreterVisitor.visit(tree);
        } catch (CompilerException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);

        String HTML = FileConvert.MDToHTML(cgv.markdownFormat);
        String basePath = "../output/";
        WriteToFile.write(basePath + "output.html", HTML);
        WriteToFile.write(basePath + "output.md", cgv.markdownFormat.toString());
        try {
            FileConvert.HTMLToPDF(basePath, HTML);
        } catch (Exception e) {
            System.out.println("Could not generate PDF");
        }
        // String basePath = "./output/";
    }
}
