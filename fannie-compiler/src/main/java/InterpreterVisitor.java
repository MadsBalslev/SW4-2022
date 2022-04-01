public class InterpreterVisitor extends fannieParserBaseVisitor<Void> {
    @Override public Void visitFannie(fannieParserParser.FannieContext context) 
    { 
        visitChildren(context); 
        return null;
    }   
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext context) 
    { 
        visitChildren(context); 
        return null;
    }
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        visitChildren(context);
        return null;
    }
    @ Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext context) 
    { 
        visitChildren(context);
        return null;
    }
    public Void visitRecipeBody(fannieParserParser.RecipeBodyContext context) 
    { 
        visitChildren(context); 
        return null;
    }
    public Void visitIngredientsList(fannieParserParser.IngredientsListContext context) 
    { 
        visitChildren(context); 
        return null;
    }
    public Void visitToolsList(fannieParserParser.ToolsListContext context) 
    {
        visitChildren(context);
        return null;
    }
    public Void visitStepsList(fannieParserParser.StepsListContext context) 
    { 
        visitChildren(context);
        return null;
    }
}
