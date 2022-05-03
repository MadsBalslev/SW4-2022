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
        IngredientType ingredientType;
        String ingredientIdentifier;
        if (ingredient.isType(toolAction.ingredientTypeIdentifier))
        {
            //newIngredient is used since it appends to the symboltable when created
            if (toolAction.transformedIngredientTypeIdentifier.equals("content in")){
                ingredientIdentifier = "content in" + toolAction.toolIdentifier;
                ingredientType =  ingredientTypeHandler.AssignIngredientType(ingredient, "content in");
                //debug code
                //System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.ingredientType);
                //debug code
                scope.Remove(ingredient.identifier);
                Ingredient newIngredient = new Ingredient(ingredientIdentifier, ingredientType);
                scope.append(newIngredient.identifier, newIngredient);
                //debug code
                System.out.println("Added " + ingredientIdentifier + " to scope");
                //debug code
                this.hasToolBeenUsed = true;
            }
            else
            { 
                //newIngredient is used since it appends to the symboltable when created
                ingredientIdentifier = ingredient.identifier;
                ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, toolAction.transformedIngredientTypeIdentifier);
                //System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.ingredientType);
                scope.Remove(ingredient.identifier);
                Ingredient newIngredient = new Ingredient(ingredientIdentifier, ingredientType);
                scope.append(newIngredient.identifier, newIngredient);
                //debug code
                System.out.println("Added " + ingredientIdentifier + " to scope");
                //debug code
                this.hasToolBeenUsed = true;
            }
            //debug code
            //System.out.println("Removed " + ingredient.identifier + " from scope");
            //debug code
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
