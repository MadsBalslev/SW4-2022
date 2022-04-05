import java.security.cert.CertPathBuilderException;
import java.util.ArrayList;
import java.util.List;
public class InterpreterVisitor extends fannieParserBaseVisitor<Object> {
    List<String> toolsList = new ArrayList<String>();
    List<String> recipesList = new ArrayList<String>();
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    {
        System.out.println("Visiting fannie");
        visitChildren(context); 
        return null;
    }
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    {        
        System.out.println("Visiting mainrecipe");
        visitChildren(context);
        // for (String string : recipesList) {
        //     System.out.println("recipe" + string);
            
        // }
        return null;
    }
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        System.out.println("Visiting subrecipe");
        // recipesList.add(context.recipeIdentifier().getText());
        visitChildren(context);
        return null;
    }
    @Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext context) 
    {   
        recipesList.add(context.getText());
        System.out.println("Visiting recipeIdentifier");
        visitChildren(context);
        return null;
    }
    @Override public Void visitRecipeBody(fannieParserParser.RecipeBodyContext context) 
    {
        System.out.println("Visiting recipebody");
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        ingredientsList = visitIngredientsList(context.ingredientsList());
        for (Ingredient ingredient : ingredientsList) {
            System.out.println(ingredient.identifier + " " + ingredient.type);
        }
        visitChildren(context); 
        return null;
    }
    @Override public ArrayList<Ingredient> visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    {   
        System.out.println("Visiting ingredientslist");
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        System.out.println("før loop");
        for(int i = 0; i < context.ingredientDeclaration().size(); i++) {
            System.out.println("i loop");
            ingredientsList.add(visitIngredientDeclaration(context.ingredientDeclaration(i)));
        }
        visitChildren(context); 
        return (ArrayList<Ingredient>) ingredientsList;
    }
    @Override public Void visitToolsList(fannieParserParser.ToolsListContext context) 
    {
        System.out.println("Visiting toolslist");
        visitChildren(context);
        return null;
    }
    @Override public Void visitStepsList(fannieParserParser.StepsListContext context) 
    { 
        System.out.println("Visiting stepslist");
        visitChildren(context);
        return null;
    }
    @Override public Ingredient visitIngredientDeclaration(fannieParserParser.IngredientDeclarationContext context) 
    { 
        for (int i = 0; i < context.getChildCount(); i++) {
        
            if (context.getChild(i) instanceof fannieParserParser.DeterministicIngredientDeclarationContext) {
                return visitDeterministicIngredientDeclaration((fannieParserParser.DeterministicIngredientDeclarationContext) context.getChild(i));
            }
            else if (context.getChild(i) instanceof fannieParserParser.RecipeIngredientDeclarationContext) {
                return visitRecipeIngredientDeclaration((fannieParserParser.RecipeIngredientDeclarationContext) context.getChild(i));
            }
            else if (context.getChild(i) instanceof fannieParserParser.NondeterministicIngredientDeclarationContext) {
                return visitNondeterministicIngredientDeclaration((fannieParserParser.NondeterministicIngredientDeclarationContext) context.getChild(i));
            }
        }
        visitChildren(context);
        return visitDeterministicIngredientDeclaration(context.deterministicIngredientDeclaration());
    }
    @Override public Void visitToolDeclaration(fannieParserParser.ToolDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitStepDeclaration(fannieParserParser.StepDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitIngredientIdentifier(fannieParserParser.IngredientIdentifierContext context) 
    { 
        
        return null;
    }
    @Override public Void visitToolIdentifier(fannieParserParser.ToolIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Ingredient visitDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext context) 
    { 
        Ingredient ingredient = new Ingredient();
        ingredient.identifier = context.ingredientIdentifier().getText();
        ingredient.type = context.ingredientTypeIdentifier().getText();
        //if parent = nondeterministicIngredientDeclaration 
        //{
        //  for(i = 0; i < context.getChildCount(); i++) {
        //      
        //  return visitDeterministicIngredientDeclaration((fannieParserParser.DeterministicIngredientDeclarationContext) context.getChild(i));
        //  }    
        //}
        visitChildren(context);
        return ingredient;
    }
    // pt fungerer nondeterministic som en deterministic der tager første ingrediens ind
    @Override public Ingredient visitNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext context) 
    { 
        visitChildren(context);
        return visitDeterministicIngredientDeclaration((fannieParserParser.DeterministicIngredientDeclarationContext) context.getChild(0));
    }
    @Override public Ingredient visitRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext context) 
    { 
        Ingredient ingredient = new Ingredient();
        ingredient.identifier = context.recipeIdentifier().getText();
        ingredient.type = context.RECIPE().getText();
        visitChildren(context);
        return ingredient;
    }
    @Override public Void visitIngredientTypeDeclaration(fannieParserParser.IngredientTypeDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitAmountDeclaration(fannieParserParser.AmountDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitProcIdentifier(fannieParserParser.ProcIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitToolActionIdentifier(fannieParserParser.ToolActionIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitToolTypeIdentifier(fannieParserParser.ToolTypeIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitIngredientTypeIdentifier(fannieParserParser.IngredientTypeIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitStepIn(fannieParserParser.StepInContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitStepOut(fannieParserParser.StepOutContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitContentIn(fannieParserParser.ContentInContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitIngredientCollection(fannieParserParser.IngredientCollectionContext context) 
    { 
        visitChildren(context);
        return null;
    }
}
