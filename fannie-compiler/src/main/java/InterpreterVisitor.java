import java.util.ArrayList;
import java.util.List;

import com.itextpdf.tool.xml.exceptions.NotImplementedException;

import org.antlr.v4.runtime.tree.TerminalNode;
import Handlers.IngredientTypeHandler;
import fannieTypes.HasBeenServed;
import fannieTypes.Ingredient;
import fannieTypes.Tool;
import fannieTypes.steps.*;
import fannieTypes.toolActions.*;
import scope.Scope;
public class InterpreterVisitor extends fannieParserBaseVisitor<Object> {

    //test
    IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    Scope scope = new Scope();
    
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    {
        //debug code
        System.out.println("Visiting fannie");
        //debug code
        visitChildren(context);

        return null;
    }
    
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    {
        //debug code
        System.out.println("Visiting mainrecipe");
        //debug code
        Scope oldScope = scope;
        scope = oldScope.createScope();
        visitChildren(context);

        //debug code
        scope.stringPrinter(scope.getSymbolTable(), "Tool");
        System.out.println("INGREDIENSER: ");
        scope.stringPrinter(scope.getSymbolTable(), "Ingredient");
        //debug code
        
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
        throw new NotImplementedException();
        // Scope oldScope = scope;
        // scope = oldScope.createScope();
        // System.out.println("Visiting subrecipe");
        // visitChildren(context);
        // System.out.println("in subrecipe");
        // scope.stringPrinter(scope.getSymbolTable(), "Tool");
        // scope = oldScope;
    }
    
