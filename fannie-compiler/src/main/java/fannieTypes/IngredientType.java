package fannieTypes;

public class IngredientType {
    public IngredientType parentIngredientType;
    public String Identifier;
    public IngredientType(String identifier) {
        this.Identifier = identifier;
        switch (identifier) {
            case "Vegetable":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
            case "Fruit":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
            case "Meat":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
            case "Liquid":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
            case "Spice":
                this.parentIngredientType = new IngredientType("Ingredient");                
                break;
            case "Nut":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
            case "Dry":
                this.parentIngredientType = new IngredientType("Ingredient");
                 break;
            case "Content in":
                this.parentIngredientType = new IngredientType("Ingredient");
                break;
        
            default:
                break;
        }
    }
}
