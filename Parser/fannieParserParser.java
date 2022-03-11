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
	}

	public final IngredientDeclarationContext ingredientDeclaration() throws RecognitionException {
		IngredientDeclarationContext _localctx = new IngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ingredientDeclaration);
		try {
			setState(87);
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
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				setState(80);
				match(COMPLEX_IDENTIFIER);
				setState(81);
				amountDeclaration();
				setState(82);
				match(OR);
				setState(83);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				setState(84);
				match(COMPLEX_IDENTIFIER);
				setState(85);
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
	}

	public final AmountDeclarationContext amountDeclaration() throws RecognitionException {
		AmountDeclarationContext _localctx = new AmountDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_amountDeclaration);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(T__3);
				setState(90);
				match(AMOUNT);
				setState(91);
				match(WEIGHT_UNIT);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(92);
					match(T__2);
					setState(93);
					match(AMOUNT);
					setState(94);
					match(ABSTRACT_UNIT);
					}
				}

				setState(97);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__3);
				setState(99);
				match(TO_TASTE);
				setState(100);
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
	}

	public final ToolsListContext toolsList() throws RecognitionException {
		ToolsListContext _localctx = new ToolsListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_toolsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(TOOL_LIST);
			setState(104);
			match(T__0);
			setState(105);
			toolDeclaration();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(106);
				match(T__2);
				setState(107);
				toolDeclaration();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
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
	}

	public final StepsListContext stepsList() throws RecognitionException {
		StepsListContext _localctx = new StepsListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stepsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(STEP_LIST);
			setState(116);
			match(T__0);
			setState(117);
			stepDeclaration();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(118);
				match(T__2);
				setState(119);
				stepDeclaration();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
	}

	public final ToolDeclarationContext toolDeclaration() throws RecognitionException {
		ToolDeclarationContext _localctx = new ToolDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_toolDeclaration);
		int _la;
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOOL_BASIC_TYPE_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(TOOL_BASIC_TYPE_IDENTIFIER);
				setState(128);
				match(COMPLEX_IDENTIFIER);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(129);
					match(T__5);
					setState(130);
					toolActionDeclaration();
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(131);
						match(T__2);
						setState(132);
						toolActionDeclaration();
						}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(138);
					match(T__6);
					}
				}

				}
				break;
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(COMPLEX_IDENTIFIER);
				setState(143);
				match(COMPLEX_IDENTIFIER);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(144);
					match(T__5);
					setState(145);
					toolActionDeclaration();
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(146);
						match(T__2);
						setState(147);
						toolActionDeclaration();
						}
						}
						setState(152);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(153);
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
	}

	public final ToolActionDeclarationContext toolActionDeclaration() throws RecognitionException {
		ToolActionDeclarationContext _localctx = new ToolActionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_toolActionDeclaration);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(COMPLEX_IDENTIFIER);
				setState(160);
				match(T__7);
				setState(161);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				match(COMPLEX_IDENTIFIER);
				setState(163);
				match(T__7);
				setState(164);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(CONTAIN);
				setState(166);
				match(T__7);
				setState(167);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(CONTAIN);
				setState(169);
				match(T__7);
				setState(170);
				match(INGREDIENT_BASIC_TYPE_IDENTIFIER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				match(CONTAIN);
				setState(172);
				match(T__7);
				setState(173);
				amountDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				match(COMPLEX_IDENTIFIER);
				setState(175);
				match(T__7);
				setState(176);
				match(CONTENT_IN);
				setState(177);
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
	}

	public final StepDeclarationContext stepDeclaration() throws RecognitionException {
		StepDeclarationContext _localctx = new StepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stepDeclaration);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				doStepDeclaration();
				}
				break;
			case START:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				continousDoStepStartDeclaration();
				}
				break;
			case STOP:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				continousDoStepStopDeclaration();
				}
				break;
			case SERVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
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
	}

	public final ServeStepDeclarationContext serveStepDeclaration() throws RecognitionException {
		ServeStepDeclarationContext _localctx = new ServeStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_serveStepDeclaration);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(SERVE);
				setState(187);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(SERVE);
				setState(189);
				match(CONTENT_IN);
				setState(190);
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
	}

	public final DoStepDeclarationContext doStepDeclaration() throws RecognitionException {
		DoStepDeclarationContext _localctx = new DoStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_doStepDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(COMPLEX_IDENTIFIER);
			setState(194);
			match(DO);
			setState(195);
			_la = _input.LA(1);
			if ( !(_la==CONTAIN || _la==COMPLEX_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION_STRING) {
				{
				setState(196);
				match(DESCRIPTION_STRING);
				}
			}

			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				{
				setState(199);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			case T__0:
				{
				setState(200);
				collection();
				}
				break;
			case CONTENT_IN:
				{
				setState(201);
				match(CONTENT_IN);
				setState(202);
				match(COMPLEX_IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(205);
				match(TRANSFORM);
				setState(206);
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
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__0);
			setState(210);
			match(COMPLEX_IDENTIFIER);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(211);
				match(T__2);
				setState(212);
				match(COMPLEX_IDENTIFIER);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(218);
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
	}

	public final ContinousDoStepStartDeclarationContext continousDoStepStartDeclaration() throws RecognitionException {
		ContinousDoStepStartDeclarationContext _localctx = new ContinousDoStepStartDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_continousDoStepStartDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(START);
			setState(221);
			match(COMPLEX_IDENTIFIER);
			setState(222);
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
	}

	public final ContinousDoStepStopDeclarationContext continousDoStepStopDeclaration() throws RecognitionException {
		ContinousDoStepStopDeclarationContext _localctx = new ContinousDoStepStopDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_continousDoStepStopDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(STOP);
			setState(225);
			match(COMPLEX_IDENTIFIER);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(226);
				match(WHEN);
				setState(227);
				match(DESCRIPTION_STRING);
				}
			}

			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(230);
				match(TRANSFORM);
				setState(231);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00ed\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7"+
		"\6F\n\6\f\6\16\6I\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bb\n\b\3\b\3\b\3\b\3\b"+
		"\5\bh\n\b\3\t\3\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\7\n{\n\n\f\n\16\n~\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u0088\n\13\f\13\16\13\u008b\13\13\3\13\3\13\5\13\u008f\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0097\n\13\f\13\16\13\u009a\13\13"+
		"\3\13\3\13\5\13\u009e\n\13\5\13\u00a0\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b5\n\f\3\r\3\r"+
		"\3\r\3\r\5\r\u00bb\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00c2\n\16\3\17\3"+
		"\17\3\17\3\17\5\17\u00c8\n\17\3\17\3\17\3\17\3\17\5\17\u00ce\n\17\3\17"+
		"\3\17\5\17\u00d2\n\17\3\20\3\20\3\20\3\20\7\20\u00d8\n\20\f\20\16\20\u00db"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u00e7\n"+
		"\22\3\22\3\22\5\22\u00eb\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\3\4\2\21\21\35\35\2\u00f8\2$\3\2\2\2\4-\3\2\2\2\6\64\3"+
		"\2\2\2\b:\3\2\2\2\n@\3\2\2\2\fY\3\2\2\2\16g\3\2\2\2\20i\3\2\2\2\22u\3"+
		"\2\2\2\24\u009f\3\2\2\2\26\u00b4\3\2\2\2\30\u00ba\3\2\2\2\32\u00c1\3\2"+
		"\2\2\34\u00c3\3\2\2\2\36\u00d3\3\2\2\2 \u00de\3\2\2\2\"\u00e2\3\2\2\2"+
		"$(\5\4\3\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2"+
		"\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-.\7\f\2\2./\7\r\2\2/\60\7\35\2\2\60"+
		"\61\7\3\2\2\61\62\5\b\5\2\62\63\7\4\2\2\63\5\3\2\2\2\64\65\7\r\2\2\65"+
		"\66\7\35\2\2\66\67\7\3\2\2\678\5\b\5\289\7\4\2\29\7\3\2\2\2:;\5\n\6\2"+
		";<\7\5\2\2<=\5\20\t\2=>\7\5\2\2>?\5\22\n\2?\t\3\2\2\2@A\7\17\2\2AB\7\3"+
		"\2\2BG\5\f\7\2CD\7\5\2\2DF\5\f\7\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\4\2\2K\13\3\2\2\2LM\7\34\2\2MN\7\35\2\2N"+
		"Z\5\16\b\2OP\7\r\2\2PZ\7\35\2\2QR\7\34\2\2RS\7\35\2\2ST\5\16\b\2TU\7\23"+
		"\2\2UV\7\34\2\2VW\7\35\2\2WX\5\16\b\2XZ\3\2\2\2YL\3\2\2\2YO\3\2\2\2YQ"+
		"\3\2\2\2Z\r\3\2\2\2[\\\7\6\2\2\\]\7\36\2\2]a\7\37\2\2^_\7\5\2\2_`\7\36"+
		"\2\2`b\7 \2\2a^\3\2\2\2ab\3\2\2\2bc\3\2\2\2ch\7\7\2\2de\7\6\2\2ef\7!\2"+
		"\2fh\7\7\2\2g[\3\2\2\2gd\3\2\2\2h\17\3\2\2\2ij\7\16\2\2jk\7\3\2\2kp\5"+
		"\24\13\2lm\7\5\2\2mo\5\24\13\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"qs\3\2\2\2rp\3\2\2\2st\7\4\2\2t\21\3\2\2\2uv\7\20\2\2vw\7\3\2\2w|\5\30"+
		"\r\2xy\7\5\2\2y{\5\30\r\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177"+
		"\3\2\2\2~|\3\2\2\2\177\u0080\7\4\2\2\u0080\23\3\2\2\2\u0081\u0082\7\33"+
		"\2\2\u0082\u008e\7\35\2\2\u0083\u0084\7\b\2\2\u0084\u0089\5\26\f\2\u0085"+
		"\u0086\7\5\2\2\u0086\u0088\5\26\f\2\u0087\u0085\3\2\2\2\u0088\u008b\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008d\7\t\2\2\u008d\u008f\3\2\2\2\u008e\u0083\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u00a0\3\2\2\2\u0090\u0091\7\35\2\2\u0091"+
		"\u009d\7\35\2\2\u0092\u0093\7\b\2\2\u0093\u0098\5\26\f\2\u0094\u0095\7"+
		"\5\2\2\u0095\u0097\5\26\f\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009c\7\t\2\2\u009c\u009e\3\2\2\2\u009d\u0092\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u0081\3\2\2\2\u009f\u0090\3\2"+
		"\2\2\u00a0\25\3\2\2\2\u00a1\u00a2\7\35\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00b5"+
		"\7\34\2\2\u00a4\u00a5\7\35\2\2\u00a5\u00a6\7\n\2\2\u00a6\u00b5\7\35\2"+
		"\2\u00a7\u00a8\7\21\2\2\u00a8\u00a9\7\n\2\2\u00a9\u00b5\7\35\2\2\u00aa"+
		"\u00ab\7\21\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00b5\7\34\2\2\u00ad\u00ae\7"+
		"\21\2\2\u00ae\u00af\7\n\2\2\u00af\u00b5\5\16\b\2\u00b0\u00b1\7\35\2\2"+
		"\u00b1\u00b2\7\n\2\2\u00b2\u00b3\7\31\2\2\u00b3\u00b5\7\35\2\2\u00b4\u00a1"+
		"\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00a7\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4"+
		"\u00ad\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00bb\5\34\17"+
		"\2\u00b7\u00bb\5 \21\2\u00b8\u00bb\5\"\22\2\u00b9\u00bb\5\32\16\2\u00ba"+
		"\u00b6\3\2\2\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00bb\31\3\2\2\2\u00bc\u00bd\7\30\2\2\u00bd\u00c2\7\35\2\2\u00be"+
		"\u00bf\7\30\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c2\7\35\2\2\u00c1\u00bc"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c4\7\35\2\2\u00c4"+
		"\u00c5\7\22\2\2\u00c5\u00c7\t\2\2\2\u00c6\u00c8\7\24\2\2\u00c7\u00c6\3"+
		"\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cd\3\2\2\2\u00c9\u00ce\7\35\2\2\u00ca"+
		"\u00ce\5\36\20\2\u00cb\u00cc\7\31\2\2\u00cc\u00ce\7\35\2\2\u00cd\u00c9"+
		"\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00d0\7\32\2\2\u00d0\u00d2\7\35\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3"+
		"\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d4\7\3\2\2\u00d4\u00d9\7\35\2\2\u00d5"+
		"\u00d6\7\5\2\2\u00d6\u00d8\7\35\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3"+
		"\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\7\4\2\2\u00dd\37\3\2\2\2\u00de\u00df\7\25\2"+
		"\2\u00df\u00e0\7\35\2\2\u00e0\u00e1\5\34\17\2\u00e1!\3\2\2\2\u00e2\u00e3"+
		"\7\26\2\2\u00e3\u00e6\7\35\2\2\u00e4\u00e5\7\27\2\2\u00e5\u00e7\7\24\2"+
		"\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9"+
		"\7\32\2\2\u00e9\u00eb\7\35\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2"+
		"\u00eb#\3\2\2\2\27(GYagp|\u0089\u008e\u0098\u009d\u009f\u00b4\u00ba\u00c1"+
		"\u00c7\u00cd\u00d1\u00d9\u00e6\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}