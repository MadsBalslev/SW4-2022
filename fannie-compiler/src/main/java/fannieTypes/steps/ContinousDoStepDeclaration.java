package fannieTypes.steps;
import fannieTypes.*;
import scope.Scope;
import fannieTypes.toolActions.*;
import Handlers.IngredientTypeHandler;
import java.util.List;
import Exceptions.*;
public class ContinousDoStepDeclaration extends Step {
    Tool tool;
    ToolAction toolAction;
    public String procIdentifier;
    Scope scope;
    List<Ingredient> ingredients;
    Boolean hasbeenStopped;

    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier,String procIdentifier, Scope scope, List<Ingredient> ingredients) {
        this.procIdentifier = procIdentifier;
        this.scope = scope;
        this.tool = (Tool)scope.retrieve(toolIdentifier);
        this.toolAction = tool.getToolAction(toolActionIdentifier);
        this.ingredients = ingredients;
        this.hasbeenStopped = false;
    }
    public void ExecuteStep(IngredientTypeHandler ingredientTypeHandler) {

        for (Ingredient ingredient : ingredients) {
            
                tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
                scope.Remove(procIdentifier);
                this.hasbeenStopped = true;
        }
    }

    public void ExecuteStep(IngredientTypeHandler ingredientTypeHandler, List<String> stepOut, Scope scope) {
        for (Ingredient ingredient : ingredients) {
            tool.useToolActionOut(toolAction, ingredient, scope, ingredientTypeHandler);
        }
        for (String string : stepOut) {
            Ingredient outPutIngredient = new Ingredient(string, ingredientTypeHandler, toolAction.output);
            scope.append(string, outPutIngredient);
            scope.Remove(procIdentifier);
            this.hasbeenStopped = true;
        }
    }

    public Boolean isValid(IngredientTypeHandler ingredientTypeHandler) {
        Scope mockScope = new Scope();
        mockScope.symbolTable.putAll(scope.symbolTable);
        for (Ingredient ingredient : ingredients) {
            try {
                tool.useToolAction(toolAction, ingredient, mockScope, ingredientTypeHandler);
            } 
            catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public boolean hasBeenStopped() {
        return this.hasbeenStopped;
    }

}
