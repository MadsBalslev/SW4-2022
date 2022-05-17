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

        // EXPERIMENTAL CODE FROM https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        // parser.setErrorHandler(new BailErrorStrategy());

        // EXPERIMENTAL CODE FROM https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
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
        try {
            FileConvert.HTMLToPDF(HTML);
        } catch (Exception e) {
            System.out.println("Could not generate PDF");
        }
        // String basePath = "./output/";
        WriteToFile.write("../output/output.html", HTML);
        WriteToFile.write("../output/output.md", cgv.markdownFormat.toString());
    }
}
