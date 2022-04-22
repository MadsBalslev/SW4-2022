package fannieTypes;



public class IngredientType {

    public IngredientType parentIngredientType;
    public String Identifier;
    public IngredientType(String identifier, IngredientType parentIngredientType) {
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

        StringBuilder sb = new StringBuilder();
        sb.append("IngredientType Identifier: " + this.Identifier);
        if( this.parentIngredientType != null)
        {
            sb.append(" Parent IngredientType: " + this.parentIngredientType.Identifier+ "\n");
        }
        return sb.toString();
    }
    
}
