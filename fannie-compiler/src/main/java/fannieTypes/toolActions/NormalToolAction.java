package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;
import Exceptions.*;


public class NormalToolAction extends ToolAction {
    public NormalToolAction(String input, String output, String ToolAction)
    {
        this.input = input;
        this.output = output;
        this.toolActionIdentifier = ToolAction;
    }
    @Override 
    public Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler, String toolIdentifier)
    {
        throw new CompilerException("NormalToolAction not valid on this tool: " + toolIdentifier);
    }

}
