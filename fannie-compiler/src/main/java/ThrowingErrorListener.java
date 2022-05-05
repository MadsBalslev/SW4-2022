import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;

// This is taken from https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4

public class ThrowingErrorListener extends BaseErrorListener {

    public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e)
            throws ParseCancellationException {
        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}