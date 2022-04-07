import org.antlr.v4.runtime.*;

public class CodeGeneratorVisitor extends fannieParserBaseVisitor<Void> {
    String markdownFormat = "";
    String filename = "";
    int stepNum = 1;

    private String SplitOnCapital(String s) {
        String[] r = s.split("(?=\\p{Upper})");
        return String.join(" ", r);
    }

    private <T extends ParserRuleContext> String[] MakeStepDeclaration(T ctx) {
        String[] infoArr = new String[ctx.getChildCount()];

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof fannieParserParser.StepInContext) {
                if (ctx.getChild(i).getChild(0) instanceof fannieParserParser.ContentInContext) {
                    infoArr[i] = SplitOnCapital(ctx.getChild(i).getChild(0).getText());

                } else {
                    infoArr[i] = ctx.getChild(i).getText();
                }

            } else {
                infoArr[i] = ctx.getChild(i).getText();
            }
        }

        return infoArr;
    }

    @Override
    public Void visitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx) {
        markdownFormat += "# " + ctx.getText() + "\n";
        filename += ctx.getText();

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

    public Void visitToolDeclaration(fannieParserParser.ToolDeclarationContext ctx) {
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
        String mdString = "";
        String[] infoArr = MakeStepDeclaration(ctx);

        int comp = infoArr[2].compareTo("contain");
        if (comp == 0) {
            infoArr[2] = "Put";
        }

        if (infoArr.length == 5) { // Step har optional description
            String s = infoArr[3];
            String m = s.substring(1, s.length() - 1);
            mdString += infoArr[2] + " " + infoArr[4] + (infoArr[2] == "Put" ? " in " : " with ") + infoArr[0] + " "
                    + m;
            markdownFormat += mdString;
            return null;
        } else {
            mdString += infoArr[2] + " " + infoArr[3] + (infoArr[2] == "Put" ? " in " : " with ") + infoArr[0];
            markdownFormat += mdString;
            return null;
        }
    }

    public Void visitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext ctx) {
        String mdString = "";
        String[] infoArr = MakeStepDeclaration(ctx);

        if (infoArr.length == 7) {
            String s = infoArr[5];
            String m = s.substring(1, s.length() - 1);
            mdString += "With " + infoArr[2] + " " + infoArr[4] + " the " + infoArr[6] + " " + m;
            markdownFormat += mdString;
            return null;
        } else {

            mdString += "With " + infoArr[2] + " " + infoArr[4] + " the " + infoArr[5];
            markdownFormat += mdString;
            return null;
        }
    }

    public Void visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext ctx) {
        int i = ctx.getChildCount();
        String s = ctx.getChild(i - 1).toString();
        String m = s.substring(1, s.length() - 1);
        markdownFormat += "Stop when " + m;
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
        String s = ctx.getText();

        if (ctx.getChildCount() > 4)
        {
            String[] r = s.split(",");
            r[1] = r[1].replaceAll( "(\\d)([A-Za-z])", "$1 $2" ); 
            markdownFormat += String.join(", ", r) + "\n";
            return null;
        }

        markdownFormat += s + "\n";

        return null;
    }

    public Void visitProcDeclaration(fannieParserParser.ProcIdentifierContext ctx) {
        markdownFormat += ctx.getText();

        return null;
    }

    public Void visitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext ctx) {
        // markdownFormat += ctx.getText();
        String[] infoArr = new String[ctx.getChildCount()];
        String mdString = "";

        for (int i = 0; i < ctx.getChildCount(); i++) {
            infoArr[i] = SplitOnCapital(ctx.getChild(i).getText());
        }

        mdString = infoArr[0] + " the " + infoArr[1] + " ";
        markdownFormat += mdString;

        return null;
    }

}
