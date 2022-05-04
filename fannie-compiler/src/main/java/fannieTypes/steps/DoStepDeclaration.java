package fannieTypes.steps;
import java.util.List;

import fannieTypes.*;
import fannieTypes.toolActions.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
public class DoStepDeclaration extends Step {
    Scope scope;
    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Ingredient oldIngredient, IngredientTypeHandler ingredientTypeHandler) {
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
            tool.useToolAction(toolAction, oldIngredient, scope, ingredientTypeHandler);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, List<Ingredient> oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        for (Ingredient ingredient : oldIngredients) {
            try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
                tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
