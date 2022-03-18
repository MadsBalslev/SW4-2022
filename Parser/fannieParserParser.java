// Generated from fannieParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fannieParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WS=9, 
		MAIN=10, RECIPE=11, TOOL_LIST=12, INGREDIENT_LIST=13, STEP_LIST=14, CONTAIN=15, 
		DO=16, OR=17, DESCRIPTION_STRING=18, START=19, STOP=20, WHEN=21, SERVE=22, 
		CONTENT_IN=23, TRANSFORM=24, TOOL_BASIC_TYPE_IDENTIFIER=25, INGREDIENT_BASIC_TYPE_IDENTIFIER=26, 
		COMPLEX_IDENTIFIER=27, AMOUNT=28, WEIGHT_UNIT=29, ABSTRACT_UNIT=30, TO_TASTE=31, 
		COMMENT=32;
	public static final int
		RULE_program = 0, RULE_mainRecipe = 1, RULE_subRecipe = 2, RULE_recipeBody = 3, 
		RULE_ingredientsList = 4, RULE_ingredientDeclaration = 5, RULE_amountDeclaration = 6, 
		RULE_toolsList = 7, RULE_stepsList = 8, RULE_toolDeclaration = 9, RULE_toolActionDeclaration = 10, 
		RULE_stepDeclaration = 11, RULE_serveStepDeclaration = 12, RULE_doStepDeclaration = 13, 
		RULE_collection = 14, RULE_continousDoStepStartDeclaration = 15, RULE_continousDoStepStopDeclaration = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainRecipe", "subRecipe", "recipeBody", "ingredientsList", 
			"ingredientDeclaration", "amountDeclaration", "toolsList", "stepsList", 
			"toolDeclaration", "toolActionDeclaration", "stepDeclaration", "serveStepDeclaration", 
			"doStepDeclaration", "collection", "continousDoStepStartDeclaration", 
			"continousDoStepStopDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'('", "')'", "'['", "']'", "':'", null, "'main'", 
			"'recipe'", "'tools'", "'ingredients'", "'steps'", "'contain'", "'do'", 
			"'or'", null, "'START'", "'STOP'", "'when'", "'serve'", "'content in'", 
			"'=>'", "'tool'", null, null, null, null, null, "'to-taste'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WS", "MAIN", "RECIPE", 
			"TOOL_LIST", "INGREDIENT_LIST", "STEP_LIST", "CONTAIN", "DO", "OR", "DESCRIPTION_STRING", 
			"START", "STOP", "WHEN", "SERVE", "CONTENT_IN", "TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", 
			"INGREDIENT_BASIC_TYPE_IDENTIFIER", "COMPLEX_IDENTIFIER", "AMOUNT", "WEIGHT_UNIT", 
			"ABSTRACT_UNIT", "TO_TASTE", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "fannieParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public fannieParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainRecipeContext mainRecipe() {
			return getRuleContext(MainRecipeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(fannieParserParser.EOF, 0); }
		public List<SubRecipeContext> subRecipe() {
			return getRuleContexts(SubRecipeContext.class);
		}
		public SubRecipeContext subRecipe(int i) {
			return getRuleContext(SubRecipeContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			mainRecipe();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RECIPE) {
				{
				{
				setState(35);
				subRecipe();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainRecipeContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(fannieParserParser.MAIN, 0); }
		public TerminalNode RECIPE() { return getToken(fannieParserParser.RECIPE, 0); }
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public RecipeBodyContext recipeBody() {
			return getRuleContext(RecipeBodyContext.class,0);
		}
		public MainRecipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainRecipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterMainRecipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitMainRecipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitMainRecipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainRecipeContext mainRecipe() throws RecognitionException {
		MainRecipeContext _localctx = new MainRecipeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(MAIN);
			setState(44);
			match(RECIPE);
			setState(45);
			match(COMPLEX_IDENTIFIER);
			setState(46);
			match(T__0);
			setState(47);
			recipeBody();
			setState(48);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubRecipeContext extends ParserRuleContext {
		public TerminalNode RECIPE() { return getToken(fannieParserParser.RECIPE, 0); }
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public RecipeBodyContext recipeBody() {
			return getRuleContext(RecipeBodyContext.class,0);
		}
		public SubRecipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subRecipe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterSubRecipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitSubRecipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitSubRecipe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubRecipeContext subRecipe() throws RecognitionException {
		SubRecipeContext _localctx = new SubRecipeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_subRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(RECIPE);
			setState(51);
			match(COMPLEX_IDENTIFIER);
			setState(52);
			match(T__0);
			setState(53);
			recipeBody();
			setState(54);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecipeBodyContext extends ParserRuleContext {
		public IngredientsListContext ingredientsList() {
			return getRuleContext(IngredientsListContext.class,0);
		}
		public ToolsListContext toolsList() {
			return getRuleContext(ToolsListContext.class,0);
		}
		public StepsListContext stepsList() {
			return getRuleContext(StepsListContext.class,0);
		}
		public RecipeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterRecipeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitRecipeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitRecipeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecipeBodyContext recipeBody() throws RecognitionException {
		RecipeBodyContext _localctx = new RecipeBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_recipeBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			ingredientsList();
			setState(57);
			match(T__2);
			setState(58);
			toolsList();
			setState(59);
			match(T__2);
			setState(60);
			stepsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IngredientsListContext extends ParserRuleContext {
		public TerminalNode INGREDIENT_LIST() { return getToken(fannieParserParser.INGREDIENT_LIST, 0); }
		public List<IngredientDeclarationContext> ingredientDeclaration() {
			return getRuleContexts(IngredientDeclarationContext.class);
		}
		public IngredientDeclarationContext ingredientDeclaration(int i) {
			return getRuleContext(IngredientDeclarationContext.class,i);
		}
		public IngredientsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterIngredientsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitIngredientsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitIngredientsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IngredientsListContext ingredientsList() throws RecognitionException {
		IngredientsListContext _localctx = new IngredientsListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ingredientsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(INGREDIENT_LIST);
			setState(63);
			match(T__0);
			setState(64);
			ingredientDeclaration();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(65);
				match(T__2);
				setState(66);
				ingredientDeclaration();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IngredientDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> INGREDIENT_BASIC_TYPE_IDENTIFIER() { return getTokens(fannieParserParser.INGREDIENT_BASIC_TYPE_IDENTIFIER); }
		public TerminalNode INGREDIENT_BASIC_TYPE_IDENTIFIER(int i) {
			return getToken(fannieParserParser.INGREDIENT_BASIC_TYPE_IDENTIFIER, i);
		}
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public List<AmountDeclarationContext> amountDeclaration() {
			return getRuleContexts(AmountDeclarationContext.class);
		}
		public AmountDeclarationContext amountDeclaration(int i) {
			return getRuleContext(AmountDeclarationContext.class,i);
		}
		public TerminalNode RECIPE() { return getToken(fannieParserParser.RECIPE, 0); }
		public TerminalNode OR() { return getToken(fannieParserParser.OR, 0); }
		public IngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterIngredientDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitIngredientDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitIngredientDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IngredientDeclarationContext ingredientDeclaration() throws RecognitionException {
		IngredientDeclarationContext _localctx = new IngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ingredientDeclaration);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				setState(75);
				match(COMPLEX_IDENTIFIER);
				setState(76);
				amountDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(RECIPE);
				setState(78);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				_la = _input.LA(1);
				if ( !(_la==INGREDIENT_BASIC_TYPE_IDENTIFIER || _la==COMPLEX_IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				match(COMPLEX_IDENTIFIER);
				setState(81);
				amountDeclaration();
				setState(82);
				match(OR);
				setState(83);
				_la = _input.LA(1);
				if ( !(_la==INGREDIENT_BASIC_TYPE_IDENTIFIER || _la==COMPLEX_IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(84);
				match(COMPLEX_IDENTIFIER);
				setState(85);
				amountDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				match(COMPLEX_IDENTIFIER);
				setState(88);
				match(COMPLEX_IDENTIFIER);
				setState(89);
				amountDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AmountDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> AMOUNT() { return getTokens(fannieParserParser.AMOUNT); }
		public TerminalNode AMOUNT(int i) {
			return getToken(fannieParserParser.AMOUNT, i);
		}
		public TerminalNode WEIGHT_UNIT() { return getToken(fannieParserParser.WEIGHT_UNIT, 0); }
		public TerminalNode ABSTRACT_UNIT() { return getToken(fannieParserParser.ABSTRACT_UNIT, 0); }
		public TerminalNode TO_TASTE() { return getToken(fannieParserParser.TO_TASTE, 0); }
		public AmountDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_amountDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterAmountDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitAmountDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitAmountDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmountDeclarationContext amountDeclaration() throws RecognitionException {
		AmountDeclarationContext _localctx = new AmountDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_amountDeclaration);
		int _la;
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(T__3);
				setState(93);
				match(AMOUNT);
				setState(94);
				match(WEIGHT_UNIT);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(95);
					match(T__2);
					setState(96);
					match(AMOUNT);
					setState(97);
					match(ABSTRACT_UNIT);
					}
				}

				setState(100);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(T__3);
				setState(102);
				match(TO_TASTE);
				setState(103);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToolsListContext extends ParserRuleContext {
		public TerminalNode TOOL_LIST() { return getToken(fannieParserParser.TOOL_LIST, 0); }
		public List<ToolDeclarationContext> toolDeclaration() {
			return getRuleContexts(ToolDeclarationContext.class);
		}
		public ToolDeclarationContext toolDeclaration(int i) {
			return getRuleContext(ToolDeclarationContext.class,i);
		}
		public ToolsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitToolsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToolsListContext toolsList() throws RecognitionException {
		ToolsListContext _localctx = new ToolsListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_toolsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(TOOL_LIST);
			setState(107);
			match(T__0);
			setState(108);
			toolDeclaration();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(109);
				match(T__2);
				setState(110);
				toolDeclaration();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepsListContext extends ParserRuleContext {
		public TerminalNode STEP_LIST() { return getToken(fannieParserParser.STEP_LIST, 0); }
		public List<StepDeclarationContext> stepDeclaration() {
			return getRuleContexts(StepDeclarationContext.class);
		}
		public StepDeclarationContext stepDeclaration(int i) {
			return getRuleContext(StepDeclarationContext.class,i);
		}
		public StepsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterStepsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitStepsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitStepsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepsListContext stepsList() throws RecognitionException {
		StepsListContext _localctx = new StepsListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stepsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(STEP_LIST);
			setState(119);
			match(T__0);
			setState(120);
			stepDeclaration();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(121);
				match(T__2);
				setState(122);
				stepDeclaration();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToolDeclarationContext extends ParserRuleContext {
		public TerminalNode TOOL_BASIC_TYPE_IDENTIFIER() { return getToken(fannieParserParser.TOOL_BASIC_TYPE_IDENTIFIER, 0); }
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public List<ToolActionDeclarationContext> toolActionDeclaration() {
			return getRuleContexts(ToolActionDeclarationContext.class);
		}
		public ToolActionDeclarationContext toolActionDeclaration(int i) {
			return getRuleContext(ToolActionDeclarationContext.class,i);
		}
		public ToolDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitToolDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToolDeclarationContext toolDeclaration() throws RecognitionException {
		ToolDeclarationContext _localctx = new ToolDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_toolDeclaration);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOOL_BASIC_TYPE_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(TOOL_BASIC_TYPE_IDENTIFIER);
				setState(131);
				match(COMPLEX_IDENTIFIER);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(132);
					match(T__5);
					setState(133);
					toolActionDeclaration();
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(134);
						match(T__2);
						setState(135);
						toolActionDeclaration();
						}
						}
						setState(140);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(141);
					match(T__6);
					}
				}

				}
				break;
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(COMPLEX_IDENTIFIER);
				setState(146);
				match(COMPLEX_IDENTIFIER);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(147);
					match(T__5);
					setState(148);
					toolActionDeclaration();
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(149);
						match(T__2);
						setState(150);
						toolActionDeclaration();
						}
						}
						setState(155);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(156);
					match(T__6);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ToolActionDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public TerminalNode INGREDIENT_BASIC_TYPE_IDENTIFIER() { return getToken(fannieParserParser.INGREDIENT_BASIC_TYPE_IDENTIFIER, 0); }
		public TerminalNode CONTAIN() { return getToken(fannieParserParser.CONTAIN, 0); }
		public AmountDeclarationContext amountDeclaration() {
			return getRuleContext(AmountDeclarationContext.class,0);
		}
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ToolActionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolActionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolActionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolActionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitToolActionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToolActionDeclarationContext toolActionDeclaration() throws RecognitionException {
		ToolActionDeclarationContext _localctx = new ToolActionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_toolActionDeclaration);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(COMPLEX_IDENTIFIER);
				setState(163);
				match(T__7);
				setState(164);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(COMPLEX_IDENTIFIER);
				setState(166);
				match(T__7);
				setState(167);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(CONTAIN);
				setState(169);
				match(T__7);
				setState(170);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				match(CONTAIN);
				setState(172);
				match(T__7);
				setState(173);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				match(CONTAIN);
				setState(175);
				match(T__7);
				setState(176);
				amountDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				match(COMPLEX_IDENTIFIER);
				setState(178);
				match(T__7);
				setState(179);
				match(CONTENT_IN);
				setState(180);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepDeclarationContext extends ParserRuleContext {
		public DoStepDeclarationContext doStepDeclaration() {
			return getRuleContext(DoStepDeclarationContext.class,0);
		}
		public ContinousDoStepStartDeclarationContext continousDoStepStartDeclaration() {
			return getRuleContext(ContinousDoStepStartDeclarationContext.class,0);
		}
		public ContinousDoStepStopDeclarationContext continousDoStepStopDeclaration() {
			return getRuleContext(ContinousDoStepStopDeclarationContext.class,0);
		}
		public ServeStepDeclarationContext serveStepDeclaration() {
			return getRuleContext(ServeStepDeclarationContext.class,0);
		}
		public StepDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterStepDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitStepDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitStepDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepDeclarationContext stepDeclaration() throws RecognitionException {
		StepDeclarationContext _localctx = new StepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stepDeclaration);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				doStepDeclaration();
				}
				break;
			case START:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				continousDoStepStartDeclaration();
				}
				break;
			case STOP:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				continousDoStepStopDeclaration();
				}
				break;
			case SERVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				serveStepDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServeStepDeclarationContext extends ParserRuleContext {
		public TerminalNode SERVE() { return getToken(fannieParserParser.SERVE, 0); }
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ServeStepDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serveStepDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterServeStepDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitServeStepDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitServeStepDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServeStepDeclarationContext serveStepDeclaration() throws RecognitionException {
		ServeStepDeclarationContext _localctx = new ServeStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_serveStepDeclaration);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(SERVE);
				setState(190);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(SERVE);
				setState(192);
				match(CONTENT_IN);
				setState(193);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStepDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public TerminalNode DO() { return getToken(fannieParserParser.DO, 0); }
		public TerminalNode CONTAIN() { return getToken(fannieParserParser.CONTAIN, 0); }
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public TerminalNode DESCRIPTION_STRING() { return getToken(fannieParserParser.DESCRIPTION_STRING, 0); }
		public TerminalNode TRANSFORM() { return getToken(fannieParserParser.TRANSFORM, 0); }
		public DoStepDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStepDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterDoStepDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitDoStepDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitDoStepDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStepDeclarationContext doStepDeclaration() throws RecognitionException {
		DoStepDeclarationContext _localctx = new DoStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_doStepDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(COMPLEX_IDENTIFIER);
			setState(197);
			match(DO);
			setState(198);
			_la = _input.LA(1);
			if ( !(_la==CONTAIN || _la==COMPLEX_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION_STRING) {
				{
				setState(199);
				match(DESCRIPTION_STRING);
				}
			}

			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				{
				setState(202);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case T__0:
				{
				setState(203);
				collection();
				}
				break;
			case CONTENT_IN:
				{
				setState(204);
				match(CONTENT_IN);
				setState(205);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(208);
				match(TRANSFORM);
				setState(209);
				match(COMPLEX_IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionContext extends ParserRuleContext {
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__0);
			setState(213);
			match(COMPLEX_IDENTIFIER);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(214);
				match(T__2);
				setState(215);
				match(COMPLEX_IDENTIFIER);
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinousDoStepStartDeclarationContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(fannieParserParser.START, 0); }
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public DoStepDeclarationContext doStepDeclaration() {
			return getRuleContext(DoStepDeclarationContext.class,0);
		}
		public ContinousDoStepStartDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continousDoStepStartDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterContinousDoStepStartDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitContinousDoStepStartDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitContinousDoStepStartDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinousDoStepStartDeclarationContext continousDoStepStartDeclaration() throws RecognitionException {
		ContinousDoStepStartDeclarationContext _localctx = new ContinousDoStepStartDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_continousDoStepStartDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(START);
			setState(224);
			match(COMPLEX_IDENTIFIER);
			setState(225);
			doStepDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinousDoStepStopDeclarationContext extends ParserRuleContext {
		public TerminalNode STOP() { return getToken(fannieParserParser.STOP, 0); }
		public List<TerminalNode> COMPLEX_IDENTIFIER() { return getTokens(fannieParserParser.COMPLEX_IDENTIFIER); }
		public TerminalNode COMPLEX_IDENTIFIER(int i) {
			return getToken(fannieParserParser.COMPLEX_IDENTIFIER, i);
		}
		public TerminalNode WHEN() { return getToken(fannieParserParser.WHEN, 0); }
		public TerminalNode DESCRIPTION_STRING() { return getToken(fannieParserParser.DESCRIPTION_STRING, 0); }
		public TerminalNode TRANSFORM() { return getToken(fannieParserParser.TRANSFORM, 0); }
		public ContinousDoStepStopDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continousDoStepStopDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterContinousDoStepStopDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitContinousDoStepStopDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof fannieParserVisitor ) return ((fannieParserVisitor<? extends T>)visitor).visitContinousDoStepStopDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinousDoStepStopDeclarationContext continousDoStepStopDeclaration() throws RecognitionException {
		ContinousDoStepStopDeclarationContext _localctx = new ContinousDoStepStopDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continousDoStepStopDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(STOP);
			setState(228);
			match(COMPLEX_IDENTIFIER);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(229);
				match(WHEN);
				setState(230);
				match(DESCRIPTION_STRING);
				}
			}

			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(233);
				match(TRANSFORM);
				setState(234);
				match(COMPLEX_IDENTIFIER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7"+
		"\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b\3\b"+
		"\3\b\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\3\t\3\t\7\tr\n\t\f\t\16\tu\13\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\7\n~\n\n\f\n\16\n\u0081\13\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u008b\n\13\f\13\16\13\u008e\13\13\3\13\3\13"+
		"\5\13\u0092\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u009a\n\13\f\13\16"+
		"\13\u009d\13\13\3\13\3\13\5\13\u00a1\n\13\5\13\u00a3\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b8"+
		"\n\f\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00c5"+
		"\n\16\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3\17\3\17\3\17\3\17\5\17\u00d1"+
		"\n\17\3\17\3\17\5\17\u00d5\n\17\3\20\3\20\3\20\3\20\7\20\u00db\n\20\f"+
		"\20\16\20\u00de\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\5\22\u00ea\n\22\3\22\3\22\5\22\u00ee\n\22\3\22\2\2\23\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"\2\4\3\2\34\35\4\2\21\21\35\35\2\u00fc\2$\3"+
		"\2\2\2\4-\3\2\2\2\6\64\3\2\2\2\b:\3\2\2\2\n@\3\2\2\2\f\\\3\2\2\2\16j\3"+
		"\2\2\2\20l\3\2\2\2\22x\3\2\2\2\24\u00a2\3\2\2\2\26\u00b7\3\2\2\2\30\u00bd"+
		"\3\2\2\2\32\u00c4\3\2\2\2\34\u00c6\3\2\2\2\36\u00d6\3\2\2\2 \u00e1\3\2"+
		"\2\2\"\u00e5\3\2\2\2$(\5\4\3\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-.\7\f\2\2./\7\r"+
		"\2\2/\60\7\35\2\2\60\61\7\3\2\2\61\62\5\b\5\2\62\63\7\4\2\2\63\5\3\2\2"+
		"\2\64\65\7\r\2\2\65\66\7\35\2\2\66\67\7\3\2\2\678\5\b\5\289\7\4\2\29\7"+
		"\3\2\2\2:;\5\n\6\2;<\7\5\2\2<=\5\20\t\2=>\7\5\2\2>?\5\22\n\2?\t\3\2\2"+
		"\2@A\7\17\2\2AB\7\3\2\2BG\5\f\7\2CD\7\5\2\2DF\5\f\7\2EC\3\2\2\2FI\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\4\2\2K\13\3\2\2\2LM\7"+
		"\34\2\2MN\7\35\2\2N]\5\16\b\2OP\7\r\2\2P]\7\35\2\2QR\t\2\2\2RS\7\35\2"+
		"\2ST\5\16\b\2TU\7\23\2\2UV\t\2\2\2VW\7\35\2\2WX\5\16\b\2X]\3\2\2\2YZ\7"+
		"\35\2\2Z[\7\35\2\2[]\5\16\b\2\\L\3\2\2\2\\O\3\2\2\2\\Q\3\2\2\2\\Y\3\2"+
		"\2\2]\r\3\2\2\2^_\7\6\2\2_`\7\36\2\2`d\7\37\2\2ab\7\5\2\2bc\7\36\2\2c"+
		"e\7 \2\2da\3\2\2\2de\3\2\2\2ef\3\2\2\2fk\7\7\2\2gh\7\6\2\2hi\7!\2\2ik"+
		"\7\7\2\2j^\3\2\2\2jg\3\2\2\2k\17\3\2\2\2lm\7\16\2\2mn\7\3\2\2ns\5\24\13"+
		"\2op\7\5\2\2pr\5\24\13\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2"+
		"\2\2us\3\2\2\2vw\7\4\2\2w\21\3\2\2\2xy\7\20\2\2yz\7\3\2\2z\177\5\30\r"+
		"\2{|\7\5\2\2|~\5\30\r\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\4\2\2\u0083"+
		"\23\3\2\2\2\u0084\u0085\7\33\2\2\u0085\u0091\7\35\2\2\u0086\u0087\7\b"+
		"\2\2\u0087\u008c\5\26\f\2\u0088\u0089\7\5\2\2\u0089\u008b\5\26\f\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\t\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u0086\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u00a3\3\2"+
		"\2\2\u0093\u0094\7\35\2\2\u0094\u00a0\7\35\2\2\u0095\u0096\7\b\2\2\u0096"+
		"\u009b\5\26\f\2\u0097\u0098\7\5\2\2\u0098\u009a\5\26\f\2\u0099\u0097\3"+
		"\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\t\2\2\u009f\u00a1\3\2"+
		"\2\2\u00a0\u0095\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u0084\3\2\2\2\u00a2\u0093\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a5\7\35\2"+
		"\2\u00a5\u00a6\7\n\2\2\u00a6\u00b8\7\34\2\2\u00a7\u00a8\7\35\2\2\u00a8"+
		"\u00a9\7\n\2\2\u00a9\u00b8\7\35\2\2\u00aa\u00ab\7\21\2\2\u00ab\u00ac\7"+
		"\n\2\2\u00ac\u00b8\7\35\2\2\u00ad\u00ae\7\21\2\2\u00ae\u00af\7\n\2\2\u00af"+
		"\u00b8\7\34\2\2\u00b0\u00b1\7\21\2\2\u00b1\u00b2\7\n\2\2\u00b2\u00b8\5"+
		"\16\b\2\u00b3\u00b4\7\35\2\2\u00b4\u00b5\7\n\2\2\u00b5\u00b6\7\31\2\2"+
		"\u00b6\u00b8\7\35\2\2\u00b7\u00a4\3\2\2\2\u00b7\u00a7\3\2\2\2\u00b7\u00aa"+
		"\3\2\2\2\u00b7\u00ad\3\2\2\2\u00b7\u00b0\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8"+
		"\27\3\2\2\2\u00b9\u00be\5\34\17\2\u00ba\u00be\5 \21\2\u00bb\u00be\5\""+
		"\22\2\u00bc\u00be\5\32\16\2\u00bd\u00b9\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00c0\7\30\2"+
		"\2\u00c0\u00c5\7\35\2\2\u00c1\u00c2\7\30\2\2\u00c2\u00c3\7\31\2\2\u00c3"+
		"\u00c5\7\35\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\33\3\2\2"+
		"\2\u00c6\u00c7\7\35\2\2\u00c7\u00c8\7\22\2\2\u00c8\u00ca\t\3\2\2\u00c9"+
		"\u00cb\7\24\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00d0\3"+
		"\2\2\2\u00cc\u00d1\7\35\2\2\u00cd\u00d1\5\36\20\2\u00ce\u00cf\7\31\2\2"+
		"\u00cf\u00d1\7\35\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d5\7\35\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\35\3\2\2\2\u00d6\u00d7"+
		"\7\3\2\2\u00d7\u00dc\7\35\2\2\u00d8\u00d9\7\5\2\2\u00d9\u00db\7\35\2\2"+
		"\u00da\u00d8\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\7\4\2\2\u00e0"+
		"\37\3\2\2\2\u00e1\u00e2\7\25\2\2\u00e2\u00e3\7\35\2\2\u00e3\u00e4\5\34"+
		"\17\2\u00e4!\3\2\2\2\u00e5\u00e6\7\26\2\2\u00e6\u00e9\7\35\2\2\u00e7\u00e8"+
		"\7\27\2\2\u00e8\u00ea\7\24\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2"+
		"\u00ea\u00ed\3\2\2\2\u00eb\u00ec\7\32\2\2\u00ec\u00ee\7\35\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee#\3\2\2\2\27(G\\djs\177\u008c\u0091"+
		"\u009b\u00a0\u00a2\u00b7\u00bd\u00c4\u00ca\u00d0\u00d4\u00dc\u00e9\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}