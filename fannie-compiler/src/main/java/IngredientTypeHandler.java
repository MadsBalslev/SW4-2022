import java.util.ArrayList;
import fannieTypes.*;
import java.util.List;

import java.util.Iterator;

public class IngredientTypeHandler implements Iterable<IngredientType> {
    private List<IngredientType> ingredientTypes;
    public IngredientTypeHandler() {
        this.ingredientTypes = createDefaultIngredientTypes();
    }

    private ArrayList<IngredientType> createDefaultIngredientTypes()
    {
        ArrayList<IngredientType> defaultIngredientTypes = new ArrayList<IngredientType>();
        IngredientType ingredient = new IngredientType("ingredient", null);
        IngredientType spice = new IngredientType("spice", ingredient);
        IngredientType liquid = new IngredientType("liquid", ingredient);
        IngredientType vegetable = new IngredientType("vegetable", ingredient);
        IngredientType fruit = new IngredientType("fruit", ingredient);
        IngredientType meat = new IngredientType("meat", ingredient);
        IngredientType dry = new IngredientType("dry", ingredient);
        IngredientType nut = new IngredientType("nut", ingredient);
        return defaultIngredientTypes;
    }
    @Override
    public Iterator<IngredientType> iterator() {
        return ingredientTypes.iterator();
    }

    public IngredientType AssignIngredientType(Ingredient ingredient, String ingredientTypeIdentifier)
    {
        for (IngredientType ingredientType : ingredientTypes)
        {
            if (ingredientType.Identifier.equals(ingredientTypeIdentifier))
            {
                return ingredientType;
            }
            else if (ingredient.identifier.equals(ingredientTypeIdentifier))
            {
                IngredientType newIngredientType = new IngredientType(ingredientTypeIdentifier, ingredient.type);
                ingredientTypes.add(newIngredientType);
                return newIngredientType;
            }
            else 
            {
                throw new IllegalArgumentException("IngredientType " + ingredientTypeIdentifier + " does not exist");
            }
        }
        
        return null;
    }

}
