package fannieTypes;

import Handlers.IngredientTypeHandler;

public class Ingredient extends BaseFannieType {
    public String identifier;
    public IngredientType ingredientType;
    //debug code
    public String toString() {
        return "Ingredient Identifier: " + identifier + " IngredientType: " + ingredientType.toString();
    }
    //debug code
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
        super(identifier, "ingredient");
        //debug code
        System.out.println(this.getClass().getName() + ": " + identifier);
        //debug code
        this.identifier = identifier;
        this.ingredientType = ingredientType;
    }

    public Ingredient(String Identifier, IngredientTypeHandler ingredientTypeHandler,String ingredientTypeIdentifier)
    {
        super(Identifier, "ingredient");
        this.identifier = Identifier;
        this.ingredientType = ingredientTypeHandler.AssignIngredientType(this, ingredientTypeIdentifier);
    }

    public Boolean isType(String type) {
        if (this.ingredientType.isType(type)) {
            return true;
        }
        return false;
    }

}
