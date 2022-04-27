import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;



import java.io.FileInputStream;
import java.io.InputStream;
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor();
        String inputFile = null;
        if(args.length>0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        ParseTree tree = parser.fannie();
        try {
            interpreterVisitor.visit(tree);
        } catch (Exception e) {
            System.err.println(e);
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
