package fannieTypes.toolActions;
import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;

public class ContainToolActionDeclaration extends ToolAction {
    
    public String toolIdentifier;
    public ContainToolActionDeclaration(String input) {
        this.input = input;
        this.output = "content in";
        this.toolActionIdentifier = "contain";
    }

    public Ingredient useToolAction(Ingredient ingredient, IngredientTypeHandler ingredientTypeHandler, String toolIdentifier)
    {
        if(ingredient.isType(input))
        {
            Ingredient newIngredient = new Ingredient("content in" + toolIdentifier, ingredientTypeHandler, output);
            return newIngredient;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}