package fannieTypes.steps;
import java.util.List;

import fannieTypes.*;
import fannieTypes.toolActions.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
public class DoStepDeclaration extends Step {
    Scope scope;
    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, List<Ingredient> oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        //debug code
        System.out.println(tool.getToolActionDeclarationsList().toString() + "Er det det rigtige tool " + toolIdentifier);
        //debug code
        for (Ingredient ingredient : oldIngredients) {
            try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
                tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
            }
            catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
