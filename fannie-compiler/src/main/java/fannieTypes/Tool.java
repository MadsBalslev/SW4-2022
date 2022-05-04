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
        Ingredient newIngredient = toolAction.useToolAction(ingredient, ingredientTypeHandler);
        scope.Remove(ingredient.identifier);
        scope.append(newIngredient.identifier, newIngredient);
        this.hasToolBeenUsed = true;

        // if (ingredient.isType(toolAction.input))
        // {
        //     //newIngredient is used since it appends to the symboltable when created
        //     if (toolAction.output.equals("content in")){
        //         ingredientIdentifier = "content in" + toolAction.toolIdentifier;
        //         ingredientType =  ingredientTypeHandler.AssignIngredientType(ingredient, "content in");
        //         //debug code
        //         //System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.ingredientType);
        //         //debug code
        //         scope.Remove(ingredient.identifier);
        //         Ingredient newIngredient = new Ingredient(ingredientIdentifier, ingredientType);
        //         scope.append(newIngredient.identifier, newIngredient);
        //         //debug code
        //         System.out.println("Added " + ingredientIdentifier + " to scope");
        //         //debug code
        //         this.hasToolBeenUsed = true;
        //     }
        //     else
        //     { 
        //         //newIngredient is used since it appends to the symboltable when created
        //         ingredientIdentifier = ingredient.identifier;
        //         ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, toolAction.transformedIngredientTypeIdentifier);
        //         //System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.ingredientType);
        //         scope.Remove(ingredient.identifier);
        //         Ingredient newIngredient = new Ingredient(ingredientIdentifier, ingredientType);
        //         scope.append(newIngredient.identifier, newIngredient);
        //         //debug code
        //         System.out.println("Added " + ingredientIdentifier + " to scope");
        //         //debug code
        //         this.hasToolBeenUsed = true;
        //     }
            //debug code
            //System.out.println("Removed " + ingredient.identifier + " from scope");
            //debug code
    }

    public Boolean getHasToolBeenUsed()
    {
        return this.hasToolBeenUsed;
    }
}
