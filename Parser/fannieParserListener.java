// Generated from fannieParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fannieParserParser}.
 */
public interface fannieParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(fannieParserParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(fannieParserParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterToolIdentifier(fannieParserParser.ToolIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitToolIdentifier(fannieParserParser.ToolIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolActionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterToolActionIdentifier(fannieParserParser.ToolActionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolActionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitToolActionIdentifier(fannieParserParser.ToolActionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterToolTypeIdentifier(fannieParserParser.ToolTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitToolTypeIdentifier(fannieParserParser.ToolTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#ingredientTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterIngredientTypeIdentifier(fannieParserParser.IngredientTypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#ingredientTypeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitIngredientTypeIdentifier(fannieParserParser.IngredientTypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#ingredientIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterIngredientIdentifier(fannieParserParser.IngredientIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#ingredientIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitIngredientIdentifier(fannieParserParser.IngredientIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#recipeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#recipeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitRecipeIdentifier(fannieParserParser.RecipeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#procIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterProcIdentifier(fannieParserParser.ProcIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#procIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitProcIdentifier(fannieParserParser.ProcIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#mainRecipe}.
	 * @param ctx the parse tree
	 */
	void enterMainRecipe(fannieParserParser.MainRecipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#mainRecipe}.
	 * @param ctx the parse tree
	 */
	void exitMainRecipe(fannieParserParser.MainRecipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#subRecipe}.
	 * @param ctx the parse tree
	 */
	void enterSubRecipe(fannieParserParser.SubRecipeContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#subRecipe}.
	 * @param ctx the parse tree
	 */
	void exitSubRecipe(fannieParserParser.SubRecipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#recipeBody}.
	 * @param ctx the parse tree
	 */
	void enterRecipeBody(fannieParserParser.RecipeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#recipeBody}.
	 * @param ctx the parse tree
	 */
	void exitRecipeBody(fannieParserParser.RecipeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#stepIn}.
	 * @param ctx the parse tree
	 */
	void enterStepIn(fannieParserParser.StepInContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#stepIn}.
	 * @param ctx the parse tree
	 */
	void exitStepIn(fannieParserParser.StepInContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#stepOut}.
	 * @param ctx the parse tree
	 */
	void enterStepOut(fannieParserParser.StepOutContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#stepOut}.
	 * @param ctx the parse tree
	 */
	void exitStepOut(fannieParserParser.StepOutContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#ingredientsList}.
	 * @param ctx the parse tree
	 */
	void enterIngredientsList(fannieParserParser.IngredientsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#ingredientsList}.
	 * @param ctx the parse tree
	 */
	void exitIngredientsList(fannieParserParser.IngredientsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#ingredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIngredientDeclaration(fannieParserParser.IngredientDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#ingredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIngredientDeclaration(fannieParserParser.IngredientDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#deterministicIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#deterministicIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDeterministicIngredientDeclaration(fannieParserParser.DeterministicIngredientDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#nondeterministicIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#nondeterministicIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNondeterministicIngredientDeclaration(fannieParserParser.NondeterministicIngredientDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#recipeIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#recipeIngredientDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecipeIngredientDeclaration(fannieParserParser.RecipeIngredientDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#ingredientSubtypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIngredientSubtypeDeclaration(fannieParserParser.IngredientSubtypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#ingredientSubtypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIngredientSubtypeDeclaration(fannieParserParser.IngredientSubtypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#amountDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAmountDeclaration(fannieParserParser.AmountDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#amountDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAmountDeclaration(fannieParserParser.AmountDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolsList}.
	 * @param ctx the parse tree
	 */
	void enterToolsList(fannieParserParser.ToolsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolsList}.
	 * @param ctx the parse tree
	 */
	void exitToolsList(fannieParserParser.ToolsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#stepsList}.
	 * @param ctx the parse tree
	 */
	void enterStepsList(fannieParserParser.StepsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#stepsList}.
	 * @param ctx the parse tree
	 */
	void exitStepsList(fannieParserParser.StepsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterToolDeclaration(fannieParserParser.ToolDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitToolDeclaration(fannieParserParser.ToolDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolActionDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void enterToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolActionDeclarationsList}.
	 * @param ctx the parse tree
	 */
	void exitToolActionDeclarationsList(fannieParserParser.ToolActionDeclarationsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#toolActionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#toolActionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#stepDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStepDeclaration(fannieParserParser.StepDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#stepDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStepDeclaration(fannieParserParser.StepDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#serveStepDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#serveStepDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#doStepDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDoStepDeclaration(fannieParserParser.DoStepDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#doStepDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#collection}.
	 * @param ctx the parse tree
	 */
	void enterCollection(fannieParserParser.CollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#collection}.
	 * @param ctx the parse tree
	 */
	void exitCollection(fannieParserParser.CollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#continousDoStepStartDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#continousDoStepStartDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link fannieParserParser#continousDoStepStopDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link fannieParserParser#continousDoStepStopDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext ctx);
}