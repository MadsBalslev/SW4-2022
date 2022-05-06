package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;


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
        throw new IllegalArgumentException();
    }
}
