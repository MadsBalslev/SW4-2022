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

}
