package fannieTypes;

public class IngredientType extends BaseFannieType {
    public IngredientType parentIngredientType;
    public String Identifier;
    public IngredientType(String identifier, IngredientType parentIngredientType) {
        super(identifier, "IngredientType");
        this.Identifier = identifier;
        this.parentIngredientType = parentIngredientType;
    }

    public Boolean isType(String type)
    {
        if (this.Identifier.equals(type))
        {
            return true;
        }
        else if (this.parentIngredientType != null)
        {
            return this.parentIngredientType.isType(type);
        }
        else
        {
            return false;
        }
    }
    
    public Boolean isDefaultType(String Type) {
        switch (Type) {
            case "ingredient":
                return true;
            case "Vegetable":
                return true;
            case "Fruit":
                return true;
            case "Meat":
                return true;
            case "liquid":
                return true;
            case "Spice":
                return true;
            case "Nut":
                return true;
            case "Dry":
                return true;
            case "Content in":
                return true;
            default:
                return false;
        }
    }
    
    public String toString()
    {
        return this.Identifier;
    }
}
