package Handlers;
import java.util.HashMap;

import Exceptions.CompilerException;
import fannieTypes.*;

public class IngredientTypeHandler {
    private HashMap<String, IngredientType> ingredientTypes;
    public IngredientTypeHandler() {
        this.ingredientTypes = createDefaultIngredientTypes();
    }

    private HashMap<String, IngredientType> createDefaultIngredientTypes()
    {
        //Det her kan nok gøres bedre lol
        HashMap<String,IngredientType> defaultIngredientTypes = new HashMap<String, IngredientType>();
        IngredientType ingredient = new IngredientType("ingredient", null);
        IngredientType spice = new IngredientType("spice", ingredient);
        IngredientType liquid = new IngredientType("liquid", ingredient);
        IngredientType vegetable = new IngredientType("vegetable", ingredient);
        IngredientType fruit = new IngredientType("fruit", ingredient);
        IngredientType meat = new IngredientType("meat", ingredient);
        IngredientType dry = new IngredientType("dry", ingredient);
        IngredientType nut = new IngredientType("nut", ingredient);
        IngredientType contentIn = new IngredientType("content in", ingredient);
        defaultIngredientTypes.put(ingredient.identifier, ingredient);
        defaultIngredientTypes.put(spice.identifier, spice);
        defaultIngredientTypes.put(liquid.identifier, liquid);
        defaultIngredientTypes.put(vegetable.identifier, vegetable);
        defaultIngredientTypes.put(fruit.identifier, fruit);
        defaultIngredientTypes.put(meat.identifier, meat);
        defaultIngredientTypes.put(dry.identifier, dry);
        defaultIngredientTypes.put(nut.identifier, nut);
        defaultIngredientTypes.put(contentIn.identifier, contentIn);
        return defaultIngredientTypes;
    }

    public void CreateIngredientType(String superTypeIdentifier, String subTypeIdentifier )
    {
        if (ingredientTypes.containsKey(superTypeIdentifier) && !ingredientTypes.containsKey(subTypeIdentifier))
        {
            IngredientType superType = ingredientTypes.get(superTypeIdentifier);
            IngredientType ingredientType = new IngredientType(subTypeIdentifier, superType);
            ingredientTypes.put(ingredientType.identifier, ingredientType);
        }
        else if (!ingredientTypes.containsKey(superTypeIdentifier))
            throw new CompilerException(superTypeIdentifier + " is not a type... yet");
        else if (ingredientTypes.containsKey(subTypeIdentifier))
            throw new CompilerException(subTypeIdentifier + " is already declared");
        else
            throw new CompilerException(superTypeIdentifier + " " + subTypeIdentifier + " is somehow an illegal type declaration");
    }

    public IngredientType AssignIngredientType(Ingredient ingredient, String ingredientTypeIdentifier)
    {
        if (ingredientTypes.containsKey(ingredientTypeIdentifier))
        {
            ingredient.ingredientType = ingredientTypes.get(ingredientTypeIdentifier);
            return ingredientTypes.get(ingredientTypeIdentifier);
        }
        else
            throw new CompilerException(ingredientTypeIdentifier + " is not a type");
    }
}
