package fannieTypes;
import java.util.List;
import java.util.Map;

import scope.Scope;

public class Ingredient {
    public String identifier;
    public IngredientType type;
    public Ingredient parentIngredient;
    @Override 
    public String toString() {
        return "Identifier: " + identifier + "Type: " + type + "Parent: " + parentIngredient;
    }
    public Ingredient()
    {
        System.out.println(this.getClass().getName() + ": " + identifier);
    }
    public Boolean isDefaultIngredient(String type)
    {
        switch (type) {
            case "ingredient":
                return true;
                
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
    public Ingredient(String identifier, String ingredientType, Scope scope)
    {
        this.identifier = identifier;
        if (!this.type.isDefaultType(ingredientType))
        {
            for (Map.Entry<String, Object> entry : scope.getSymbolTable().entrySet()) {
                if (entry.getValue().getClass().getName().equals("IngredientType")) {
                    if(entry.getKey().equals(ingredientType))
                    {
                        this.type.parentIngredientType = (IngredientType)entry.getValue();
                        scope.appendGlobal(ingredientType, this.type);
                    }
                }
            }
        }
        //if (type.Identifier == parentIngredient.type.Identifier)
    }
    public Boolean isType(String type)
    {
        if (this.type.Identifier.equals(type))
        {
            return true;
        }
        else if(this.parentIngredient != null)
        {
            return this.parentIngredient.isType(type);
        }
        else if (this.type.isDefaultType(type))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Ingredient createIngredient(String identifier, String type, Scope scope)
    {
        Ingredient ingredient = new Ingredient(identifier, type, scope);
        scope.append(identifier, ingredient);
        return ingredient;
    }
}
