package fannieTypes;
import java.util.HashMap;
import Handlers.IngredientTypeHandler;
import fannieTypes.toolActions.*;
import scope.Scope;
public class Tool extends BaseFannieType{
    public String toolTypeIdentifier;
    public String toolIdentifier;
    private HashMap<String, ToolAction> toolActionDeclarationsList = new HashMap<String, ToolAction>();
    public Boolean hasToolBeenUsed = false;
    
    public Tool(String toolIdentifier, String toolTypeIdentifier,HashMap<String, ToolAction> toolActionList)
    {
        super(toolIdentifier, "Tool");
        this.toolIdentifier = toolIdentifier;
        this.toolTypeIdentifier = toolTypeIdentifier;
        this.toolActionDeclarationsList = toolActionList;
        
    }

    public ToolAction getToolAction(String toolActionIdentifier) throws Exception
    {
        if(toolActionDeclarationsList.containsKey(toolActionIdentifier))
            return toolActionDeclarationsList.get(toolActionIdentifier);
        else
            throw new RuntimeException("ToolAction not found");
    }
    
    public void useToolAction(ToolAction toolAction, Ingredient ingredient, Scope scope, IngredientTypeHandler ingredientTypeHandler)
    {
        if (toolAction instanceof ContainToolActionDeclaration)
        {
             Ingredient newIngredient = toolAction.useToolAction(ingredient, ingredientTypeHandler, this.identifier);
             this.hasToolBeenUsed = true;
             scope.Remove(ingredient.identifier);
             scope.overwrite(newIngredient.identifier, newIngredient);
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

    public HashMap<String, ToolAction> getToolActionDeclarationsList()
    {
        return this.toolActionDeclarationsList;
    }
}
