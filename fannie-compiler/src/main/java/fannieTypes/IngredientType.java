package fannieTypes;

public class IngredientType {
    public IngredientType parentIngredientType;
    public String Identifier;
    public IngredientType(String identifier) {
        this.Identifier = identifier;
        if (this.isDefaultType(identifier)) {
            this.parentIngredientType = new IngredientType("Ingredient");
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
}
