package fannieTypes;

import Handlers.IngredientTypeHandler;

public class Ingredient{
    public String identifier;
    public IngredientType ingredientType;
   
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

    public Ingredient(String identifier, IngredientType ingredientType)
    {
        this.identifier = identifier;
        this.ingredientType = ingredientType;
    }

    public Ingredient(String Identifier, IngredientTypeHandler ingredientTypeHandler,String ingredientTypeIdentifier)
    {
        this.identifier = Identifier;
        this.ingredientType = ingredientTypeHandler.AssignIngredientType(this, ingredientTypeIdentifier);
    }
    public Boolean isType(String type)
    {
        if (this.ingredientType.isType(type))
        {
            return true;
        }
        return false;
    }

}
