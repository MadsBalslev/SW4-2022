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
        interpreterVisitor.visit(tree);
        //System.out.println(tree.toStringTree(parser));
    }
}
