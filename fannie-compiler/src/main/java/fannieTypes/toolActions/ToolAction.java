package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;
import Exceptions.*;
public abstract class ToolAction {
    public String toolActionIdentifier;
    public String input;
    public String output;
    
    public Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler)
    {
        if(ingredient.isType(input))
        {
            Ingredient newIngredient = new Ingredient(ingredient.identifier, ingredientTypeHandler, output);
            return newIngredient;
        }
        else
        {
            throw new CompilerException("cannot use tool action " + toolActionIdentifier + " on ingredient " + ingredient.identifier);
        }
    }

    public abstract Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler, String toolIdentifier);
}
