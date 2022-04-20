import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.Transform;



public class DoStepDeclaration extends Step {
    Scope scope;

    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Object oldIngredients) {
        System.out.println("in dostep");
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
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
            
            if (toolAction.ingredientTypeIdentifier.equals(ingredient.type) || ingredient.isDefaultIngredient(ingredient.type))
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
                tool.useToolAction(toolAction, ingredient, scope);
            }
        }
    }
}
