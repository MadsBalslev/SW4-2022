package fannieTypes;
import java.util.ArrayList;
import java.util.List;
import Handlers.IngredientTypeHandler;
import fannieTypes.toolActions.*;
import scope.Scope;
public class Tool extends BaseFannieType{
    public String toolTypeIdentifier;
    public String toolIdentifier;
    public List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();
    public Boolean hasToolBeenUsed = false;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toolIdentifier + ": " + toolTypeIdentifier + "\n Toolactions \n");
        for (ToolAction toolAction : toolActionDeclarationsList) {
            sb.append(toolAction.toString() + "\n");
        }

        return sb.toString();
    }
    public Tool(String toolIdentifier, String toolTypeIdentifier,List<ToolAction> toolActionList)
    {
        super(toolIdentifier, "Tool");
        this.toolIdentifier = toolIdentifier;
        this.toolTypeIdentifier = toolTypeIdentifier;
        this.toolActionDeclarationsList = toolActionList;
        
    }
    public ToolAction getToolAction(String toolActionIdentifier) throws Exception
    {
        for (ToolAction toolActionDeclaration : toolActionDeclarationsList) {
            if (toolActionDeclaration.toolActionIdentifier.contains(toolActionIdentifier)) {
                return toolActionDeclaration;
            }
        }
        throw new RuntimeException("ToolAction not found");
    }
    
    
    public void useToolAction(ToolAction toolAction, Ingredient ingredient, Scope scope, IngredientTypeHandler ingredientTypeHandler)
    {
        if (toolAction instanceof ContainToolActionDeclaration)
        {
             Ingredient newIngredient = toolAction.useToolAction(ingredient, ingredientTypeHandler, this.identifier);
             this.hasToolBeenUsed = true;
             scope.Remove(ingredient.identifier);
             scope.append(newIngredient.identifier, newIngredient);
        }
        else
        {
            Ingredient newIngredient = toolAction.useToolAction(ingredient, ingredientTypeHandler);
            this.hasToolBeenUsed = true;
             scope.Remove(ingredient.identifier);
             scope.append(newIngredient.identifier, newIngredient);
        }
    }

    public Boolean getHasToolBeenUsed()
    {
        return this.hasToolBeenUsed;
    }
}
