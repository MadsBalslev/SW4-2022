

public class InterpreterVisitor extends fannieParserBaseVisitor<Token>{

    @Override public Token visitFannie(fannieParserParser.FannieContext context)
    {
        return visitChildren(context);
    }
    @Override public Token visitMainRecipe(fannieParserParser.MainRecipeContext context)
    {
        return visitChildren(context);
    }
    @Override public Token visitSubRecipe(fannieParserParser.SubRecipeContext context) 
    { 
        return visitChildren(context); 
    }
    
   
}
