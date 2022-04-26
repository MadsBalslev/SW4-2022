package fannieTypes.steps;
import fannieTypes.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
import java.util.List;
public class ContinousDoStepDeclaration extends Step {
    public String procIdentifier;
    Scope scope;
    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier,String procIdentifier, Scope scope, List<Ingredient> oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        this.procIdentifier = procIdentifier;
        this.scope = scope;
        scope.append(procIdentifier, procIdentifier);
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

    public void StopStep(Scope scope, String procIdentifier)
    {
        try {
            scope.Remove(procIdentifier);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }       
}
