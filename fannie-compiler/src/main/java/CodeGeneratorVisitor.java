public class CodeGeneratorVisitor extends fannieParserBaseVisitor<Void> {
    String markdownFormat = "";
    String filename = "";
    int stepNum = 1;
    
    @Override
    public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx) {
        markdownFormat += "# " + ctx.getText() + "\n";
        filename += ctx.getText();


        visitChildren(ctx);
        return null;
    }

    public Void visitFannie(fannieParserParser.FannieContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public Void visitMainRecipe(fannieParserParser.MainRecipeContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public Void visitSubRecipe(fannieParserParser.SubRecipeContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public Void visitRecipeBody(fannieParserParser.RecipeBodyContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public Void visitIngredientsList(fannieParserParser.IngredientsListContext ctx) {
        markdownFormat += "### Ingredients" + "\n";

        visitChildren(ctx);
        return null;
    }

    public Void visitToolsList(fannieParserParser.ToolsListContext ctx) {
        markdownFormat += "### Tools" + "\n";

        visitChildren(ctx);
        return null;
    }

    public Void visitToolDeclaration(fannieParserParser.ToolDeclarationContext ctx){
        markdownFormat += "- ";

        visitChildren(ctx);
        return null;
    }


    public Void visitToolIdentifier(fannieParserParser.ToolIdentifierContext ctx) {
        markdownFormat += ctx.getText();

        // visitChildren(ctx);
        return null;
    }

    public Void visitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext ctx) {
        markdownFormat += "\n";
        return null;
    }

    public Void visitStepsList(fannieParserParser.StepsListContext ctx) {
        stepNum = 0;
        markdownFormat += "### Steps";

        visitChildren(ctx);
        return null;
    }

    public Void visitStepDeclaration(fannieParserParser.StepDeclarationContext ctx) {
        stepNum++;
        markdownFormat += "\n" + stepNum + ". ";
        
        visitChildren(ctx);
        return null;
    }

    public Void visitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext ctx) {
        // markdownFormat += ctx.getText() + "\n";
        visitChildren(ctx);
        return null;
    }


    public Void visitIngredientDeclaration(fannieParserParser.IngredientDeclarationContext ctx) {
        markdownFormat += "- ";

        visitChildren(ctx);
        return null;
    }
    public Void visitIngredientIdentifier(fannieParserParser.IngredientIdentifierContext ctx) {
        markdownFormat += ctx.getText() + " ";

        return null;
    }

    public Void visitAmountDeclaration(fannieParserParser.AmountDeclarationContext ctx) {
        markdownFormat += ctx.getText() + "\n";

        return null;
    }


}
