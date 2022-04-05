import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("### Antal argumenter:" + args[0]);
        InputStream fileContent = ReadFile.read(args[0]);

        // create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(fileContent);
        
        // create a lexer that feeds off of input CharStream
        fannieParserLexer lexer = new fannieParserLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        fannieParserParser parser = new fannieParserParser(tokens);

        ParseTree tree = parser.fannie(); // begin parsing at init rule

        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        cgv.visit(tree);

        System.out.println(cgv.markdownFormat); // print LISP-style tree
        
        
        WriteToFile.write("fannie", cgv.markdownFormat);
    }
}
