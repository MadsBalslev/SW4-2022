// Generated from fannieParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fannieParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface fannieParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(fannieParserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#mainRecipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainRecipe(fannieParserParser.MainRecipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#subRecipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubRecipe(fannieParserParser.SubRecipeContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#recipeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecipeBody(fannieParserParser.RecipeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#ingredientsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIngredientsList(fannieParserParser.IngredientsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#ingredientDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIngredientDeclaration(fannieParserParser.IngredientDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#amountDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmountDeclaration(fannieParserParser.AmountDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#toolsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToolsList(fannieParserParser.ToolsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#stepsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepsList(fannieParserParser.StepsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#toolDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToolDeclaration(fannieParserParser.ToolDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#toolActionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToolActionDeclaration(fannieParserParser.ToolActionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#stepDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepDeclaration(fannieParserParser.StepDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#serveStepDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServeStepDeclaration(fannieParserParser.ServeStepDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#doStepDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStepDeclaration(fannieParserParser.DoStepDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#collection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollection(fannieParserParser.CollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#continousDoStepStartDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinousDoStepStartDeclaration(fannieParserParser.ContinousDoStepStartDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link fannieParserParser#continousDoStepStopDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinousDoStepStopDeclaration(fannieParserParser.ContinousDoStepStopDeclarationContext ctx);
}