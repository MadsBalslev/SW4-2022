package fannieTypes.steps;
import java.util.List;

import fannieTypes.*;
import fannieTypes.toolActions.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
public class DoStepDeclaration extends Step {
    Scope scope;
    Tool tool;
    ToolAction toolAction;
    List<Ingredient> ingredients;
    IngredientTypeHandler ingredientTypeHandler;
    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, List<Ingredient> oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        this.tool = (Tool)scope.retrieve(toolIdentifier);
        this.toolAction = tool.getToolAction(toolActionIdentifier);
        this.ingredients = oldIngredients;
        this.ingredientTypeHandler = ingredientTypeHandler;
        this.scope = scope;

        for (Ingredient ingredient : oldIngredients) {
            try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
                tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
            }
            catch (Exception e) {
                throw new RuntimeException("cannot use tool action " + toolActionIdentifier + " on ingredient " + ingredient.identifier);
            }
        }
    }

    public Void Execute() {
        for (Ingredient ingredient : ingredients) {
            tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
        }
        return null;
    }
    
    public Void Execute(List<String> stepOut)
    {
        for (Ingredient ingredient : ingredients) {
            tool.useToolActionOut(toolAction, ingredient, scope, ingredientTypeHandler);
        }
        for (String string : stepOut) {
            Ingredient outPutIngredient = new Ingredient(string, ingredientTypeHandler, toolAction.output);
            scope.append(string, outPutIngredient);
        }
        return null;
    }
}
