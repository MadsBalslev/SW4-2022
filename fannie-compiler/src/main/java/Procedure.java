
import fannieTypes.BaseFannieType;

public class Procedure extends BaseFannieType{

    fannieParserParser.DoStepDeclarationContext Step;

    public Procedure(String identifier, fannieParserParser.DoStepDeclarationContext step) {
        super(identifier, "procedure");
        Step = step;
    }
}
