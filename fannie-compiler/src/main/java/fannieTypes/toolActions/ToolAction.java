package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;
public abstract class ToolAction {
    public String toolActionIdentifier;
    public String input;
    public String output;
    //debug code
    public String toString() {
        return toolActionIdentifier + ": " + input + " -> " + output;
    }
    //debug code
    
    public Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler)
    {
        if(ingredient.isType(input))
        {
            Ingredient newIngredient = new Ingredient(ingredient.identifier, ingredientTypeHandler, output);
            return newIngredient;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
