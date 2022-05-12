import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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
        interpreterVisitor.visit(tree);
        

        //debug code
        //System.out.println(tree.toStringTree(parser));
        //debug code
        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);
        
        // System.out.println(cgv.markdownFormat);
        String HTML = FileConvert.MDToHTML(cgv.markdownFormat);
        try {
            FileConvert.HTMLToPDF(HTML);
        } catch (Exception e) {
            System.out.println("Could not generate PDF");
        }
        String basePath = "./output/";
        WriteToFile.write(basePath + "output.html", HTML);
        WriteToFile.write(basePath + "output.md", cgv.markdownFormat.toString());
    }
}
