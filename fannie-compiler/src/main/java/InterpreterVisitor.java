import java.security.cert.CertPathBuilderException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
public class InterpreterVisitor extends fannieParserBaseVisitor<Object> {

    List<Tool> toolsList = new ArrayList<Tool>();
    List<String> recipesList = new ArrayList<String>();
    Scope scope = new Scope();
    List<ToolAction> toolActionsList = new ArrayList<ToolAction>();
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    {
        System.out.println("Visiting fannie");
        visitChildren(context);
       /* if (recipesList != null) {
            throw new RuntimeException("Not all recipes are served");
        } */
        for (Tool tool : toolsList) {
            System.out.println(tool.toolIdentifier + " " + tool.toolTypeIdentifier);
            for (ToolAction toolAction : tool.toolActionDeclarationsList) {
                System.out.println("er i toolaction print");
                System.out.println("Action " + toolAction.toolActionIdentifier + " Ingredient Type " + toolAction.ingredientTypeIdentifier + " Becomes " + toolAction.transformedIngredientTypeIdentifier);
            }
        }
        return null;
    }
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    {        
        System.out.println("Visiting mainrecipe");
        Scope oldScope = scope;
        scope = oldScope.createScope();
        visitChildren(context);
        scope.stringPrinter(scope.getSymbolTable(), "Tool");
        scope = oldScope;
        return null;
    }
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        Scope oldScope = scope;
        scope = oldScope.createScope();
        System.out.println("Visiting subrecipe");
        //if (recipesList.contains(context.recipeIdentifier.getText())) {
        //  System.out.println("subrecipe is already added")
        //}
        //else {
        //  System.out.println("subrecipe has not been added already")
        //}
        //recipesList.add(context.recipeIdentifier().getText());
        visitChildren(context);
        System.out.println("in subrecipe");
        scope.stringPrinter(scope.getSymbolTable(), "Tool");
        scope = oldScope;
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
        //List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        // ingredientsList = visitIngredientsList(context.ingredientsList());
        toolsList = visitToolsList(context.toolsList());
        visitChildren(context); 
        return null;
    }
    @Override public ArrayList<Ingredient> visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    {   
        System.out.println("Visiting ingredientslist");
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        for(int i = 0; i < context.ingredientDeclaration().size(); i++) {
            Ingredient ingredient = visitIngredientDeclaration(context.ingredientDeclaration(i));
            scope.append(ingredient.identifier, ingredient);
            // using list instead of symbol table:
            //ingredientsList.add(visitIngredientDeclaration(context.ingredientDeclaration(i)));
        }
        visitChildren(context); 
        return (ArrayList<Ingredient>) ingredientsList;
    }
    @Override public ArrayList<Tool> visitToolsList(fannieParserParser.ToolsListContext context) 
    {
        System.out.println("Visiting toolslist");
        for (int i = 0; i < context.toolDeclaration().size(); i++) {
            Tool tool = visitToolDeclaration(context.toolDeclaration(i));
            scope.append(tool.toolIdentifier, tool);
            // using list instead of scope 
            //toolsList.add(visitToolDeclaration(context.toolDeclaration(i)));
        }
        //visitChildren(context);
        return (ArrayList<Tool>) toolsList;
    }
    @Override public Void visitStepsList(fannieParserParser.StepsListContext context) 
    { 
        System.out.println("Visiting stepslist");
        //visitChildren(context);
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
       // visitChildren(context);
        return visitDeterministicIngredientDeclaration(context.deterministicIngredientDeclaration());
    }
    @Override public Tool visitToolDeclaration(fannieParserParser.ToolDeclarationContext context) 
    { 
        Tool tool = new Tool();
        tool.toolIdentifier = context.toolIdentifier().getText();
        tool.toolTypeIdentifier = context.toolTypeIdentifier().getText();
        tool.toolActionDeclarationsList = visitToolActionDeclarationsList(context.toolActionDeclarationsList());
        // visitChildren(context);
        return tool;
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
       // visitChildren(context);
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
    @Override public ArrayList<ToolAction> visitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext context) 
    { 
        List<ToolAction> toolActionList = new ArrayList<ToolAction>();
        for (int i = 0; i < context.getChildCount(); i++) {
            if (context.getChild(i) instanceof fannieParserParser.ToolActionDeclarationContext) {
                    toolActionList.add(visitToolActionDeclaration((fannieParserParser.ToolActionDeclarationContext) context.getChild(i)));
                }
            }
        return (ArrayList<ToolAction>) toolActionList;
    }
    @Override public ToolAction visitToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext context) 
    { 
        ToolAction toolAction = createToolAction(context);
        
       // visitChildren(context);
        return toolAction;
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
    @Override public String visitContentIn(fannieParserParser.ContentInContext context) 
    { 
        visitChildren(context);
        return context.getText();
    }
    @Override public Void visitIngredientCollection(fannieParserParser.IngredientCollectionContext context) 
    { 
        visitChildren(context);
        return null;
    }
    public ToolAction createToolAction(fannieParserParser.ToolActionDeclarationContext context) {
        ToolAction toolAction = new ToolAction();
        if (context.getChild(0) instanceof TerminalNode)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = "content in";
            toolAction.toolActionIdentifier = "Contain";
            //System.out.println("creating contain toolaction");
            //return toolAction;
        }
        /* we have to check if the first ingredienttype identifier is  contentin,
        since it changes whether ingredienttypeidentifier(0) is the original or transformed ingredient */
        else if (context.getChild(2) instanceof fannieParserParser.ContentInContext) {
            toolAction.ingredientTypeIdentifier = context.contentIn().CONTENT_IN().getText();
            toolAction.transformedIngredientTypeIdentifier= context.ingredientTypeIdentifier(0).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
            //System.out.println("creating content in toolaction");
        } 
        else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = context.ingredientTypeIdentifier(1).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
            //System.out.println("creating normal toolaction");
        }
        return toolAction;
    }

    public Step createStep(fannieParserParser.StepDeclarationContext context) 
    {
        Step step;
        if (context.getChild(0) instanceof fannieParserParser.ServeStepDeclarationContext)
        {
            step = new DoStepDeclaration();
            //System.out.println("creating serve step");
        }
        else if (context.getChild(0) instanceof fannieParserParser.DoStepDeclarationContext)
        {
            step = new ServeStepDeclaration();
            //System.out.println("creating do step");
        }
        else if (context.getChild(0) instanceof fannieParserParser.ContinousDoStepStartDeclarationContext)
        {
            step = new ContinousDoStepStartDeclaration();
            //System.out.println("creating continous do step");
        }
        else if (context.getChild(0) instanceof fannieParserParser.ContinousDoStepStopDeclarationContext)
        {
            step = new ContinousDoStepStopDeclaration();
            //System.out.println("creating continous do step");
        }
        else {
            return null;
        }

        return step;
    }
}
