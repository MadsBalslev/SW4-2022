// Generated from c:\Github\SW4-2022\fannie-compiler\src\main\antlr4\fannieParser.g4 by ANTLR 4.8
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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		COMPLEX_IDENTIFIER=10, CONTAIN=11, REMOVE=12, TOOL_BASIC_TYPE_IDENTIFIER=13, 
		INGREDIENT_BASIC_TYPE_IDENTIFIER=14, MAIN=15, RECIPE=16, INGREDIENT_LIST=17, 
		TOOL_LIST=18, STEP_LIST=19, OR=20, AMOUNT=21, WEIGHT_UNIT=22, ABSTRACT_UNIT=23, 
		TO_TASTE=24, SERVE=25, DO=26, DESCRIPTION_STRING=27, START=28, STOP=29, 
		WHEN=30, CONTENT_IN=31;
	public static final int
		RULE_toolIdentifier = 0, RULE_toolActionIdentifier = 1, RULE_toolTypeIdentifier = 2, 
		RULE_ingredientTypeIdentifier = 3, RULE_ingredientIdentifier = 4, RULE_recipeIdentifier = 5, 
		RULE_procIdentifier = 6, RULE_fannie = 7, RULE_mainRecipe = 8, RULE_subRecipe = 9, 
		RULE_recipeBody = 10, RULE_ingredientsList = 11, RULE_toolsList = 12, 
		RULE_stepsList = 13, RULE_ingredientDeclaration = 14, RULE_deterministicIngredientDeclaration = 15, 
		RULE_nondeterministicIngredientDeclaration = 16, RULE_recipeIngredientDeclaration = 17, 
		RULE_ingredientTypeDeclaration = 18, RULE_amountDeclaration = 19, RULE_toolDeclaration = 20, 
		RULE_toolActionDeclarationsList = 21, RULE_toolActionDeclaration = 22, 
		RULE_stepDeclaration = 23, RULE_serveStepDeclaration = 24, RULE_doStepDeclaration = 25, 
		RULE_continousDoStepStartDeclaration = 26, RULE_continousDoStepStopDeclaration = 27, 
		RULE_stepIn = 28, RULE_stepOut = 29, RULE_contentIn = 30, RULE_ingredientCollection = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"toolIdentifier", "toolActionIdentifier", "toolTypeIdentifier", "ingredientTypeIdentifier", 
			"ingredientIdentifier", "recipeIdentifier", "procIdentifier", "fannie", 
			"mainRecipe", "subRecipe", "recipeBody", "ingredientsList", "toolsList", 
			"stepsList", "ingredientDeclaration", "deterministicIngredientDeclaration", 
			"nondeterministicIngredientDeclaration", "recipeIngredientDeclaration", 
			"ingredientTypeDeclaration", "amountDeclaration", "toolDeclaration", 
			"toolActionDeclarationsList", "toolActionDeclaration", "stepDeclaration", 
			"serveStepDeclaration", "doStepDeclaration", "continousDoStepStartDeclaration", 
			"continousDoStepStopDeclaration", "stepIn", "stepOut", "contentIn", "ingredientCollection"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'('", "')'", "'['", "']'", "':'", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "COMPLEX_IDENTIFIER", 
			"CONTAIN", "REMOVE", "TOOL_BASIC_TYPE_IDENTIFIER", "INGREDIENT_BASIC_TYPE_IDENTIFIER", 
			"MAIN", "RECIPE", "INGREDIENT_LIST", "TOOL_LIST", "STEP_LIST", "OR", 
			"AMOUNT", "WEIGHT_UNIT", "ABSTRACT_UNIT", "TO_TASTE", "SERVE", "DO", 
			"DESCRIPTION_STRING", "START", "STOP", "WHEN", "CONTENT_IN"
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

	public static class ToolIdentifierContext extends ParserRuleContext {
		public TerminalNode COMPLEX_IDENTIFIER() { return getToken(fannieParserParser.COMPLEX_IDENTIFIER, 0); }
		public ToolIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolIdentifier; }
	}

	public final ToolIdentifierContext toolIdentifier() throws RecognitionException {
		ToolIdentifierContext _localctx = new ToolIdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_toolIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
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
	}

	public final ToolActionIdentifierContext toolActionIdentifier() throws RecognitionException {
		ToolActionIdentifierContext _localctx = new ToolActionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_toolActionIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPLEX_IDENTIFIER) | (1L << CONTAIN) | (1L << REMOVE))) != 0)) ) {
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
	}

	public final ToolTypeIdentifierContext toolTypeIdentifier() throws RecognitionException {
		ToolTypeIdentifierContext _localctx = new ToolTypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_toolTypeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==COMPLEX_IDENTIFIER || _la==TOOL_BASIC_TYPE_IDENTIFIER) ) {
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
	}

	public final IngredientTypeIdentifierContext ingredientTypeIdentifier() throws RecognitionException {
		IngredientTypeIdentifierContext _localctx = new IngredientTypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ingredientTypeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==COMPLEX_IDENTIFIER || _la==INGREDIENT_BASIC_TYPE_IDENTIFIER) ) {
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
	}

	public final IngredientIdentifierContext ingredientIdentifier() throws RecognitionException {
		IngredientIdentifierContext _localctx = new IngredientIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ingredientIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
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
	}

	public final RecipeIdentifierContext recipeIdentifier() throws RecognitionException {
		RecipeIdentifierContext _localctx = new RecipeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_recipeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
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
	}

	public final ProcIdentifierContext procIdentifier() throws RecognitionException {
		ProcIdentifierContext _localctx = new ProcIdentifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
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

	public static class FannieContext extends ParserRuleContext {
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
		public FannieContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fannie; }
	}

	public final FannieContext fannie() throws RecognitionException {
		FannieContext _localctx = new FannieContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fannie);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			mainRecipe();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RECIPE) {
				{
				{
				setState(79);
				subRecipe();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
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
	}

	public final MainRecipeContext mainRecipe() throws RecognitionException {
		MainRecipeContext _localctx = new MainRecipeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mainRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(MAIN);
			setState(88);
			match(RECIPE);
			setState(89);
			recipeIdentifier();
			setState(90);
			match(T__0);
			setState(91);
			recipeBody();
			setState(92);
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
	}

	public final SubRecipeContext subRecipe() throws RecognitionException {
		SubRecipeContext _localctx = new SubRecipeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subRecipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(RECIPE);
			setState(95);
			recipeIdentifier();
			setState(96);
			match(T__0);
			setState(97);
			recipeBody();
			setState(98);
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
	}

	public final RecipeBodyContext recipeBody() throws RecognitionException {
		RecipeBodyContext _localctx = new RecipeBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_recipeBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			ingredientsList();
			setState(101);
			match(T__2);
			setState(102);
			toolsList();
			setState(103);
			match(T__2);
			setState(104);
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
	}

	public final IngredientsListContext ingredientsList() throws RecognitionException {
		IngredientsListContext _localctx = new IngredientsListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ingredientsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(INGREDIENT_LIST);
			setState(107);
			match(T__0);
			setState(108);
			ingredientDeclaration();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(109);
				match(T__2);
				setState(110);
				ingredientDeclaration();
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
	}

	public final ToolsListContext toolsList() throws RecognitionException {
		ToolsListContext _localctx = new ToolsListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_toolsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(TOOL_LIST);
			setState(119);
			match(T__0);
			setState(120);
			toolDeclaration();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(121);
				match(T__2);
				setState(122);
				toolDeclaration();
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
	}

	public final StepsListContext stepsList() throws RecognitionException {
		StepsListContext _localctx = new StepsListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stepsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(STEP_LIST);
			setState(131);
			match(T__0);
			setState(132);
			stepDeclaration();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(133);
				match(T__2);
				setState(134);
				stepDeclaration();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
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
		public IngredientTypeDeclarationContext ingredientTypeDeclaration() {
			return getRuleContext(IngredientTypeDeclarationContext.class,0);
		}
		public IngredientDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientDeclaration; }
	}

	public final IngredientDeclarationContext ingredientDeclaration() throws RecognitionException {
		IngredientDeclarationContext _localctx = new IngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ingredientDeclaration);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				deterministicIngredientDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				nondeterministicIngredientDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				recipeIngredientDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				ingredientTypeDeclaration();
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
	}

	public final DeterministicIngredientDeclarationContext deterministicIngredientDeclaration() throws RecognitionException {
		DeterministicIngredientDeclarationContext _localctx = new DeterministicIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deterministicIngredientDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			ingredientTypeIdentifier();
			setState(149);
			ingredientIdentifier();
			setState(150);
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
	}

	public final NondeterministicIngredientDeclarationContext nondeterministicIngredientDeclaration() throws RecognitionException {
		NondeterministicIngredientDeclarationContext _localctx = new NondeterministicIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nondeterministicIngredientDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			deterministicIngredientDeclaration();
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				match(OR);
				setState(154);
				deterministicIngredientDeclaration();
				}
				}
				setState(157); 
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
	}

	public final RecipeIngredientDeclarationContext recipeIngredientDeclaration() throws RecognitionException {
		RecipeIngredientDeclarationContext _localctx = new RecipeIngredientDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_recipeIngredientDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(RECIPE);
			setState(160);
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

	public static class IngredientTypeDeclarationContext extends ParserRuleContext {
		public List<IngredientTypeIdentifierContext> ingredientTypeIdentifier() {
			return getRuleContexts(IngredientTypeIdentifierContext.class);
		}
		public IngredientTypeIdentifierContext ingredientTypeIdentifier(int i) {
			return getRuleContext(IngredientTypeIdentifierContext.class,i);
		}
		public IngredientTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientTypeDeclaration; }
	}

	public final IngredientTypeDeclarationContext ingredientTypeDeclaration() throws RecognitionException {
		IngredientTypeDeclarationContext _localctx = new IngredientTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ingredientTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			ingredientTypeIdentifier();
			setState(163);
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
	}

	public final AmountDeclarationContext amountDeclaration() throws RecognitionException {
		AmountDeclarationContext _localctx = new AmountDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_amountDeclaration);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(T__3);
				setState(166);
				match(AMOUNT);
				setState(167);
				match(WEIGHT_UNIT);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(168);
					match(T__2);
					setState(169);
					match(AMOUNT);
					setState(170);
					match(ABSTRACT_UNIT);
					}
				}

				setState(173);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(T__3);
				setState(175);
				match(TO_TASTE);
				setState(176);
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
	}

	public final ToolDeclarationContext toolDeclaration() throws RecognitionException {
		ToolDeclarationContext _localctx = new ToolDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_toolDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			toolTypeIdentifier();
			setState(180);
			toolIdentifier();
			setState(181);
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
	}

	public final ToolActionDeclarationsListContext toolActionDeclarationsList() throws RecognitionException {
		ToolActionDeclarationsListContext _localctx = new ToolActionDeclarationsListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_toolActionDeclarationsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(183);
				match(T__5);
				setState(184);
				toolActionDeclaration();
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(185);
					match(T__2);
					setState(186);
					toolActionDeclaration();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
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
		public List<IngredientTypeIdentifierContext> ingredientTypeIdentifier() {
			return getRuleContexts(IngredientTypeIdentifierContext.class);
		}
		public IngredientTypeIdentifierContext ingredientTypeIdentifier(int i) {
			return getRuleContext(IngredientTypeIdentifierContext.class,i);
		}
		public ToolActionIdentifierContext toolActionIdentifier() {
			return getRuleContext(ToolActionIdentifierContext.class,0);
		}
		public ContentInContext contentIn() {
			return getRuleContext(ContentInContext.class,0);
		}
		public ToolActionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_toolActionDeclaration; }
	}

	public final ToolActionDeclarationContext toolActionDeclaration() throws RecognitionException {
		ToolActionDeclarationContext _localctx = new ToolActionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_toolActionDeclaration);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(CONTAIN);
				setState(197);
				match(T__7);
				setState(198);
				ingredientTypeIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				toolActionIdentifier();
				setState(200);
				match(T__7);
				setState(201);
				ingredientTypeIdentifier();
				setState(202);
				match(T__8);
				setState(203);
				ingredientTypeIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				toolActionIdentifier();
				setState(206);
				match(T__7);
				setState(207);
				contentIn();
				setState(208);
				match(T__8);
				setState(209);
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
	}

	public final StepDeclarationContext stepDeclaration() throws RecognitionException {
		StepDeclarationContext _localctx = new StepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stepDeclaration);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				doStepDeclaration();
				}
				break;
			case START:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				continousDoStepStartDeclaration();
				}
				break;
			case STOP:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				continousDoStepStopDeclaration();
				}
				break;
			case SERVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
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
		public StepInContext stepIn() {
			return getRuleContext(StepInContext.class,0);
		}
		public ServeStepDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serveStepDeclaration; }
	}

	public final ServeStepDeclarationContext serveStepDeclaration() throws RecognitionException {
		ServeStepDeclarationContext _localctx = new ServeStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_serveStepDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(SERVE);
			setState(220);
			stepIn();
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
		public StepOutContext stepOut() {
			return getRuleContext(StepOutContext.class,0);
		}
		public DoStepDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStepDeclaration; }
	}

	public final DoStepDeclarationContext doStepDeclaration() throws RecognitionException {
		DoStepDeclarationContext _localctx = new DoStepDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_doStepDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			toolIdentifier();
			setState(223);
			match(DO);
			setState(224);
			toolActionIdentifier();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION_STRING) {
				{
				setState(225);
				match(DESCRIPTION_STRING);
				}
			}

			setState(228);
			stepIn();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(229);
				match(T__8);
				setState(230);
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

	public static class ContinousDoStepStartDeclarationContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(fannieParserParser.START, 0); }
		public ProcIdentifierContext procIdentifier() {
			return getRuleContext(ProcIdentifierContext.class,0);
		}
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
		public ContinousDoStepStartDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continousDoStepStartDeclaration; }
	}

	public final ContinousDoStepStartDeclarationContext continousDoStepStartDeclaration() throws RecognitionException {
		ContinousDoStepStartDeclarationContext _localctx = new ContinousDoStepStartDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_continousDoStepStartDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(START);
			setState(234);
			procIdentifier();
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
		public StepOutContext stepOut() {
			return getRuleContext(StepOutContext.class,0);
		}
		public ContinousDoStepStopDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continousDoStepStopDeclaration; }
	}

	public final ContinousDoStepStopDeclarationContext continousDoStepStopDeclaration() throws RecognitionException {
		ContinousDoStepStopDeclarationContext _localctx = new ContinousDoStepStopDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_continousDoStepStopDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(STOP);
			setState(244);
			procIdentifier();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(245);
				match(WHEN);
				setState(246);
				match(DESCRIPTION_STRING);
				}
			}

			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(249);
				match(T__8);
				setState(250);
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

	public static class StepInContext extends ParserRuleContext {
		public IngredientIdentifierContext ingredientIdentifier() {
			return getRuleContext(IngredientIdentifierContext.class,0);
		}
		public IngredientCollectionContext ingredientCollection() {
			return getRuleContext(IngredientCollectionContext.class,0);
		}
		public ContentInContext contentIn() {
			return getRuleContext(ContentInContext.class,0);
		}
		public StepInContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepIn; }
	}

	public final StepInContext stepIn() throws RecognitionException {
		StepInContext _localctx = new StepInContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stepIn);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				ingredientIdentifier();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				ingredientCollection();
				}
				break;
			case CONTENT_IN:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				contentIn();
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
		public IngredientCollectionContext ingredientCollection() {
			return getRuleContext(IngredientCollectionContext.class,0);
		}
		public StepOutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepOut; }
	}

	public final StepOutContext stepOut() throws RecognitionException {
		StepOutContext _localctx = new StepOutContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_stepOut);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEX_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				ingredientIdentifier();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				ingredientCollection();
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

	public static class ContentInContext extends ParserRuleContext {
		public TerminalNode CONTENT_IN() { return getToken(fannieParserParser.CONTENT_IN, 0); }
		public ToolIdentifierContext toolIdentifier() {
			return getRuleContext(ToolIdentifierContext.class,0);
		}
		public ContentInContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentIn; }
	}

	public final ContentInContext contentIn() throws RecognitionException {
		ContentInContext _localctx = new ContentInContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_contentIn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(CONTENT_IN);
			setState(263);
			toolIdentifier();
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

	public static class IngredientCollectionContext extends ParserRuleContext {
		public List<IngredientIdentifierContext> ingredientIdentifier() {
			return getRuleContexts(IngredientIdentifierContext.class);
		}
		public IngredientIdentifierContext ingredientIdentifier(int i) {
			return getRuleContext(IngredientIdentifierContext.class,i);
		}
		public IngredientCollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredientCollection; }
	}

	public final IngredientCollectionContext ingredientCollection() throws RecognitionException {
		IngredientCollectionContext _localctx = new IngredientCollectionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ingredientCollection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__0);
			setState(266);
			ingredientIdentifier();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(267);
				match(T__2);
				setState(268);
				ingredientIdentifier();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\7"+
		"\tS\n\t\f\t\16\tV\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\rr\n"+
		"\r\f\r\16\ru\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16~\n\16\f\16\16"+
		"\16\u0081\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u008a\n\17\f\17"+
		"\16\17\u008d\13\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0095\n\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\6\22\u009e\n\22\r\22\16\22\u009f\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ae\n\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00b4\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\7\27\u00be\n\27\f\27\16\27\u00c1\13\27\3\27\3\27\5\27\u00c5\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u00d6\n\30\3\31\3\31\3\31\3\31\5\31\u00dc\n\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\5\33\u00e5\n\33\3\33\3\33\3\33\5\33\u00ea\n\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f2\n\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\5\35\u00fa\n\35\3\35\3\35\5\35\u00fe\n\35\3\36\3\36\3\36\5\36\u0103"+
		"\n\36\3\37\3\37\5\37\u0107\n\37\3 \3 \3 \3!\3!\3!\3!\7!\u0110\n!\f!\16"+
		"!\u0113\13!\3!\3!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@\2\5\3\2\f\16\4\2\f\f\17\17\4\2\f\f\20\20\2\u0110"+
		"\2B\3\2\2\2\4D\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nJ\3\2\2\2\fL\3\2\2\2\16"+
		"N\3\2\2\2\20P\3\2\2\2\22Y\3\2\2\2\24`\3\2\2\2\26f\3\2\2\2\30l\3\2\2\2"+
		"\32x\3\2\2\2\34\u0084\3\2\2\2\36\u0094\3\2\2\2 \u0096\3\2\2\2\"\u009a"+
		"\3\2\2\2$\u00a1\3\2\2\2&\u00a4\3\2\2\2(\u00b3\3\2\2\2*\u00b5\3\2\2\2,"+
		"\u00c4\3\2\2\2.\u00d5\3\2\2\2\60\u00db\3\2\2\2\62\u00dd\3\2\2\2\64\u00e0"+
		"\3\2\2\2\66\u00eb\3\2\2\28\u00f5\3\2\2\2:\u0102\3\2\2\2<\u0106\3\2\2\2"+
		">\u0108\3\2\2\2@\u010b\3\2\2\2BC\7\f\2\2C\3\3\2\2\2DE\t\2\2\2E\5\3\2\2"+
		"\2FG\t\3\2\2G\7\3\2\2\2HI\t\4\2\2I\t\3\2\2\2JK\7\f\2\2K\13\3\2\2\2LM\7"+
		"\f\2\2M\r\3\2\2\2NO\7\f\2\2O\17\3\2\2\2PT\5\22\n\2QS\5\24\13\2RQ\3\2\2"+
		"\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\2\2\3X\21\3\2"+
		"\2\2YZ\7\21\2\2Z[\7\22\2\2[\\\5\f\7\2\\]\7\3\2\2]^\5\26\f\2^_\7\4\2\2"+
		"_\23\3\2\2\2`a\7\22\2\2ab\5\f\7\2bc\7\3\2\2cd\5\26\f\2de\7\4\2\2e\25\3"+
		"\2\2\2fg\5\30\r\2gh\7\5\2\2hi\5\32\16\2ij\7\5\2\2jk\5\34\17\2k\27\3\2"+
		"\2\2lm\7\23\2\2mn\7\3\2\2ns\5\36\20\2op\7\5\2\2pr\5\36\20\2qo\3\2\2\2"+
		"ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\4\2\2w\31\3\2\2"+
		"\2xy\7\24\2\2yz\7\3\2\2z\177\5*\26\2{|\7\5\2\2|~\5*\26\2}{\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\u0083\7\4\2\2\u0083\33\3\2\2\2\u0084\u0085\7\25\2\2\u0085"+
		"\u0086\7\3\2\2\u0086\u008b\5\60\31\2\u0087\u0088\7\5\2\2\u0088\u008a\5"+
		"\60\31\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7\4"+
		"\2\2\u008f\35\3\2\2\2\u0090\u0095\5 \21\2\u0091\u0095\5\"\22\2\u0092\u0095"+
		"\5$\23\2\u0093\u0095\5&\24\2\u0094\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\37\3\2\2\2\u0096\u0097\5\b\5"+
		"\2\u0097\u0098\5\n\6\2\u0098\u0099\5(\25\2\u0099!\3\2\2\2\u009a\u009d"+
		"\5 \21\2\u009b\u009c\7\26\2\2\u009c\u009e\5 \21\2\u009d\u009b\3\2\2\2"+
		"\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0#\3"+
		"\2\2\2\u00a1\u00a2\7\22\2\2\u00a2\u00a3\5\f\7\2\u00a3%\3\2\2\2\u00a4\u00a5"+
		"\5\b\5\2\u00a5\u00a6\5\b\5\2\u00a6\'\3\2\2\2\u00a7\u00a8\7\6\2\2\u00a8"+
		"\u00a9\7\27\2\2\u00a9\u00ad\7\30\2\2\u00aa\u00ab\7\5\2\2\u00ab\u00ac\7"+
		"\27\2\2\u00ac\u00ae\7\31\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b4\7\7\2\2\u00b0\u00b1\7\6\2\2\u00b1\u00b2\7\32"+
		"\2\2\u00b2\u00b4\7\7\2\2\u00b3\u00a7\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b4"+
		")\3\2\2\2\u00b5\u00b6\5\6\4\2\u00b6\u00b7\5\2\2\2\u00b7\u00b8\5,\27\2"+
		"\u00b8+\3\2\2\2\u00b9\u00ba\7\b\2\2\u00ba\u00bf\5.\30\2\u00bb\u00bc\7"+
		"\5\2\2\u00bc\u00be\5.\30\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c3\7\t\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00b9\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5-\3\2\2\2\u00c6\u00c7\7\r\2\2\u00c7\u00c8\7\n\2\2"+
		"\u00c8\u00d6\5\b\5\2\u00c9\u00ca\5\4\3\2\u00ca\u00cb\7\n\2\2\u00cb\u00cc"+
		"\5\b\5\2\u00cc\u00cd\7\13\2\2\u00cd\u00ce\5\b\5\2\u00ce\u00d6\3\2\2\2"+
		"\u00cf\u00d0\5\4\3\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\5> \2\u00d2\u00d3"+
		"\7\13\2\2\u00d3\u00d4\5\b\5\2\u00d4\u00d6\3\2\2\2\u00d5\u00c6\3\2\2\2"+
		"\u00d5\u00c9\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d6/\3\2\2\2\u00d7\u00dc\5"+
		"\64\33\2\u00d8\u00dc\5\66\34\2\u00d9\u00dc\58\35\2\u00da\u00dc\5\62\32"+
		"\2\u00db\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00da"+
		"\3\2\2\2\u00dc\61\3\2\2\2\u00dd\u00de\7\33\2\2\u00de\u00df\5:\36\2\u00df"+
		"\63\3\2\2\2\u00e0\u00e1\5\2\2\2\u00e1\u00e2\7\34\2\2\u00e2\u00e4\5\4\3"+
		"\2\u00e3\u00e5\7\35\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e9\5:\36\2\u00e7\u00e8\7\13\2\2\u00e8\u00ea\5"+
		"<\37\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\65\3\2\2\2\u00eb"+
		"\u00ec\7\36\2\2\u00ec\u00ed\5\16\b\2\u00ed\u00ee\5\2\2\2\u00ee\u00ef\7"+
		"\34\2\2\u00ef\u00f1\5\4\3\2\u00f0\u00f2\7\35\2\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\5:\36\2\u00f4\67\3\2\2"+
		"\2\u00f5\u00f6\7\37\2\2\u00f6\u00f9\5\16\b\2\u00f7\u00f8\7 \2\2\u00f8"+
		"\u00fa\7\35\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd\3"+
		"\2\2\2\u00fb\u00fc\7\13\2\2\u00fc\u00fe\5<\37\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe9\3\2\2\2\u00ff\u0103\5\n\6\2\u0100\u0103\5@!\2\u0101"+
		"\u0103\5> \2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2"+
		"\2\u0103;\3\2\2\2\u0104\u0107\5\n\6\2\u0105\u0107\5@!\2\u0106\u0104\3"+
		"\2\2\2\u0106\u0105\3\2\2\2\u0107=\3\2\2\2\u0108\u0109\7!\2\2\u0109\u010a"+
		"\5\2\2\2\u010a?\3\2\2\2\u010b\u010c\7\3\2\2\u010c\u0111\5\n\6\2\u010d"+
		"\u010e\7\5\2\2\u010e\u0110\5\n\6\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0115\7\4\2\2\u0115A\3\2\2\2\26Ts\177\u008b\u0094"+
		"\u009f\u00ad\u00b3\u00bf\u00c4\u00d5\u00db\u00e4\u00e9\u00f1\u00f9\u00fd"+
		"\u0102\u0106\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}