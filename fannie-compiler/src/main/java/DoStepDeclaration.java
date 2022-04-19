import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.Transform;

import fannieParserParser.IngredientIdentifierContext;

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
            Ingredient newIngredient;
            Ingredient ingredient = new Ingredient();
            ingredient = (Ingredient)scope.retrieve(oldIngredients);
            System.out.println(toolAction.ingredientTypeIdentifier);
            
            if (toolAction.ingredientTypeIdentifier.equals(ingredient.type) || ingredient.isDefaultIngredient(ingredient.type))
            {
                newIngredient = new Ingredient();
                if (toolAction.transformedIngredientTypeIdentifier.equals("content in")) newIngredient.identifier = "content in" + toolAction.toolIdentifier;
                else newIngredient.identifier = ingredient.identifier;
                newIngredient.type = toolAction.transformedIngredientTypeIdentifier;
                scope.Remove(ingredient.identifier);
                System.out.println("Removed " + ingredient.identifier + " from scope");
                //System.out.println("NYE INGREDIENSTYPE: " + newIngredient.identifier);
                scope.append(newIngredient.identifier, newIngredient);
                //System.out.println("Eksisterer den stadig" + newIngredient.identifier);
            }
            else
            {
                throw new RuntimeException("Ingredient type mismatch" + " " + toolAction.ingredientTypeIdentifier + " " + ingredient.type);
            }
        }
        //else if (context.getChild(3) instanceof fannieParserParser.ContentInContext){
            //
        // }
        else if (oldIngredients instanceof List)
        {
            //SUS TYPECAST
            for (String ingredient : (List<String>)oldIngredients)
            {
                Ingredient newIngredient = (Ingredient)scope.retrieve(ingredient);
                if (toolAction.ingredientTypeIdentifier == newIngredient.type)
                {
                    newIngredient.identifier = ingredient;
                    newIngredient.type = toolAction.transformedIngredientTypeIdentifier;
                    scope.Remove(newIngredient.identifier);
                    scope.append(newIngredient.identifier, newIngredient);
                }
                else
                {
                    throw new RuntimeException("Ingredient type mismatch");
                }
            }
        }
    }
}
