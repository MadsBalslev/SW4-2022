package fannieTypes;
import java.util.ArrayList;
import java.util.List;



import scope.Scope;
public class Tool {
    public String toolTypeIdentifier;
    public String toolIdentifier;
    public List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();
    public Boolean hasToolBeenUsed = false;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toolIdentifier + ": " + toolTypeIdentifier + "\n Toolactions \n");
        for (ToolAction toolAction : toolActionDeclarationsList) {
            sb.append(toolAction.toString() + "\n");
        }
        return sb.toString();
    }
    public ToolAction getToolAction(String toolActionIdentifier) throws Exception
    {
        ToolAction toolAction = new ToolAction();
        Boolean actionFound = false;
        for (ToolAction toolActionDeclaration : toolActionDeclarationsList) {
            if (toolActionDeclaration.toolActionIdentifier.equals(toolActionIdentifier)) {
                toolAction = toolActionDeclaration;
                actionFound = true;
            }
        }
        if (actionFound == false) {
            throw new Exception("ToolAction not found");
        }
        return toolAction;
    }
    // public void useToolAction(ToolAction toolAction, Object doStep, Scope scope)
    // {
    //      if (doStep instanceof Ingredient)
    //     {
    //         Ingredient oldIngredient = (Ingredient) doStep;
    //         System.out.println("Hit");
    //         if (toolAction.ingredientTypeIdentifier.equals(oldIngredient.type) || oldIngredient.isDefaultIngredient(oldIngredient.type.Identifier))
    //         {
    //             Ingredient newIngredient = new Ingredient();
    //             if (toolAction.transformedIngredientTypeIdentifier.equals("content in")) newIngredient.identifier = "content in" + toolAction.toolIdentifier;
    //             else newIngredient.identifier = oldIngredient.identifier;
    //             newIngredient.type = new IngredientType(toolAction.transformedIngredientTypeIdentifier);
    //             System.out.println("Removed " + oldIngredient.identifier + " from scope");
    //             System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + oldIngredient.identifier +" creating " + newIngredient.type);
    //             scope.Remove(oldIngredient.identifier);
    //             scope.append(newIngredient.identifier, newIngredient);
    //             this.hasToolBeenUsed = true;
    //         }
    //         else
    //         {
    //             throw new RuntimeException("Ingredient type mismatch");
    //         }
    //     }
    //     if (doStep instanceof List)
    //     {
    //         List<String> ingredientList = (List<String>) doStep;
    //         for (String ingredient : (List<String>)ingredientList)
    //         {
    //             Ingredient oldIngredient = (Ingredient)scope.retrieve(ingredient);
    //             if (toolAction.ingredientTypeIdentifier.equals(oldIngredient.type) || oldIngredient.isDefaultIngredient(oldIngredient.type.Identifier))
    //             {
    //                 Ingredient newIngredient = new Ingredient();
    //                 if (toolAction.transformedIngredientTypeIdentifier.equals("content in")){
    //                     newIngredient.identifier = "content in" + toolAction.toolIdentifier;
    //                     System.out.println("Hit");
    //                 } 
    //                 else newIngredient.identifier = oldIngredient.identifier;
    //                 {
    //                     newIngredient.identifier = oldIngredient.identifier;
    //                     newIngredient.type.Identifier = toolAction.transformedIngredientTypeIdentifier;
    //                     System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + oldIngredient.identifier +" creating " + newIngredient.type);
    //                     scope.Remove(oldIngredient.identifier);
    //                     scope.append(newIngredient.identifier, newIngredient);
    //                 }
    //             }
    //             else
    //             {   
    //                 throw new RuntimeException("Ingredient type mismatch");
    //             }
    //         }   
    //         this.hasToolBeenUsed = true;
    //     }
    //}
    public void useToolAction(ToolAction toolAction, Ingredient ingredient, Scope scope)
    {
        if (ingredient.isType(toolAction.ingredientTypeIdentifier))
        {
            Ingredient newIngredient = new Ingredient();
            if (toolAction.transformedIngredientTypeIdentifier.equals("content in")) newIngredient.identifier = "content in" + toolAction.toolIdentifier;
            else newIngredient.identifier = ingredient.identifier;
            newIngredient.type =  new IngredientType(toolAction.transformedIngredientTypeIdentifier, null);
            System.out.println("Removed " + ingredient.identifier + " from scope");
            System.out.println("using tool action " + toolAction.toolActionIdentifier + " on " + ingredient.identifier +" creating " + newIngredient.type);
            scope.Remove(ingredient.identifier);
            scope.append(newIngredient.identifier, newIngredient);
            this.hasToolBeenUsed = true;
        }
        else
        {
            throw new RuntimeException("Ingredient type mismatch " + toolAction.ingredientTypeIdentifier + " " + ingredient.type.Identifier);
        }
    }

    public Boolean getHasToolBeenUsed()
    {
        return this.hasToolBeenUsed;
    }
}
