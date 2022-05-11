import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.Context;

import java.util.HashMap;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.tool.xml.exceptions.NotImplementedException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import Handlers.IngredientTypeHandler;
import fannieTypes.HasBeenServed;
import fannieTypes.Ingredient;
import fannieTypes.ProcIdentifier;
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
        scope.stringPrinter(scope.getSymbolTable(), "ingredient");
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
        scope.stringPrinter(scope.getSymbolTable(), "ingredient");
        //debug code
        scope.Remove(context.stepIn().getText());
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
            throw new RuntimeException("Tool action is not an action of tool");
        }

        if (context.stepOut() != null) {
            final List<String> outPutIngredientsIdentifiers = visitStepOut(context.stepOut());
            if (toolActionIdentifier == "contain" && toolActionIdentifier == "remove")
                throw new RuntimeException("contain or remove action can not have output");
            for (Ingredient ingredient : inputIngredients) {
                if (ingredient.isType("content in")) {
                    throw new RuntimeException("step input can not be content in when the step has an output");
                }
            }
            for (Ingredient ingredient : inputIngredients) {
                if (!ingredient.isType(toolAction.input))
                    throw new RuntimeException("Mismatch between actual input:" + ingredient.ingredientType.identifier + " and expected input type: " + toolAction.input);
                scope.Remove(ingredient.identifier);
            }
            for (String outPutIdentifier : outPutIngredientsIdentifiers) {
                Ingredient outPutIngredient = new Ingredient(outPutIdentifier, ingredientTypeHandler, toolAction.output);
                scope.append(outPutIdentifier, outPutIngredient);
            }
        } else if (context.stepOut() ==  null) {
            new DoStepDeclaration(toolIdentifier, toolActionIdentifier, scope, visitStepIn(context.stepIn()), ingredientTypeHandler);
        }
        return null;
    }

    // hides: the evaluation logic related to ContinousDoStepStartDeclarationContext
    // input: ContinousDoStepStartDeclarationContext
    // output: updated scope
    // preconditions: the ContinousDoStepStartDeclarationContext should be correctly constructed
    // postconditions: the procIdentifier has been mapped to the process in the scope
    @Override public Scope visitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext context) {
        // get information about step from cst
        String toolIdentifier = context.toolIdentifier().getText();
        String toolActionIdentifier = context.toolActionIdentifier().getText();
        String procIdentifier = context.procIdentifier().getText();
        String stepIn = context.stepIn().getText();

        // create the step that should be started
        CharStream input = CharStreams.fromString(toolIdentifier + " do " + toolActionIdentifier + " " + stepIn);
        fannieParserLexer lexer = new fannieParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        fannieParserParser parser = new fannieParserParser(tokens);
        fannieParserParser.DoStepDeclarationContext doStepDeclarationContext = 
            parser.doStepDeclaration();
        
        // if the step can not be evaluated at this time throw an exception.
        if (!canEvaluateDoStepDeclarationWithoutStepOut(doStepDeclarationContext))
            throw new RuntimeException("could not START step because step was not valid");

        // map the proceesIdentifier to the step in the scope
        scope.append(procIdentifier, new Procedure(procIdentifier, doStepDeclarationContext));
        
        return scope;
    }

    // hides: the logic behind chechking if a doStepDeclaration without a stepOut can be evaluated
    // input: doStepDeclarationContext
    // output: false if it can't be evaluated, else true
    // precondition: doStepDeclarationContext should be properly constructed and have no stepOut
    // postcondition: none
    private boolean canEvaluateDoStepDeclarationWithoutStepOut(fannieParserParser.DoStepDeclarationContext doStep) {
        // if the doStep has an outStep hit the user of this function over the head
        if (doStep.stepOut() == null)
            throw new IllegalArgumentException("you cleary didn't read the documentation for this function");

        // set canEvaluate flag to false
        boolean canEvaluate = false;

        // if can evaluate as normal step declaration set canEvaluate true
        if (canEvaluateDoStepDeclarationWithoutStepOut_normal(doStep))
            canEvaluate = true;
        // else if can evaluate as contain step declaration set canEvaluate true
        else if (canEvaluateDoStepDeclarationWithoutStepOut_contain(doStep))
            canEvaluate = true;
        // else if can evaluate as remove step declaration set canEvaluate true
        else if (canEvaluateDoStepDeclarationWithoutStepOut_remove(doStep))
            canEvaluate = true;
        // else if can evaluate as content in step declaration where the tool acts upon ingredient set canEvaluate true
        else if (canEvaluateDoStepDeclarationWithoutStepOut_contentInIngr(doStep))
            canEvaluate = true;
        // else if can evaluate as content in step declaration where the tool acts upon content of tool set canEvaluate true
        else if (canEvaluateDoStepDeclarationWithoutStepOut_contentInTool(doStep))
            canEvaluate = true;

        // return canEvaluate
        return canEvaluate;
    }

    private boolean canEvaluateDoStepDeclarationWithoutStepOut_remove(
            fannieParserParser.DoStepDeclarationContext doStep) {
        final List<Ingredient> inputIngredients = visitStepIn(doStep.stepIn());
        Tool tool = (Tool)scope.retrieve(doStep.toolIdentifier().getText());
        ToolAction toolAction;
        try {
            toolAction = tool.getToolAction(doStep.toolActionIdentifier().getText());
        } catch (Exception e) {
            return false;
        }
    }

    private boolean canEvaluateDoStepDeclarationWithoutStepOut_contain(
            fannieParserParser.DoStepDeclarationContext doStep) {
        final List<Ingredient> inputIngredients = visitStepIn(doStep.stepIn());

        Tool tool = (Tool)scope.retrieve(doStep.toolIdentifier().getText());
        ToolAction toolAction;
        try {
            toolAction = tool.getToolAction(doStep.toolActionIdentifier().getText());
        } catch (Exception e) {
            return false;
        }

        for (Ingredient ingredient : inputIngredients) {
            if (!ingredient.isType(toolAction.input))
                return false;
        }


        return doStep.toolActionIdentifier().getText() == "remove";
    }

    private boolean canEvaluateDoStepDeclarationWithoutStepOut_normal(
            fannieParserParser.DoStepDeclarationContext doStep) {
        final List<Ingredient> inputIngredients = visitStepIn(doStep.stepIn());
        Tool tool = (Tool)scope.retrieve(doStep.toolIdentifier().getText());
        ToolAction toolAction;
        try {
            toolAction = tool.getToolAction(doStep.toolActionIdentifier().getText());
        } catch (Exception e) {
            return false;
        }

        for (Ingredient ingredient : inputIngredients) {
            if (!ingredient.isType(toolAction.input))
                return false;
        }

        return doStep.toolActionIdentifier().getText() != "contain" 
            && doStep.toolActionIdentifier().getText() != "remove";
    }

    // hides: the logic behind evaluating a continousDoStepStopDeclaration
    // input: ContinousDoStepStopDeclarationContext
    // output: updated scope
    // preconditions: the ContinousDoStepStartDeclarationContext should be correctly constructed
    // postconditions: the procIdentifier has been unmapped to the process in the scope, and the doStep has been executed
    @Override public Scope visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext context) {
        // get Procedure Identifier and look up the procedure identifier in the symbol table and get the procedure
        String procedureIdentfier = context.procIdentifier().getText();
        Procedure procedure = (Procedure)scope.retrieve(procedureIdentfier);

        // if the stopDeclaration does not have an outStep: evaluate the step contained in the procedure as is
        if (context.stepOut() == null) {
            visitDoStepDeclaration(procedure.Step);
        // else if the stopDeclaration does have an outStep: append the " => {outStep}" to the step contained in the procedure and evaluate it
        } else {
            String stepAsText = procedure.Step.getText();
            stepAsText += " => " + context.stepOut().getText();

            CharStream input = CharStreams.fromString(stepAsText);
            fannieParserLexer lexer = new fannieParserLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            fannieParserParser parser = new fannieParserParser(tokens);
            fannieParserParser.DoStepDeclarationContext doStepDeclarationContext = 
                parser.doStepDeclaration();
            visitDoStepDeclaration(doStepDeclarationContext);
        }

        // remove procedure from scope and return updated scope
        scope.Remove(procedureIdentfier);
        return scope;
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
            ingredientList.add((Ingredient)scope.retrieve(ingredient));
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
        System.out.println("ARE WE HERE");
        scope.stringPrinter(scope.getSymbolTable(), "ingredient");
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
