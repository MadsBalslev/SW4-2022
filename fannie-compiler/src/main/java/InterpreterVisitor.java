import java.util.List;
public class InterpreterVisitor extends fannieParserBaseVisitor<Void> {
    List<String> toolsList;
    List<String> recipesList;
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    { 
        visitChildren(context); 
        return null;
    }   
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    { 
        recipesList.add(context.recipeIdentifier().getText());
        visitChildren(context); 
        return null;
    }
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        recipesList.add(context.recipeIdentifier().getText());
        visitChildren(context);
        return null;
    }
    @Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitRecipeBody(fannieParserParser.RecipeBodyContext context) 
    { 
        visitChildren(context); 
        return null;
    }
    @Override public Void visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    { 
        visitChildren(context); 
        return null;
    }
    @Override public Void visitToolsList(fannieParserParser.ToolsListContext context) 
    {
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
        visitChildren(context);
        return null;
    }
    @Override public Void visitToolIdentifier(fannieParserParser.ToolIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @Override public Void visitRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext context) 
    { 
        visitChildren(context);
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
