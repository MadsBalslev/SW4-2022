package fannieTypes;
import java.util.HashMap;
import Handlers.IngredientTypeHandler;
import fannieTypes.toolActions.*;
import scope.Scope;
import Exceptions.*;
public class Tool {
    public String toolTypeIdentifier;
    public String toolIdentifier;
    private HashMap<String, ToolAction> toolActionDeclarationsList = new HashMap<String, ToolAction>();
    public Boolean hasToolBeenUsed = false;
    
    public Tool(String toolIdentifier, String toolTypeIdentifier,HashMap<String, ToolAction> toolActionList)
    {
        this.toolIdentifier = toolIdentifier;
        this.toolTypeIdentifier = toolTypeIdentifier;
        this.toolActionDeclarationsList = toolActionList;
        
    }

    public ToolAction getToolAction(String toolActionIdentifier)
    {
        if(toolActionDeclarationsList.containsKey(toolActionIdentifier))
            return toolActionDeclarationsList.get(toolActionIdentifier);
        else
            throw new CompilerException("ToolAction: " + toolActionIdentifier + " not found on tool " + toolIdentifier);
    }
    
    public void useToolAction(ToolAction toolAction, Ingredient ingredient, Scope scope, IngredientTypeHandler ingredientTypeHandler)
    {
        if (toolAction instanceof ContainToolActionDeclaration)
        {
            Ingredient newIngredient = toolAction.useToolAction(ingredient, ingredientTypeHandler, this.toolIdentifier);
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

    public void useToolActionOut(ToolAction toolAction, Ingredient ingredient, Scope scope, IngredientTypeHandler ingredientTypeHandler)
    {
            // guard
            if (toolAction.toolActionIdentifier == "contain" && toolAction.toolActionIdentifier == "remove")
                throw new CompilerException("contain or remove action can not have output");
            // TODO this might be bad.
            if (ingredient.isType("content in"))
                throw new CompilerException("step input can not be content in when the step has an output");
            if (!ingredient.isType(toolAction.input))
                throw new CompilerException("Mismatch between actual input:" + ingredient.ingredientType.identifier + " and expected input type: " + toolAction.input);
           scope.Remove(ingredient.identifier);
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
