public class CodeGeneratorVisitor extends fannieParserBaseVisitor<Void> {

    @Override public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx) 
    {
      System.out.println(ctx);
      visitChildren(ctx);
      return null;
    }
    
}