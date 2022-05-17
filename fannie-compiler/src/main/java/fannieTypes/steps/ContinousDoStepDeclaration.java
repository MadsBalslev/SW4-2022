package fannieTypes.steps;
import fannieTypes.*;
import scope.Scope;
import fannieTypes.toolActions.*;
import Handlers.IngredientTypeHandler;
import java.util.List;
public class ContinousDoStepDeclaration extends Step {
    Tool tool;
    ToolAction toolAction;
    public String procIdentifier;
    Scope scope;
    List<Ingredient> ingredients;


    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier,String procIdentifier, Scope scope, List<Ingredient> ingredients) {
        this.procIdentifier = procIdentifier;
        this.scope = scope;
        this.tool = (Tool)scope.retrieve(toolIdentifier);
        this.toolAction = tool.getToolAction(toolActionIdentifier);
        this.ingredients = ingredients;
    }
    public void ExecuteStep(IngredientTypeHandler ingredientTypeHandler) {
        for (Ingredient ingredient : ingredients) {
                tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
                scope.Remove(procIdentifier);
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

}
