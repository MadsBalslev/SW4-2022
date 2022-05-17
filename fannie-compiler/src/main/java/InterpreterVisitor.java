import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import com.itextpdf.tool.xml.exceptions.NotImplementedException;
import org.antlr.v4.runtime.tree.TerminalNode;
import Exceptions.CompilerException;
import Handlers.IngredientTypeHandler;
import fannieTypes.HasBeenServed;
import fannieTypes.Ingredient;
import fannieTypes.Tool;
import fannieTypes.steps.*;
import fannieTypes.toolActions.*;
import scope.Scope;
import Exceptions.*;
public class InterpreterVisitor extends fannieParserBaseVisitor<Object> {

    //test
    IngredientTypeHandler ingredientTypeHandler = new IngredientTypeHandler();
    Scope scope = new Scope();
    
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    {
        visitChildren(context);

        return null;
    }
    
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    {
        Scope oldScope = scope;
        scope = oldScope.createScope();
        visitChildren(context);

       
        
        if(scope.isIngredientListEmpty() == false)
        {
            throw new CompilerException("Not all ingredients are served");
        }
        if (scope.hasToolsBeenUsed() == false) {
            throw new CompilerException("Not all tools are used");
        }
        if (scope.isProcListEmpty() == false) {
            throw new CompilerException("Not all procedures are stopped");
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
        return null;
    }
    
    @Override public Void visitRecipeBody(fannieParserParser.RecipeBodyContext context) 
    {
        visitChildren(context); 
        return null;
    }
    
    @Override public Void visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    {
        HasBeenServed hasServed = new HasBeenServed(scope);
        scope.append("hasServed", hasServed);
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitToolsList(fannieParserParser.ToolsListContext context) 
    {
        if(scope.isIngredientListEmpty() == true)
        {
            throw new CompilerException("No ingredients in the recipe");
        }
        visitChildren(context);
        return null;
    }
    
    @Override public Void visitStepsList(fannieParserParser.StepsListContext context) 
    {
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
                throw new CompilerException("Toolaction: "+ key + " has already been declared");
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
            throw new CompilerException("Invalid type of tool action");
        }
        
    }
    
    @Override public Void visitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext context) 
    {
        HasBeenServed hasBeenServed = (HasBeenServed)scope.retrieve("hasServed");
        if (hasBeenServed.isServed) {
            throw new CompilerException("Recipe has already been served");
        }
        hasBeenServed.isServed = true;
        scope.Remove("hasServed");
        scope.append("hasServed", hasBeenServed);
        visitChildren(context);
        
        
        List<Ingredient> ingredients = visitStepIn(context.stepIn());
        for (Ingredient ingredient : ingredients) {
            scope.Remove(ingredient.identifier); 
        }

        return null;
    }
    
    @Override public Void visitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext context) 
    { 
        final String toolIdentifier = context.toolIdentifier().getText();
        final String toolActionIdentifier = context.toolActionIdentifier().getText();
        final List<Ingredient> inputIngredients = visitStepIn(context.stepIn());
        final Tool tool = (Tool)scope.retrieve(context.toolIdentifier().getText());
        ToolAction toolAction;
        try {
            toolAction = tool.getToolAction(toolActionIdentifier);
        } catch (Exception e) {
            throw new CompilerException("Tool action is not an action of tool");
        }

        if (context.stepOut() != null) {
            final List<String> outPutIngredientsIdentifiers = visitStepOut(context.stepOut());
            DoStepDeclaration doStep = new DoStepDeclaration(toolIdentifier, toolActionIdentifier, scope, inputIngredients, ingredientTypeHandler);
            doStep.Execute(outPutIngredientsIdentifiers);
        } else if (context.stepOut() ==  null) {
            DoStepDeclaration doStep = new DoStepDeclaration(toolIdentifier, toolActionIdentifier, scope, inputIngredients, ingredientTypeHandler);
            doStep.Execute();
        }
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
            throw new CompilerException(procIdentifier + "Is an invalid continous do step");
        }
    }
    
    @Override public Void visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext context) 
    {
        
        ContinousDoStepDeclaration doStep = (ContinousDoStepDeclaration)scope.retrieve(context.procIdentifier().getText());
        if (context.stepOut() != null) {
            doStep.ExecuteStep(ingredientTypeHandler, visitStepOut(context.stepOut()), scope);
        } else {
            doStep.ExecuteStep(ingredientTypeHandler);
        }
        return null;

    }
    
    @Override public List<Ingredient> visitStepIn(fannieParserParser.StepInContext context) 
    {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();

        if (context.ingredientCollection() != null) {
            List<String> ingredientStrings = visitIngredientCollection(context.ingredientCollection());
            for (String string : ingredientStrings)
                ingredientList.add((Ingredient)scope.retrieve(string));
            return ingredientList;
        } else if (context.ingredientIdentifier() != null) {
            String string = visitIngredientIdentifier(context.ingredientIdentifier());
            ingredientList.add((Ingredient)scope.retrieve(string));
            return ingredientList;
        } else if (context.contentIn() != null) {
            Ingredient ingredient = visitContentIn(context.contentIn());
            ingredientList.add((Ingredient)scope.retrieve(ingredient.identifier));
            return ingredientList;
        } else {
            return null;
        } 
    }
    

    @Override public List<String> visitStepOut(fannieParserParser.StepOutContext context) 
    {
        if (context.ingredientCollection() != null)
           return visitIngredientCollection(context.ingredientCollection()); 
        else if (context.ingredientIdentifier() != null) {
            List<String> strings = new ArrayList<String>();
            strings.add(visitIngredientIdentifier(context.ingredientIdentifier()));
            return strings;
        } else 
            return null;
    }
    
    public Ingredient visitContentIn(fannieParserParser.ContentInContext context) 
    {
        visitChildren(context);
        Ingredient ingredient = (Ingredient)scope.retrieve(context.getText());
        return ingredient;
    }
    
    public List<String> visitIngredientCollection(fannieParserParser.IngredientCollectionContext context) {
        List<String> oldIngredients = new ArrayList<String>();
            for (int i = 0; i < context.getChildCount(); i++) {
                if (context.getChild(i) instanceof fannieParserParser.IngredientIdentifierContext) {
                    oldIngredients.add(context.getChild(i).getText());
                }
            }
        return oldIngredients;
    }
    
}
