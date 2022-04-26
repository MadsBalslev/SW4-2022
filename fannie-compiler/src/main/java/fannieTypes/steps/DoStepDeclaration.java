package fannieTypes.steps;
import java.util.ArrayList;
import java.util.List;

import fannieTypes.*;
import scope.Scope;
import Handlers.IngredientTypeHandler;
public class DoStepDeclaration extends Step {
    Scope scope;

    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Object oldIngredients, IngredientTypeHandler ingredientTypeHandler) {
        System.out.println("in dostep");
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        System.out.println(tool.toString());
        System.out.println(toolActionIdentifier);
        ToolAction toolAction = new ToolAction();
        try {
            toolAction = tool.getToolAction(toolActionIdentifier);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (oldIngredients instanceof String)
        {
            Ingredient ingredient = new Ingredient();
            ingredient = (Ingredient)scope.retrieve(oldIngredients);
            System.out.println(toolAction.ingredientTypeIdentifier);
            
            if (ingredient.isType(toolAction.ingredientTypeIdentifier) || ingredient.isDefaultIngredient(ingredient.ingredientType.Identifier))
            {
               tool.useToolAction(toolAction, ingredient, scope, ingredientTypeHandler);
            }
            else
            {
                throw new RuntimeException("Ingredient type mismatch" + " " + toolAction.ingredientTypeIdentifier + " " + ingredient.ingredientType);
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

    public DoStepDeclaration(String toolIdentifier, String toolActionIdentifier, Scope scope, Ingredient oldIngredient, IngredientTypeHandler ingredientTypeHandler) {
        Tool tool = (Tool)scope.retrieve(toolIdentifier);
        try { ToolAction toolAction = tool.getToolAction(toolActionIdentifier);
            tool.useToolAction(toolAction, oldIngredient, scope, ingredientTypeHandler);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