    @Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext context) 
    {   
        //debug code
        System.out.println("Visiting recipeIdentifier");
        //debug code
        return null;
    }
    
    @Override public Void visitRecipeBody(fannieParserParser.RecipeBodyContext context) 
    {
        //debug code
        System.out.println("Visiting recipebody");
        //debug code
        visitChildren(context); 
        return null;
    }
    
    @Override public Void visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    {
        HasBeenServed hasServed = new HasBeenServed(scope);
        scope.append("hasServed", hasServed);
        //debug code
        System.out.println("Visiting ingredientslist");
        //debug code
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitToolsList(fannieParserParser.ToolsListContext context) 
    {
        //debug code
        System.out.println("Visiting toolslist");
        //debug code
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitStepsList(fannieParserParser.StepsListContext context) 
    {
        //debug code
        System.out.println("Visiting stepslist");
        //debug code
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitIngredientDeclaration(fannieParserParser.IngredientDeclarationContext context) 
    {
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitToolDeclaration(fannieParserParser.ToolDeclarationContext context) 
    {
        String toolIdentifier = context.toolIdentifier().getText();
        String toolTypeIdentifier = context.toolTypeIdentifier().getText();
        List<ToolAction> toolActionDeclarationsList = visitToolActionDeclarationsList(context.toolActionDeclarationsList());
        Tool tool = new Tool(toolIdentifier, toolTypeIdentifier, toolActionDeclarationsList);
        
        scope.append(tool.toolIdentifier, tool);
        return null;
    }
    
    @Override public Void visitStepDeclaration(fannieParserParser.StepDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    
    public String visitIngredientIdentifier(fannieParserParser.IngredientIdentifierContext context) 
    {   
        return context.getText();
    }
    
    @Override public Void visitToolIdentifier(fannieParserParser.ToolIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext context) 
    {
        String identifier = visitIngredientIdentifier(context.ingredientIdentifier());
        String ingredientType = visitIngredientTypeIdentifier(context.ingredientTypeIdentifier());
        Ingredient ingredient = new Ingredient(identifier, ingredientTypeHandler, ingredientType);
        scope.append(ingredient.identifier, ingredient);
        return null;
    }
    
    @Override public Void visitNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext context) 
    { 
        throw new NotImplementedException();
    }
    
    @Override public Void visitRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext context) 
    {   
        throw new NotImplementedException();
    }
    
    @Override public Void visitIngredientTypeDeclaration(fannieParserParser.IngredientTypeDeclarationContext context) 
    { 
        throw new NotImplementedException();
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
    
    @Override public String visitIngredientTypeIdentifier(fannieParserParser.IngredientTypeIdentifierContext context) 
    { 
        return context.getText();
    }
    
    @Override public ArrayList<ToolAction> visitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext context) 
    { 
        
        List<ToolAction> toolActionList = new ArrayList<ToolAction>();
        for (int i = 0; i < context.getChildCount(); i++) {
            if (context.getChild(i) instanceof fannieParserParser.ToolActionDeclarationContext) {
                toolActionList.add(visitToolActionDeclaration((fannieParserParser.ToolActionDeclarationContext) context.getChild(i)));
                }
            }
        for (ToolAction toolAction : toolActionList)
        {  
           if (toolAction instanceof ContainToolActionDeclaration)
           {
                ContainToolActionDeclaration containToolActionDeclaration = (ContainToolActionDeclaration) toolAction;
                
           } 
        }
        
        return (ArrayList<ToolAction>) toolActionList;
    }
    
    @Override public ToolAction visitToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext context) 
    {
        if (context.getChild(0) instanceof TerminalNode) {
            String ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
            ContainToolActionDeclaration contain = new ContainToolActionDeclaration(ingredientTypeIdentifier);
            return contain;
        }
        else if (context.getChild(2) instanceof fannieParserParser.ContentInContext)
        {
            String input = context.contentIn().CONTENT_IN().getText();
            String output= context.ingredientTypeIdentifier(0).getText();
            String toolActionIdentifier = context.toolActionIdentifier().getText();
            ContentInToolAction contentInToolAction = new ContentInToolAction(input, output, toolActionIdentifier);
            return contentInToolAction;
        } 
        else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
        {
            String input = context.ingredientTypeIdentifier(0).getText();
            String output = context.ingredientTypeIdentifier(1).getText();
            String toolActionIdentifier = context.toolActionIdentifier().getText();
            NormalToolAction normalToolAction = new NormalToolAction(input, output, toolActionIdentifier);
            return normalToolAction;
        }
        else
        {
            throw new RuntimeException();
        }
        
    }
    
    @Override public Void visitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext context) 
    {
        HasBeenServed hasBeenServed = (HasBeenServed)scope.retrieve("hasServed");
        if (hasBeenServed.isServed) {
            throw new RuntimeException("Recipe already has served");
        }
        hasBeenServed.isServed = true;
        scope.Remove("hasServed");
        scope.append("hasServed", hasBeenServed);
        visitChildren(context);
        //debug code
        scope.stringPrinter(scope.getSymbolTable(), "Ingredient");
        //debug code
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
    // public ToolAction createToolAction(fannieParserParser.ToolActionDeclarationContext context) {
    //     ToolAction toolAction = new ToolAction();
    //     if (context.getChild(0) instanceof TerminalNode)
    //     {
    //         toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
    //         toolAction.transformedIngredientTypeIdentifier = "content in";
    //         toolAction.toolActionIdentifier = "contain";
    //     }
    //     /* we have to check if the first ingredienttype identifier is  contentin,
    //     since it changes whether ingredienttypeidentifier(0) is the original or transformed ingredient */
    //     else if (context.getChild(2) instanceof fannieParserParser.ContentInContext) {
    //         toolAction.ingredientTypeIdentifier = context.contentIn().CONTENT_IN().getText();
    //         toolAction.transformedIngredientTypeIdentifier= context.ingredientTypeIdentifier(0).getText();
    //         toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
    //     } 
    //     else if (context.getChild(2) instanceof fannieParserParser.IngredientTypeIdentifierContext)
    //     {
    //         toolAction.ingredientTypeIdentifier = context.ingredientTypeIdentifier(0).getText();
    //         toolAction.transformedIngredientTypeIdentifier = context.ingredientTypeIdentifier(1).getText();
    //         toolAction.toolActionIdentifier = context.toolActionIdentifier().getText();
    //     }
        
    //     return toolAction;
    // }
}
