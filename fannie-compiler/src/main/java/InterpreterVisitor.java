import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import Handlers.IngredientTypeHandler;
import fannieTypes.HasBeenServed;
import fannieTypes.Ingredient;
import fannieTypes.IngredientType;
import fannieTypes.Tool;
import fannieTypes.ToolAction;
import fannieTypes.steps.*;
import scope.Scope;
public class InterpreterVisitor extends fannieParserBaseVisitor<Object> {

    List<Tool> toolsList = new ArrayList<Tool>();
    List<String> recipesList = new ArrayList<String>();
    IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    Scope scope = new Scope();
    List<ToolAction> toolActionsList = new ArrayList<ToolAction>();
    
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    {
        System.out.println("Visiting fannie");
        visitChildren(context);
        for (Tool tool : toolsList) {
            System.out.println(tool.toolIdentifier + " " + tool.toolTypeIdentifier);
            for (ToolAction toolAction : tool.toolActionDeclarationsList) {
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
        System.out.println("INGREDIENSER: ");
        scope.stringPrinter(scope.getSymbolTable(), "Ingredient");
        if(scope.isIngredientListEmpty() == false)
        {
            throw new RuntimeException("Not all ingredients are served");
        }
        if (scope.hasToolsBeenUsed() == false) {
            throw new RuntimeException("Not all tools are used");
        }
        if (scope.isProcListEmpty() == false) {
            throw new RuntimeException("Not all procedures are stopped");
        }
        scope = oldScope;
        return null;
    }
    
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        Scope oldScope = scope;
        scope = oldScope.createScope();
        System.out.println("Visiting subrecipe");
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
        visitChildren(context); 
        return null;
    }
    
    @Override public Void visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    {   
        HasBeenServed hasServed = new HasBeenServed(scope);
        scope.append("hasServed", hasServed);
        System.out.println("Visiting ingredientslist");
        visitChildren(context);
        return null;
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
        Ingredient ingredient = (Ingredient)visitChildren(context);
        return ingredient;
    }
    
    @Override public Void visitToolDeclaration(fannieParserParser.ToolDeclarationContext context) 
    { 
        String toolIdentifier = context.toolIdentifier().getText();
        String toolTypeIdentifier = context.toolTypeIdentifier().getText();
        List<ToolAction> toolActionDeclarationsList = visitToolActionDeclarationsList(context.toolActionDeclarationsList());
        Tool tool = new Tool(toolIdentifier, toolTypeIdentifier, toolActionDeclarationsList, scope);
        for (ToolAction toolAction : tool.toolActionDeclarationsList) {
            toolAction.toolIdentifier = tool.toolIdentifier;
        }
        scope.append(tool.toolIdentifier, tool);
        return null;
    }
    
    @Override public Void visitStepDeclaration(fannieParserParser.StepDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    
    public Ingredient visitIngredientIdentifier(fannieParserParser.IngredientIdentifierContext context) 
    {   
        Ingredient oldIngredient = (Ingredient)scope.retrieve(context.getText());
        return oldIngredient;
    }
    
    @Override public Void visitToolIdentifier(fannieParserParser.ToolIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext context) 
    { 
        String identifier = context.ingredientIdentifier().getText();
        String ingredientType = context.ingredientTypeIdentifier().getText();
        Ingredient ingredient = new Ingredient(identifier, ingredientTypeHandler, ingredientType, scope);
        scope.append(ingredient.identifier, ingredient);
        return null;
    }
    // pt fungerer nondeterministic som en deterministic der tager første ingrediens ind
    
    @Override public Void visitNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext context) 
    {
        // String ingredientIdentifier = context.recipeIdentifier().getText();
        // Ingredient ingredient = new Ingredient(ingredientIdentifier, null , scope);
        // ingredient.ingredientType = ingredientTypeHandler.AssignIngredientType(ingredient, context.ingredientTypeIdentifier().getText());
        // visitChildren(context);
        // return ingredient;
        return null;
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
        HasBeenServed hasBeenServed = (HasBeenServed)scope.retrieve("hasServed");
        if (hasBeenServed.isServed) {
            throw new RuntimeException("Recipe already has served");
        }
        hasBeenServed.isServed = true;
        scope.append("hasServed", hasBeenServed);
        visitChildren(context);
        scope.stringPrinter(scope.getSymbolTable(), "Ingredient");
        scope.Remove(context.stepIn().getText());
        return null;
    }
    
    @Override public Void visitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext context) 
    { 
        String toolIdentifier = context.toolIdentifier().getText();
        String toolActionIdentifier = context.toolActionIdentifier().getText();
        
        new DoStepDeclaration(toolIdentifier, toolActionIdentifier, scope, visitStepIn(context.stepIn()), ingredientTypeHandler);
        return null;
    }
    
    @Override public Void visitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext context) 
    { 
        String toolIdentifier = context.toolIdentifier().getText();
        String toolActionIdentifier = context.toolActionIdentifier().getText();
        String procIdentifier = context.procIdentifier().getText();
        new ContinousDoStepDeclaration(toolIdentifier, toolActionIdentifier, procIdentifier, scope, visitStepIn(context.stepIn()), ingredientTypeHandler);
        return null;
    }
    
    @Override public Void visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext context) 
    {
        visitChildren(context);
        String procIdentifier = context.procIdentifier().getText();
        try {
            scope.Remove(procIdentifier);
        } catch (Exception e) {
            throw new RuntimeException("Proc: " + procIdentifier + " has not been declared");
        }
        return null;
    }
    
    @Override public List<Ingredient> visitStepIn(fannieParserParser.StepInContext context) 
    {
        visitChildren(context);
        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
        for (int i = 0; i < context.getChildCount(); i++)
        {
            ingredientList.add((Ingredient)scope.retrieve(context.getChild(i).getText()));
        }
        return ingredientList;
    }
    
    @Override public Void visitStepOut(fannieParserParser.StepOutContext context) 
    {
        visitChildren(context);
        return null;
    }
    
    //this is not good, should probably be associated to the tool class, but this works for now
    public ToolAction createToolAction(fannieParserParser.ToolActionDeclarationContext context) {
        ToolAction toolAction = new ToolAction();
        if (context.getChild(0) instanceof TerminalNode)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = "content in";
            toolAction.toolActionIdentifier = "contain";
        }
        /* we have to check if the first ingredienttype identifier is  contentin,
        since it changes whether ingredienttypeidentifier(0) is the original or transformed ingredient */
        else if (context.getChild(2) instanceof fannieParserParser.ContentInContext) {
            toolAction.ingredientTypeIdentifier = context.contentIn().CONTENT_IN().getText();
            toolAction.transformedIngredientTypeIdentifier= context.ingredientTypeIdentifier(0).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
        } 
        else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
        {
            toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            toolAction.transformedIngredientTypeIdentifier = context.ingredientTypeIdentifier(1).getText();
            toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
        }
        
        return toolAction;
    }

    
}
