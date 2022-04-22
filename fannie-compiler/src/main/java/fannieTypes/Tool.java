package fannieTypes;
import java.util.ArrayList;
import java.util.List;
import Handlers.IngredientTypeHandler;



import scope.Scope;
public class Tool {
    public String toolTypeIdentifier;
    public String toolIdentifier;
    public List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();
    public Boolean hasToolBeenUsed = false;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toolIdentifier + ": " + toolTypeIdentifier + "\n Toolactions \n");
        for (ToolAction toolAction : toolActionDeclarationsList) {
            sb.append(toolAction.toString() + "\n");
        }
        return sb.toString();
    }
    public ToolAction getToolAction(String toolActionIdentifier) throws Exception
    {
        ToolAction toolAction = new ToolAction();
        Boolean actionFound = false;
        for (ToolAction toolActionDeclaration : toolActionDeclarationsList) {
            if (toolActionDeclaration.toolActionIdentifier.equals(toolActionIdentifier)) {
                toolAction = toolActionDeclaration;
                actionFound = true;
            }
        }
        if (actionFound == false) {
            throw new Exception("ToolAction not found");
        }
        return toolAction;
    }
    
    
    public void useToolAction(ToolAction toolAction, Ingredient ingredient, Scope scope, IngredientTypeHandler ingredientTypeHandler)
    {
        if (ingredient.isType(toolAction.ingredientTypeIdentifier))
        {
            Ingredient newIngredient = new Ingredient();
            if (toolAction.transformedIngredientTypeIdentifier.equals("content in")) newIngredient.identifier = "content in" + toolAction.toolIdentifier;
            else newIngredient.identifier = ingredient.identifier;
            newIngredient.ingredientType =  ingredientTypeHandler.AssignIngredientType(ingredient, "content in");
            System.out.println("Removed " + ingredient.identifier + " from scope");
            System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.ingredientType);
            scope.Remove(ingredient.identifier);
            scope.append(newIngredient.identifier, newIngredient);
            this.hasToolBeenUsed = true;
        }
        else
        {
            throw new RuntimeException("Ingredient type mismatch " + toolAction.ingredientTypeIdentifier + " " + ingredient.ingredientType.Identifier);
        }
    }

    public Boolean getHasToolBeenUsed()
    {
        return this.hasToolBeenUsed;
    }
}
