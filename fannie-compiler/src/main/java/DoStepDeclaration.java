import java.util.ArrayList;
import java.util.List;

public class DoStepDeclaration extends Step {
    Scope scope;

    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Object oldIngredients) {
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        ToolAction toolAction = new ToolAction();
        try {
            toolAction = tool.getToolAction(toolActionIdentifier);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (oldIngredients instanceof String)
        {
            Ingredient newIngredient;
            Ingredient ingredient = new Ingredient();
            ingredient = (Ingredient)scope.retrieve(oldIngredients);
            
            if (toolAction.ingredientTypeIdentifier == ingredient.type)
            {
                newIngredient = new Ingredient();
                newIngredient.identifier = ingredient.identifier;
                newIngredient.type = toolAction.transformedIngredientTypeIdentifier;
                scope.Remove(ingredient.identifier);
                scope.append(newIngredient.identifier, newIngredient);
            }
            else
            {
                throw new RuntimeException("Ingredient type mismatch");
            }
        }
        else if (oldIngredients instanceof List)
        {
            //SUS TYPECAST
            for (String ingredient : (List<String>)oldIngredients)
            {
                Ingredient newIngredient = (Ingredient)scope.retrieve(ingredient);
                    
            }
        }
    }
}