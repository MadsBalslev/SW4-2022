import java.util.List;

public class Ingredient {
    public String identifier;
    public String type;
    public Ingredient parentIngredient;
    @Override 
    public String toString() {
        return identifier + ": " + type;
    }
    public Ingredient parentIngredient()
    {
        return null;
    }
    public Ingredient()
    {

    }
    public Ingredient(String identifier, String type, Scope scope)
    {
        List<Ingredient> ingredients = scope.GetIngredients();
        for (Ingredient ingredient : ingredients)
        {
            if (ingredient.type.equals(identifier))
            {
                this.parentIngredient = ingredient;
                
            }
        }
        this.identifier = identifier;
        this.type = type;
    }
}
