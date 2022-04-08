public class ToolAction {
    public String toolActionIdentifier;
    public String ingredientTypeIdentifier;
    public String transformedIngredientTypeIdentifier; 
    @Override
    public String toString() {
        return toolActionIdentifier + ": " + ingredientTypeIdentifier + " -> " + transformedIngredientTypeIdentifier;
    }  
}
