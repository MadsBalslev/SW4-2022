package fannieTypes.steps;
import fannieTypes.*;
import scope.Scope;
import fannieTypes.toolActions.*;
import Handlers.IngredientTypeHandler;
import java.util.List;
public class ContinousDoStepDeclaration extends Step {
    Scope scope;

    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier,String procIdentifier, Scope scope, List<Ingredient> oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        ProcIdentifier proc = new ProcIdentifier(procIdentifier);
        this.scope = scope;
        scope.append(procIdentifier, proc);
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
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
