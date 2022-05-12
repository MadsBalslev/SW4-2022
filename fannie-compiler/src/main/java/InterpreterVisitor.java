import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

import java.util.HashMap;

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
        if(scope.isIngredientListEmpty() == true)
        {
            throw new RuntimeException("No ingredients in the recipe");
        }
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
        HashMap<String, ToolAction> superToolActionsList = new HashMap<String, ToolAction>();
        
        if (scope.symbolTable.containsKey(toolTypeIdentifier))
        {
            Tool superTool = (Tool)scope.retrieve(toolTypeIdentifier);
            superToolActionsList.putAll(superTool.getToolActionDeclarationsList());
        }
        HashMap<String, ToolAction> toolActionsList = new HashMap<String, ToolAction>();
        toolActionsList.putAll(visitToolActionDeclarationsList(context.toolActionDeclarationsList()));
        for (String key : superToolActionsList.keySet())
        {
            if (toolActionsList.containsKey(key))
            {
                throw new RuntimeException("Toolaction has already been declared");
            }
        }
        toolActionsList.putAll(superToolActionsList);
        Tool tool = new Tool(toolIdentifier, toolTypeIdentifier, toolActionsList);
        scope.append(tool.toolIdentifier, tool);
        
        return null;
    }
    
    @Override public Void visitStepDeclaration(fannieParserParser.StepDeclarationContext context) 
    { 
        List<ContinousDoStepDeclaration> continousDoStepDeclarations = new ArrayList<ContinousDoStepDeclaration>();
        for (int i = 0; i < context.getChildCount(); i++) {
            {
                if (context.getChild(i) instanceof fannieParserParser.ContinousDoStepStartDeclarationContext)
                {
                    continousDoStepDeclarations.add((ContinousDoStepDeclaration)visit(context.getChild(i)));
                }
                else
                {
                    visit(context.getChild(i));
                }
                
            }
        }
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
        String superTypeIdentifier = visitIngredientTypeIdentifier(context.ingredientTypeIdentifier(0));
        String subTypeIdentifier = visitIngredientTypeIdentifier(context.ingredientTypeIdentifier(1));
        ingredientTypeHandler.CreateIngredientType(superTypeIdentifier, subTypeIdentifier);

        
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
    
    @Override public String visitIngredientTypeIdentifier(fannieParserParser.IngredientTypeIdentifierContext context) 
    { 
        return context.getText();
    }
    
    @Override public HashMap<String,ToolAction> visitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext context) 
    {
        HashMap <String, ToolAction> toolActionDeclarationsList = new HashMap<String, ToolAction>();
        for (fannieParserParser.ToolActionDeclarationContext toolActionDeclarationContext : context.toolActionDeclaration())
        {
            if (toolActionDeclarationContext.getChild(0) instanceof TerminalNode)
            {
                toolActionDeclarationsList.put("contain", visitToolActionDeclaration(toolActionDeclarationContext));
            }
            else
            {
                String identifier = visitToolActionDeclaration(toolActionDeclarationContext).toolActionIdentifier;
                toolActionDeclarationsList.put(identifier, visitToolActionDeclaration(toolActionDeclarationContext));
            }
        }
        return toolActionDeclarationsList;
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
        ContinousDoStepDeclaration doStep = new ContinousDoStepDeclaration(toolIdentifier, toolActionIdentifier, procIdentifier, scope, visitStepIn(context.stepIn()));
        if (doStep.isValid(ingredientTypeHandler))
        {
            scope.append(procIdentifier, doStep);
            return null;
        }
        else
        {
            throw new RuntimeException(procIdentifier + "Is an invalid continous do step");
        }
    }
    
    @Override public Void visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext context) 
    {
        
        ContinousDoStepDeclaration doStep = (ContinousDoStepDeclaration)scope.retrieve(context.procIdentifier().getText());
        doStep.ExecuteStep(ingredientTypeHandler);
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
    
}
