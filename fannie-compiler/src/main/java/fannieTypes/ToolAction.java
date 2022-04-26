package fannieTypes;
public class ToolAction {
    public String toolActionIdentifier;
    public String ingredientTypeIdentifier;
    public String transformedIngredientTypeIdentifier;
    public String toolIdentifier;
    @Override
    public String toString() {
        return toolActionIdentifier + ": " + ingredientTypeIdentifier + " -> " + transformedIngredientTypeIdentifier;
    } 
    public ToolAction() {
    }
}
