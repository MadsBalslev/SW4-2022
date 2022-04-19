import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;

public class Ingredient {
    public String identifier;
    public String type;
    public Ingredient parentIngredient;
    @Override 
    public String toString() {
        return "Identifier: " + identifier + "Type: " + type + "Parent: " + parentIngredient;
    }
    public Ingredient()
    {

    }
    public Boolean isDefaultIngredient(String type)
    {
        
        switch (type) {

            case "spice":
                return true;
            case "vegetable":
                
                return true;
            case "fruit":
                    
                return true;
            case "liquid":
                    
                return true;
            case "meat":
                    
                return true;
            case "dry":
                    
                return true;
            case "nut":
                    
                return true;
            case "content in":
                    
                return true;
        }
        return false;
        
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
