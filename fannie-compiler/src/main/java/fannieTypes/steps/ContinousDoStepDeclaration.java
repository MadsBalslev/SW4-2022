package fannieTypes.steps;
import java.util.ArrayList;
import java.util.List;

import fannieTypes.*;
import scope.Scope;
public class ContinousDoStepDeclaration extends Step {
    public String procIdentifier;
    //public Tool tool;

    Scope scope;

    public ContinousDoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Object oldIngredients, ProcIdentifier procIdentifier) {
        System.out.println("in continousdostep");
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        scope.append(procIdentifier.getValue(), procIdentifier);
        System.out.println(tool.toString());
        System.out.println(toolActionIdentifier);
        ToolAction toolAction = new ToolAction();
        try {
            toolAction = tool.getToolAction(toolActionIdentifier);
            //System.out.println(toolAction.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (oldIngredients instanceof String)
        {
            Ingredient ingredient = new Ingredient();
            ingredient = (Ingredient)scope.retrieve(oldIngredients);
            System.out.println(toolAction.ingredientTypeIdentifier);
            
            if (toolAction.ingredientTypeIdentifier.equals(ingredient.type) || ingredient.isDefaultIngredient(ingredient.type.Identifier))
            {
                tool.useToolAction(toolAction, ingredient, scope);
            }
            else
            {
                throw new RuntimeException("Ingredient type mismatch" + " " + toolAction.ingredientTypeIdentifier + " " + ingredient.type);
            }
        }
        else if (oldIngredients instanceof List)
        {
            //SUS TYPECAST
            for (String ingredient : (List<String>)oldIngredients)
            {
                //tool.useToolAction(toolAction, ingredient, scope);
            }
        }
    }

    public void StopStep(Scope scope, ProcIdentifier procIdentifier)
    {
        scope.Remove(procIdentifier.getValue());
    }
}
