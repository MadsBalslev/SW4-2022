package fannieTypes;

import scope.Scope;

public class Ingredient {
    public String identifier;
    public IngredientType ingredientType;
    public String toString() {
        return "Ingredient Identifier: " + identifier + " IngredientType: " + ingredientType.toString();
    }

    public Ingredient()
    {
        // System.out.println(this.getClass().getName() + ": " + identifier);
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
        }
        return false;
    }

    public Ingredient(String identifier, IngredientType ingredientType, Scope scope)
    {
        this.identifier = identifier;
        this.ingredientType = ingredientType;
        //if (type.Identifier == parentIngredient.type.Identifier)
    }

    public Boolean isType(String type)
    {
        if (this.ingredientType.isType(type))
        {
            return true;
        }
        return false;
    }

    public Ingredient createIngredient(String identifier, IngredientType type, Scope scope)
    {
        Ingredient ingredient = new Ingredient(identifier, type, scope);
        scope.append(identifier, ingredient);
        return ingredient;
    }
}
