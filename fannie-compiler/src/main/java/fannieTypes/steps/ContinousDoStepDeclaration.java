package fannieTypes.steps;
import fannieTypes.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
public class ContinousDoStepDeclaration extends Step {
    public String procIdentifier;
    Scope scope;
    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier,String procIdentifier, Scope scope, Ingredient oldIngredient, IngredientTypeHandler ingredientTypeHandler) {
        this.procIdentifier = procIdentifier;
        this.scope = scope;
        scope.append(procIdentifier, procIdentifier);
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
            tool.useToolAction(toolAction, oldIngredient, scope, ingredientTypeHandler);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
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
