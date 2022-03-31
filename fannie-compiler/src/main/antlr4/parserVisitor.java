public class parserVisitor extends fannieParserBaseVisitor<Void> {
    @Override public Void visitFannie(fannieParserParser.FannieContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitMainRecipe(fannieParserParser.MainRecipeContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitSubRecipe(fannieParserParser.SubRecipeContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitRecipeBody(fannieParserParser.RecipeBodyContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitIngredientsList(fannieParserParser.IngredientsListContext ctx) 
    { 
        visitChildren(ctx); 
    }
    @Override public Void visitToolsList(fannieParserParser.ToolsListContext ctx) 
    {
        visitChildren(ctx); 
    }
    @Override public Void visitStepsList(fannieParserParser.StepsListContext ctx) 
    { 
        visitChildren(ctx); 
    }
}
