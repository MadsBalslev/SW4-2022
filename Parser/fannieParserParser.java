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
		REMOVE=16, DO=17, OR=18, DESCRIPTION_STRING=19, START=20, STOP=21, WHEN=22, 
		SERVE=23, CONTENT_IN=24, TRANSFORM=25, TOOL_BASIC_TYPE_IDENTIFIER=26, 
		INGREDIENT_BASIC_TYPE_IDENTIFIER=27, COMPLEX_IDENTIFIER=28, AMOUNT=29, 
		WEIGHT_UNIT=30, ABSTRACT_UNIT=31, TO_TASTE=32, COMMENT=33;
	public static final int
		RULE_program = 0, RULE_toolIdentifier = 1, RULE_toolActionIdentifier = 2, 
		RULE_toolTypeIdentifier = 3, RULE_ingredientTypeIdentifier = 4, RULE_ingredientIdentifier = 5, 
		RULE_recipeIdentifier = 6, RULE_procIdentifier = 7, RULE_mainRecipe = 8, 
		RULE_subRecipe = 9, RULE_recipeBody = 10, RULE_stepIn = 11, RULE_stepOut = 12, 
		RULE_ingredientsList = 13, RULE_ingredientDeclaration = 14, RULE_deterministicIngredientDeclaration = 15, 
		RULE_nondeterministicIngredientDeclaration = 16, RULE_recipeIngredientDeclaration = 17, 
		RULE_ingredientSubtypeDeclaration = 18, RULE_amountDeclaration = 19, RULE_toolsList = 20, 
		RULE_stepsList = 21, RULE_toolDeclaration = 22, RULE_toolActionDeclarationsList = 23, 
		RULE_toolActionDeclaration = 24, RULE_stepDeclaration = 25, RULE_serveStepDeclaration = 26, 
		RULE_doStepDeclaration = 27, RULE_collection = 28, RULE_continousDoStepStartDeclaration = 29, 
		RULE_continousDoStepStopDeclaration = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "toolIdentifier", "toolActionIdentifier", "toolTypeIdentifier", 
			"ingredientTypeIdentifier", "ingredientIdentifier", "recipeIdentifier", 
			"procIdentifier", "mainRecipe", "subRecipe", "recipeBody", "stepIn", 
			"stepOut", "ingredientsList", "ingredientDeclaration", "deterministicIngredientDeclaration", 
			"nondeterministicIngredientDeclaration", "recipeIngredientDeclaration", 
			"ingredientSubtypeDeclaration", "amountDeclaration", "toolsList", "stepsList", 
			"toolDeclaration", "toolActionDeclarationsList", "toolActionDeclaration", 
			"stepDeclaration", "serveStepDeclaration", "doStepDeclaration", "collection", 
			"continousDoStepStartDeclaration", "continousDoStepStopDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'('", "')'", "'['", "']'", "':'", null, "'main'", 
			"'recipe'", "'tools'", "'ingredients'", "'steps'", "'contain'", "'remove'", 
			"'do'", "'or'", null, "'START'", "'STOP'", "'when'", "'serve'", "'content in'", 
			"'=>'", "'tool'", null, null, null, null, null, "'to-taste'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WS", "MAIN", "RECIPE", 
			"TOOL_LIST", "INGREDIENT_LIST", "STEP_LIST", "CONTAIN", "REMOVE", "DO", 
			"OR", "DESCRIPTION_STRING", "START", "STOP", "WHEN", "SERVE", "CONTENT_IN", 
			"TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", "INGREDIENT_BASIC_TYPE_IDENTIFIER", 
			"COMPLEX_IDENTIFIER", "AMOUNT", "WEIGHT_UNIT", "ABSTRACT_UNIT", "TO_TASTE", 
			"COMMENT"
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
			setState(62);
			mainRecipe();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RECIPE) {
				{
				{
				setState(63);
				subRecipe();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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

	public static class ToolIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public ToolIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolIdentifier(this);
		}
	}

	public final ToolIdentifierContext toolIdentifier() throws RecognitionException {
		ToolIdentifierContext _localctx = new ToolIdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_toolIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(COMPLEX_IDENTIFIER);
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

	public static class ToolActionIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public TerminalNode CONTAIN() { return getToken(fannieParserParser.CONTAIN, 0); }
		public TerminalNode REMOVE() { return getToken(fannieParserParser.REMOVE, 0); }
		public ToolActionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolActionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolActionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolActionIdentifier(this);
		}
	}

	public final ToolActionIdentifierContext toolActionIdentifier() throws RecognitionException {
		ToolActionIdentifierContext _localctx = new ToolActionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_toolActionIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONTAIN) | (1L << REMOVE) | (1L << COMPLEX_IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ToolTypeIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public TerminalNode TOOL_BASIC_TYPE_IDENTIFIER() { return getToken(fannieParserParser.TOOL_BASIC_TYPE_IDENTIFIER, 0); }
		public ToolTypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolTypeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolTypeIdentifier(this);
		}
	}

	public final ToolTypeIdentifierContext toolTypeIdentifier() throws RecognitionException {
		ToolTypeIdentifierContext _localctx = new ToolTypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_toolTypeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==TOOL_BASIC_TYPE_IDENTIFIER || _la==COMPLEX_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IngredientTypeIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public TerminalNode INGREDIENT_BASIC_TYPE_IDENTIFIER() { return getToken(fannieParserParser.INGREDIENT_BASIC_TYPE_IDENTIFIER, 0); }
		public IngredientTypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientTypeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterIngredientTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitIngredientTypeIdentifier(this);
		}
	}

	public final IngredientTypeIdentifierContext ingredientTypeIdentifier() throws RecognitionException {
		IngredientTypeIdentifierContext _localctx = new IngredientTypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ingredientTypeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==INGREDIENT_BASIC_TYPE_IDENTIFIER || _la==COMPLEX_IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class IngredientIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public IngredientIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterIngredientIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitIngredientIdentifier(this);
		}
	}

	public final IngredientIdentifierContext ingredientIdentifier() throws RecognitionException {
		IngredientIdentifierContext _localctx = new IngredientIdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ingredientIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(COMPLEX_IDENTIFIER);
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

	public static class RecipeIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public RecipeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterRecipeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitRecipeIdentifier(this);
		}
	}

	public final RecipeIdentifierContext recipeIdentifier() throws RecognitionException {
		RecipeIdentifierContext _localctx = new RecipeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_recipeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(COMPLEX_IDENTIFIER);
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

	public static class ProcIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public ProcIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterProcIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitProcIdentifier(this);
		}
	}

	public final ProcIdentifierContext procIdentifier() throws RecognitionException {
		ProcIdentifierContext _localctx = new ProcIdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(COMPLEX_IDENTIFIER);
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
		public RecipeIdentifierContext recipeIdentifier() {
			return getRuleContext(RecipeIdentifierContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_mainRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(MAIN);
			setState(86);
			match(RECIPE);
			setState(87);
			recipeIdentifier();
			setState(88);
			match(T__0);
			setState(89);
			recipeBody();
			setState(90);
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
		public RecipeIdentifierContext recipeIdentifier() {
			return getRuleContext(RecipeIdentifierContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_subRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(RECIPE);
			setState(93);
			recipeIdentifier();
			setState(94);
			match(T__0);
			setState(95);
			recipeBody();
			setState(96);
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
		enterRule(_localctx, 20, RULE_recipeBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			ingredientsList();
			setState(99);
			match(T__2);
			setState(100);
			toolsList();
			setState(101);
			match(T__2);
			setState(102);
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

	public static class StepInContext extends ParserRuleContext {
		public IngredientIdentifierContext ingredientIdentifier() {
			return getRuleContext(IngredientIdentifierContext.class,0);
		}
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
		public StepInContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepIn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterStepIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitStepIn(this);
		}
	}

	public final StepInContext stepIn() throws RecognitionException {
		StepInContext _localctx = new StepInContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stepIn);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				ingredientIdentifier();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				collection();
				}
				break;
			case CONTENT_IN:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(CONTENT_IN);
				setState(107);
				toolIdentifier();
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

	public static class StepOutContext extends ParserRuleContext {
		public IngredientIdentifierContext ingredientIdentifier() {
			return getRuleContext(IngredientIdentifierContext.class,0);
		}
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public StepOutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepOut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterStepOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitStepOut(this);
		}
	}

	public final StepOutContext stepOut() throws RecognitionException {
		StepOutContext _localctx = new StepOutContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stepOut);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				ingredientIdentifier();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				collection();
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
		enterRule(_localctx, 26, RULE_ingredientsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(INGREDIENT_LIST);
			setState(115);
			match(T__0);
			setState(116);
			ingredientDeclaration();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(117);
				match(T__2);
				setState(118);
				ingredientDeclaration();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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
		public DeterministicIngredientDeclarationContext deterministicIngredientDeclaration() {
			return getRuleContext(DeterministicIngredientDeclarationContext.class,0);
		}
		public NondeterministicIngredientDeclarationContext nondeterministicIngredientDeclaration() {
			return getRuleContext(NondeterministicIngredientDeclarationContext.class,0);
		}
		public RecipeIngredientDeclarationContext recipeIngredientDeclaration() {
			return getRuleContext(RecipeIngredientDeclarationContext.class,0);
		}
		public IngredientSubtypeDeclarationContext ingredientSubtypeDeclaration() {
			return getRuleContext(IngredientSubtypeDeclarationContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_ingredientDeclaration);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				deterministicIngredientDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				nondeterministicIngredientDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				recipeIngredientDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				ingredientSubtypeDeclaration();
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

	public static class DeterministicIngredientDeclarationContext extends ParserRuleContext {
		public IngredientTypeIdentifierContext ingredientTypeIdentifier() {
			return getRuleContext(IngredientTypeIdentifierContext.class,0);
		}
		public IngredientIdentifierContext ingredientIdentifier() {
			return getRuleContext(IngredientIdentifierContext.class,0);
		}
		public AmountDeclarationContext amountDeclaration() {
			return getRuleContext(AmountDeclarationContext.class,0);
		}
		public DeterministicIngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deterministicIngredientDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterDeterministicIngredientDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitDeterministicIngredientDeclaration(this);
		}
	}

	public final DeterministicIngredientDeclarationContext deterministicIngredientDeclaration() throws RecognitionException {
		DeterministicIngredientDeclarationContext _localctx = new DeterministicIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deterministicIngredientDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			ingredientTypeIdentifier();
			setState(133);
			ingredientIdentifier();
			setState(134);
			amountDeclaration();
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

	public static class NondeterministicIngredientDeclarationContext extends ParserRuleContext {
		public List<DeterministicIngredientDeclarationContext> deterministicIngredientDeclaration() {
			return getRuleContexts(DeterministicIngredientDeclarationContext.class);
		}
		public DeterministicIngredientDeclarationContext deterministicIngredientDeclaration(int i) {
			return getRuleContext(DeterministicIngredientDeclarationContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(fannieParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(fannieParserParser.OR, i);
		}
		public NondeterministicIngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nondeterministicIngredientDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterNondeterministicIngredientDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitNondeterministicIngredientDeclaration(this);
		}
	}

	public final NondeterministicIngredientDeclarationContext nondeterministicIngredientDeclaration() throws RecognitionException {
		NondeterministicIngredientDeclarationContext _localctx = new NondeterministicIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nondeterministicIngredientDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			deterministicIngredientDeclaration();
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(137);
				match(OR);
				setState(138);
				deterministicIngredientDeclaration();
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
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

	public static class RecipeIngredientDeclarationContext extends ParserRuleContext {
		public TerminalNode RECIPE() { return getToken(fannieParserParser.RECIPE, 0); }
		public RecipeIdentifierContext recipeIdentifier() {
			return getRuleContext(RecipeIdentifierContext.class,0);
		}
		public RecipeIngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipeIngredientDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterRecipeIngredientDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitRecipeIngredientDeclaration(this);
		}
	}

	public final RecipeIngredientDeclarationContext recipeIngredientDeclaration() throws RecognitionException {
		RecipeIngredientDeclarationContext _localctx = new RecipeIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_recipeIngredientDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(RECIPE);
			setState(144);
			recipeIdentifier();
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

	public static class IngredientSubtypeDeclarationContext extends ParserRuleContext {
		public List<IngredientTypeIdentifierContext> ingredientTypeIdentifier() {
			return getRuleContexts(IngredientTypeIdentifierContext.class);
		}
		public IngredientTypeIdentifierContext ingredientTypeIdentifier(int i) {
			return getRuleContext(IngredientTypeIdentifierContext.class,i);
		}
		public IngredientSubtypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientSubtypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterIngredientSubtypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitIngredientSubtypeDeclaration(this);
		}
	}

	public final IngredientSubtypeDeclarationContext ingredientSubtypeDeclaration() throws RecognitionException {
		IngredientSubtypeDeclarationContext _localctx = new IngredientSubtypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ingredientSubtypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			ingredientTypeIdentifier();
			setState(147);
			ingredientTypeIdentifier();
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
		enterRule(_localctx, 38, RULE_amountDeclaration);
		int _la;
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(T__3);
				setState(150);
				match(AMOUNT);
				setState(151);
				match(WEIGHT_UNIT);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(152);
					match(T__2);
					setState(153);
					match(AMOUNT);
					setState(154);
					match(ABSTRACT_UNIT);
					}
				}

				setState(157);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__3);
				setState(159);
				match(TO_TASTE);
				setState(160);
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
		enterRule(_localctx, 40, RULE_toolsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(TOOL_LIST);
			setState(164);
			match(T__0);
			setState(165);
			toolDeclaration();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(166);
				match(T__2);
				setState(167);
				toolDeclaration();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
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
		enterRule(_localctx, 42, RULE_stepsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(STEP_LIST);
			setState(176);
			match(T__0);
			setState(177);
			stepDeclaration();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(178);
				match(T__2);
				setState(179);
				stepDeclaration();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
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
		public ToolTypeIdentifierContext toolTypeIdentifier() {
			return getRuleContext(ToolTypeIdentifierContext.class,0);
		}
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
		public ToolActionDeclarationsListContext toolActionDeclarationsList() {
			return getRuleContext(ToolActionDeclarationsListContext.class,0);
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
		enterRule(_localctx, 44, RULE_toolDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			toolTypeIdentifier();
			setState(188);
			toolIdentifier();
			setState(189);
			toolActionDeclarationsList();
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

	public static class ToolActionDeclarationsListContext extends ParserRuleContext {
		public List<ToolActionDeclarationContext> toolActionDeclaration() {
			return getRuleContexts(ToolActionDeclarationContext.class);
		}
		public ToolActionDeclarationContext toolActionDeclaration(int i) {
			return getRuleContext(ToolActionDeclarationContext.class,i);
		}
		public ToolActionDeclarationsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolActionDeclarationsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).enterToolActionDeclarationsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof fannieParserListener ) ((fannieParserListener)listener).exitToolActionDeclarationsList(this);
		}
	}

	public final ToolActionDeclarationsListContext toolActionDeclarationsList() throws RecognitionException {
		ToolActionDeclarationsListContext _localctx = new ToolActionDeclarationsListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_toolActionDeclarationsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(191);
				match(T__5);
				setState(192);
				toolActionDeclaration();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(193);
					match(T__2);
					setState(194);
					toolActionDeclaration();
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__6);
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

	public static class ToolActionDeclarationContext extends ParserRuleContext {
		public TerminalNode CONTAIN() { return getToken(fannieParserParser.CONTAIN, 0); }
		public IngredientIdentifierContext ingredientIdentifier() {
			return getRuleContext(IngredientIdentifierContext.class,0);
		}
		public ToolActionIdentifierContext toolActionIdentifier() {
			return getRuleContext(ToolActionIdentifierContext.class,0);
		}
		public List<IngredientTypeIdentifierContext> ingredientTypeIdentifier() {
			return getRuleContexts(IngredientTypeIdentifierContext.class);
		}
		public IngredientTypeIdentifierContext ingredientTypeIdentifier(int i) {
			return getRuleContext(IngredientTypeIdentifierContext.class,i);
		}
		public TerminalNode TRANSFORM() { return getToken(fannieParserParser.TRANSFORM, 0); }
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_toolActionDeclaration);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(CONTAIN);
				setState(205);
				match(T__7);
				setState(206);
				ingredientIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				toolActionIdentifier();
				setState(208);
				match(T__7);
				setState(209);
				ingredientTypeIdentifier();
				setState(210);
				match(TRANSFORM);
				setState(211);
				ingredientTypeIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				toolActionIdentifier();
				setState(214);
				match(T__7);
				setState(215);
				match(CONTENT_IN);
				setState(216);
				toolIdentifier();
				setState(217);
				match(TRANSFORM);
				setState(218);
				ingredientTypeIdentifier();
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
		enterRule(_localctx, 50, RULE_stepDeclaration);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				doStepDeclaration();
				}
				break;
			case START:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				continousDoStepStartDeclaration();
				}
				break;
			case STOP:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				continousDoStepStopDeclaration();
				}
				break;
			case SERVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
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
		public RecipeIdentifierContext recipeIdentifier() {
			return getRuleContext(RecipeIdentifierContext.class,0);
		}
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
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
		enterRule(_localctx, 52, RULE_serveStepDeclaration);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(SERVE);
				setState(229);
				recipeIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(SERVE);
				setState(231);
				match(CONTENT_IN);
				setState(232);
				toolIdentifier();
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
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
		public TerminalNode DO() { return getToken(fannieParserParser.DO, 0); }
		public ToolActionIdentifierContext toolActionIdentifier() {
			return getRuleContext(ToolActionIdentifierContext.class,0);
		}
		public StepInContext stepIn() {
			return getRuleContext(StepInContext.class,0);
		}
		public TerminalNode DESCRIPTION_STRING() { return getToken(fannieParserParser.DESCRIPTION_STRING, 0); }
		public TerminalNode TRANSFORM() { return getToken(fannieParserParser.TRANSFORM, 0); }
		public StepOutContext stepOut() {
			return getRuleContext(StepOutContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_doStepDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			toolIdentifier();
			setState(236);
			match(DO);
			setState(237);
			toolActionIdentifier();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION_STRING) {
				{
				setState(238);
				match(DESCRIPTION_STRING);
				}
			}

			setState(241);
			stepIn();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(242);
				match(TRANSFORM);
				setState(243);
				stepOut();
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
		public List<IngredientIdentifierContext> ingredientIdentifier() {
			return getRuleContexts(IngredientIdentifierContext.class);
		}
		public IngredientIdentifierContext ingredientIdentifier(int i) {
			return getRuleContext(IngredientIdentifierContext.class,i);
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
		enterRule(_localctx, 56, RULE_collection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__0);
			setState(247);
			ingredientIdentifier();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(248);
				match(T__2);
				setState(249);
				ingredientIdentifier();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(255);
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
		public ProcIdentifierContext procIdentifier() {
			return getRuleContext(ProcIdentifierContext.class,0);
		}
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
		enterRule(_localctx, 58, RULE_continousDoStepStartDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(START);
			setState(258);
			procIdentifier();
			setState(259);
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
		public ProcIdentifierContext procIdentifier() {
			return getRuleContext(ProcIdentifierContext.class,0);
		}
		public TerminalNode WHEN() { return getToken(fannieParserParser.WHEN, 0); }
		public TerminalNode DESCRIPTION_STRING() { return getToken(fannieParserParser.DESCRIPTION_STRING, 0); }
		public TerminalNode TRANSFORM() { return getToken(fannieParserParser.TRANSFORM, 0); }
		public StepOutContext stepOut() {
			return getRuleContext(StepOutContext.class,0);
		}
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
		enterRule(_localctx, 60, RULE_continousDoStepStopDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(STOP);
			setState(262);
			procIdentifier();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(263);
				match(WHEN);
				setState(264);
				match(DESCRIPTION_STRING);
				}
			}

			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRANSFORM) {
				{
				setState(267);
				match(TRANSFORM);
				setState(268);
				stepOut();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u0112\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\7\2C\n\2\f\2\16\2F\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\ro\n\r\3\16\3\16"+
		"\5\16s\n\16\3\17\3\17\3\17\3\17\3\17\7\17z\n\17\f\17\16\17}\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\5\20\u0085\n\20\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\6\22\u008e\n\22\r\22\16\22\u008f\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u009e\n\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00a4\n\25\3\26\3\26\3\26\3\26\3\26\7\26\u00ab\n\26\f\26\16\26\u00ae"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u00b7\n\27\f\27\16\27\u00ba"+
		"\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00c6\n"+
		"\31\f\31\16\31\u00c9\13\31\3\31\3\31\5\31\u00cd\n\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00df"+
		"\n\32\3\33\3\33\3\33\3\33\5\33\u00e5\n\33\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u00ec\n\34\3\35\3\35\3\35\3\35\5\35\u00f2\n\35\3\35\3\35\3\35\5\35\u00f7"+
		"\n\35\3\36\3\36\3\36\3\36\7\36\u00fd\n\36\f\36\16\36\u0100\13\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \5 \u010c\n \3 \3 \5 \u0110\n \3"+
		" \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">\2\5\4\2\21\22\36\36\4\2\34\34\36\36\3\2\35\36\2\u010c\2@\3\2\2\2\4I"+
		"\3\2\2\2\6K\3\2\2\2\bM\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16S\3\2\2\2\20U\3"+
		"\2\2\2\22W\3\2\2\2\24^\3\2\2\2\26d\3\2\2\2\30n\3\2\2\2\32r\3\2\2\2\34"+
		"t\3\2\2\2\36\u0084\3\2\2\2 \u0086\3\2\2\2\"\u008a\3\2\2\2$\u0091\3\2\2"+
		"\2&\u0094\3\2\2\2(\u00a3\3\2\2\2*\u00a5\3\2\2\2,\u00b1\3\2\2\2.\u00bd"+
		"\3\2\2\2\60\u00cc\3\2\2\2\62\u00de\3\2\2\2\64\u00e4\3\2\2\2\66\u00eb\3"+
		"\2\2\28\u00ed\3\2\2\2:\u00f8\3\2\2\2<\u0103\3\2\2\2>\u0107\3\2\2\2@D\5"+
		"\22\n\2AC\5\24\13\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2"+
		"FD\3\2\2\2GH\7\2\2\3H\3\3\2\2\2IJ\7\36\2\2J\5\3\2\2\2KL\t\2\2\2L\7\3\2"+
		"\2\2MN\t\3\2\2N\t\3\2\2\2OP\t\4\2\2P\13\3\2\2\2QR\7\36\2\2R\r\3\2\2\2"+
		"ST\7\36\2\2T\17\3\2\2\2UV\7\36\2\2V\21\3\2\2\2WX\7\f\2\2XY\7\r\2\2YZ\5"+
		"\16\b\2Z[\7\3\2\2[\\\5\26\f\2\\]\7\4\2\2]\23\3\2\2\2^_\7\r\2\2_`\5\16"+
		"\b\2`a\7\3\2\2ab\5\26\f\2bc\7\4\2\2c\25\3\2\2\2de\5\34\17\2ef\7\5\2\2"+
		"fg\5*\26\2gh\7\5\2\2hi\5,\27\2i\27\3\2\2\2jo\5\f\7\2ko\5:\36\2lm\7\32"+
		"\2\2mo\5\4\3\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2o\31\3\2\2\2ps\5\f\7\2qs\5"+
		":\36\2rp\3\2\2\2rq\3\2\2\2s\33\3\2\2\2tu\7\17\2\2uv\7\3\2\2v{\5\36\20"+
		"\2wx\7\5\2\2xz\5\36\20\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2"+
		"\2\2}{\3\2\2\2~\177\7\4\2\2\177\35\3\2\2\2\u0080\u0085\5 \21\2\u0081\u0085"+
		"\5\"\22\2\u0082\u0085\5$\23\2\u0083\u0085\5&\24\2\u0084\u0080\3\2\2\2"+
		"\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\37"+
		"\3\2\2\2\u0086\u0087\5\n\6\2\u0087\u0088\5\f\7\2\u0088\u0089\5(\25\2\u0089"+
		"!\3\2\2\2\u008a\u008d\5 \21\2\u008b\u008c\7\24\2\2\u008c\u008e\5 \21\2"+
		"\u008d\u008b\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090#\3\2\2\2\u0091\u0092\7\r\2\2\u0092\u0093\5\16\b\2\u0093"+
		"%\3\2\2\2\u0094\u0095\5\n\6\2\u0095\u0096\5\n\6\2\u0096\'\3\2\2\2\u0097"+
		"\u0098\7\6\2\2\u0098\u0099\7\37\2\2\u0099\u009d\7 \2\2\u009a\u009b\7\5"+
		"\2\2\u009b\u009c\7\37\2\2\u009c\u009e\7!\2\2\u009d\u009a\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a4\7\7\2\2\u00a0\u00a1\7\6"+
		"\2\2\u00a1\u00a2\7\"\2\2\u00a2\u00a4\7\7\2\2\u00a3\u0097\3\2\2\2\u00a3"+
		"\u00a0\3\2\2\2\u00a4)\3\2\2\2\u00a5\u00a6\7\16\2\2\u00a6\u00a7\7\3\2\2"+
		"\u00a7\u00ac\5.\30\2\u00a8\u00a9\7\5\2\2\u00a9\u00ab\5.\30\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\4\2\2\u00b0+\3\2\2\2"+
		"\u00b1\u00b2\7\20\2\2\u00b2\u00b3\7\3\2\2\u00b3\u00b8\5\64\33\2\u00b4"+
		"\u00b5\7\5\2\2\u00b5\u00b7\5\64\33\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3"+
		"\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00bb\u00bc\7\4\2\2\u00bc-\3\2\2\2\u00bd\u00be\5\b\5\2"+
		"\u00be\u00bf\5\4\3\2\u00bf\u00c0\5\60\31\2\u00c0/\3\2\2\2\u00c1\u00c2"+
		"\7\b\2\2\u00c2\u00c7\5\62\32\2\u00c3\u00c4\7\5\2\2\u00c4\u00c6\5\62\32"+
		"\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\t\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00c1\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\61\3\2\2"+
		"\2\u00ce\u00cf\7\21\2\2\u00cf\u00d0\7\n\2\2\u00d0\u00df\5\f\7\2\u00d1"+
		"\u00d2\5\6\4\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\5\n\6\2\u00d4\u00d5\7\33"+
		"\2\2\u00d5\u00d6\5\n\6\2\u00d6\u00df\3\2\2\2\u00d7\u00d8\5\6\4\2\u00d8"+
		"\u00d9\7\n\2\2\u00d9\u00da\7\32\2\2\u00da\u00db\5\4\3\2\u00db\u00dc\7"+
		"\33\2\2\u00dc\u00dd\5\n\6\2\u00dd\u00df\3\2\2\2\u00de\u00ce\3\2\2\2\u00de"+
		"\u00d1\3\2\2\2\u00de\u00d7\3\2\2\2\u00df\63\3\2\2\2\u00e0\u00e5\58\35"+
		"\2\u00e1\u00e5\5<\37\2\u00e2\u00e5\5> \2\u00e3\u00e5\5\66\34\2\u00e4\u00e0"+
		"\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\65\3\2\2\2\u00e6\u00e7\7\31\2\2\u00e7\u00ec\5\16\b\2\u00e8\u00e9\7\31"+
		"\2\2\u00e9\u00ea\7\32\2\2\u00ea\u00ec\5\4\3\2\u00eb\u00e6\3\2\2\2\u00eb"+
		"\u00e8\3\2\2\2\u00ec\67\3\2\2\2\u00ed\u00ee\5\4\3\2\u00ee\u00ef\7\23\2"+
		"\2\u00ef\u00f1\5\6\4\2\u00f0\u00f2\7\25\2\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\5\30\r\2\u00f4\u00f5\7"+
		"\33\2\2\u00f5\u00f7\5\32\16\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f79\3\2\2\2\u00f8\u00f9\7\3\2\2\u00f9\u00fe\5\f\7\2\u00fa\u00fb\7"+
		"\5\2\2\u00fb\u00fd\5\f\7\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0101\u0102\7\4\2\2\u0102;\3\2\2\2\u0103\u0104\7\26\2\2\u0104\u0105"+
		"\5\20\t\2\u0105\u0106\58\35\2\u0106=\3\2\2\2\u0107\u0108\7\27\2\2\u0108"+
		"\u010b\5\20\t\2\u0109\u010a\7\30\2\2\u010a\u010c\7\25\2\2\u010b\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010e\7\33\2\2"+
		"\u010e\u0110\5\32\16\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110?"+
		"\3\2\2\2\26Dnr{\u0084\u008f\u009d\u00a3\u00ac\u00b8\u00c7\u00cc\u00de"+
		"\u00e4\u00eb\u00f1\u00f6\u00fe\u010b\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}