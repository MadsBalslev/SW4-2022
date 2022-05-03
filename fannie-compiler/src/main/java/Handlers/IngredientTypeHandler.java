package Handlers;
import java.util.ArrayList;
import fannieTypes.*;
import java.util.List;

public class IngredientTypeHandler {
    private List<IngredientType> ingredientTypes;
    public IngredientTypeHandler() {
        this.ingredientTypes = createDefaultIngredientTypes();
    }

    private ArrayList<IngredientType> createDefaultIngredientTypes()
    {
        //Det her kan nok gøres bedre lol
        ArrayList<IngredientType> defaultIngredientTypes = new ArrayList<IngredientType>();
        IngredientType ingredient = new IngredientType("ingredient", null);
        IngredientType spice = new IngredientType("spice", ingredient);
        IngredientType liquid = new IngredientType("liquid", ingredient);
        IngredientType vegetable = new IngredientType("vegetable", ingredient);
        IngredientType fruit = new IngredientType("fruit", ingredient);
        IngredientType meat = new IngredientType("meat", ingredient);
        IngredientType dry = new IngredientType("dry", ingredient);
        IngredientType nut = new IngredientType("nut", ingredient);
        IngredientType contentIn = new IngredientType("content in", ingredient);
        defaultIngredientTypes.add(ingredient);
        defaultIngredientTypes.add(spice);
        defaultIngredientTypes.add(liquid);
        defaultIngredientTypes.add(vegetable);
        defaultIngredientTypes.add(fruit);
        defaultIngredientTypes.add(meat);
        defaultIngredientTypes.add(dry);
        defaultIngredientTypes.add(nut);
        defaultIngredientTypes.add(contentIn);
        return defaultIngredientTypes;
    }

    public IngredientType AssignIngredientType(Ingredient ingredient, String ingredientTypeIdentifier)
    {
        System.out.println("Assigning ingredient type: " + ingredientTypeIdentifier + " to " + ingredient.identifier);
        IngredientType newIngredientType = null;
        for (IngredientType ingredientType : ingredientTypes)
        {
            if (ingredientType.Identifier.equals(ingredientTypeIdentifier))
            {
                //System.out.println("Found ingredient type: " + ingredientType.toString());
                newIngredientType = ingredientType;
                break;
            }
            else if (ingredient.identifier.equals(ingredientTypeIdentifier))
            {
                newIngredientType = new IngredientType(ingredientTypeIdentifier, ingredient.ingredientType);
                ingredientTypes.add(newIngredientType);
                break;
                
            }
        }
        if (newIngredientType != null)
        {
            return newIngredientType;
        }
        else
        {
            throw new RuntimeException("Ingredient type not found: " + ingredientTypeIdentifier);
        }
    }
}
