package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;
import Exceptions.*;


public class ContentInToolAction extends ToolAction {
    public ContentInToolAction(String input, String output, String ToolAction)
    {
        this.input = input;
        this.output = output;
        this.toolActionIdentifier = ToolAction;
    }
    @Override 
    public Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler, String toolIdentifier)
    {
        throw new CompilerException("ContentInToolAction is not valid");
    }
}
