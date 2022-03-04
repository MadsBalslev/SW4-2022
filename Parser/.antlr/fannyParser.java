// Generated from c:\Users\caspe\Documents\GitHub\SW4-2022\Parser\fanny.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fannyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		DESCRIPTION=10, MAIN=11, RECIPE=12, TOOLS=13, TOOL_TYPE=14, SERVE=15, 
		INGREDIENTS=16, MEASUREMENT=17, WEIGHT_UNIT=18, AMOUNT=19, STEPS=20, ID=21, 
		INGREDIENT_TYPE=22;
	public static final int
		RULE_program = 0, RULE_main_recipe = 1, RULE_recipe = 2, RULE_recipe_body = 3, 
		RULE_tool_list = 4, RULE_ingredient_list = 5, RULE_steps_list = 6, RULE_serve_step = 7, 
		RULE_ingredient = 8, RULE_tool = 9, RULE_tool_action = 10, RULE_steps = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "main_recipe", "recipe", "recipe_body", "tool_list", "ingredient_list", 
			"steps_list", "serve_step", "ingredient", "tool", "tool_action", "steps"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "','", "')'", "'['", "']'", "':'", "'do'", 
			null, "'main'", "'recipe'", "'tools'", "'tool'", "'serve'", "'ingredients'", 
			null, null, null, "'steps'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "DESCRIPTION", 
			"MAIN", "RECIPE", "TOOLS", "TOOL_TYPE", "SERVE", "INGREDIENTS", "MEASUREMENT", 
			"WEIGHT_UNIT", "AMOUNT", "STEPS", "ID", "INGREDIENT_TYPE"
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
	public String getGrammarFileName() { return "fanny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public fannyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Main_recipeContext main_recipe() {
			return getRuleContext(Main_recipeContext.class,0);
		}
		public List<RecipeContext> recipe() {
			return getRuleContexts(RecipeContext.class);
		}
		public RecipeContext recipe(int i) {
			return getRuleContext(RecipeContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			main_recipe();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RECIPE) {
				{
				{
				setState(25);
				recipe();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Main_recipeContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(fannyParser.MAIN, 0); }
		public RecipeContext recipe() {
			return getRuleContext(RecipeContext.class,0);
		}
		public Main_recipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_recipe; }
	}

	public final Main_recipeContext main_recipe() throws RecognitionException {
		Main_recipeContext _localctx = new Main_recipeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main_recipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(MAIN);
			setState(32);
			recipe();
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

	public static class RecipeContext extends ParserRuleContext {
		public TerminalNode RECIPE() { return getToken(fannyParser.RECIPE, 0); }
		public TerminalNode ID() { return getToken(fannyParser.ID, 0); }
		public Recipe_bodyContext recipe_body() {
			return getRuleContext(Recipe_bodyContext.class,0);
		}
		public RecipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipe; }
	}

	public final RecipeContext recipe() throws RecognitionException {
		RecipeContext _localctx = new RecipeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_recipe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(RECIPE);
			setState(35);
			match(ID);
			setState(36);
			match(T__0);
			setState(37);
			recipe_body();
			setState(38);
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

	public static class Recipe_bodyContext extends ParserRuleContext {
		public Tool_listContext tool_list() {
			return getRuleContext(Tool_listContext.class,0);
		}
		public Ingredient_listContext ingredient_list() {
			return getRuleContext(Ingredient_listContext.class,0);
		}
		public Steps_listContext steps_list() {
			return getRuleContext(Steps_listContext.class,0);
		}
		public Recipe_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recipe_body; }
	}

	public final Recipe_bodyContext recipe_body() throws RecognitionException {
		Recipe_bodyContext _localctx = new Recipe_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_recipe_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			tool_list();
			setState(41);
			ingredient_list();
			setState(42);
			steps_list();
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

	public static class Tool_listContext extends ParserRuleContext {
		public TerminalNode TOOLS() { return getToken(fannyParser.TOOLS, 0); }
		public List<ToolContext> tool() {
			return getRuleContexts(ToolContext.class);
		}
		public ToolContext tool(int i) {
			return getRuleContext(ToolContext.class,i);
		}
		public Tool_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tool_list; }
	}

	public final Tool_listContext tool_list() throws RecognitionException {
		Tool_listContext _localctx = new Tool_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tool_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(TOOLS);
			setState(45);
			match(T__0);
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				tool();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOOL_TYPE );
			setState(51);
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

	public static class Ingredient_listContext extends ParserRuleContext {
		public TerminalNode INGREDIENTS() { return getToken(fannyParser.INGREDIENTS, 0); }
		public List<IngredientContext> ingredient() {
			return getRuleContexts(IngredientContext.class);
		}
		public IngredientContext ingredient(int i) {
			return getRuleContext(IngredientContext.class,i);
		}
		public Ingredient_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredient_list; }
	}

	public final Ingredient_listContext ingredient_list() throws RecognitionException {
		Ingredient_listContext _localctx = new Ingredient_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ingredient_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(INGREDIENTS);
			setState(54);
			match(T__0);
			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				ingredient();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RECIPE || _la==INGREDIENT_TYPE );
			setState(60);
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

	public static class Steps_listContext extends ParserRuleContext {
		public TerminalNode STEPS() { return getToken(fannyParser.STEPS, 0); }
		public Serve_stepContext serve_step() {
			return getRuleContext(Serve_stepContext.class,0);
		}
		public List<StepsContext> steps() {
			return getRuleContexts(StepsContext.class);
		}
		public StepsContext steps(int i) {
			return getRuleContext(StepsContext.class,i);
		}
		public Steps_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_steps_list; }
	}

	public final Steps_listContext steps_list() throws RecognitionException {
		Steps_listContext _localctx = new Steps_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_steps_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(STEPS);
			setState(63);
			match(T__0);
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				steps();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(69);
			serve_step();
			setState(70);
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

	public static class Serve_stepContext extends ParserRuleContext {
		public TerminalNode SERVE() { return getToken(fannyParser.SERVE, 0); }
		public TerminalNode ID() { return getToken(fannyParser.ID, 0); }
		public Serve_stepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serve_step; }
	}

	public final Serve_stepContext serve_step() throws RecognitionException {
		Serve_stepContext _localctx = new Serve_stepContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_serve_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(SERVE);
			setState(73);
			match(ID);
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

	public static class IngredientContext extends ParserRuleContext {
		public TerminalNode INGREDIENT_TYPE() { return getToken(fannyParser.INGREDIENT_TYPE, 0); }
		public TerminalNode ID() { return getToken(fannyParser.ID, 0); }
		public TerminalNode MEASUREMENT() { return getToken(fannyParser.MEASUREMENT, 0); }
		public TerminalNode AMOUNT() { return getToken(fannyParser.AMOUNT, 0); }
		public TerminalNode RECIPE() { return getToken(fannyParser.RECIPE, 0); }
		public IngredientContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ingredient; }
	}

	public final IngredientContext ingredient() throws RecognitionException {
		IngredientContext _localctx = new IngredientContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ingredient);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INGREDIENT_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(INGREDIENT_TYPE);
				setState(76);
				match(ID);
				setState(77);
				match(T__2);
				setState(78);
				match(MEASUREMENT);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(79);
					match(T__3);
					setState(80);
					match(AMOUNT);
					}
				}

				setState(83);
				match(T__4);
				}
				break;
			case RECIPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(RECIPE);
				setState(85);
				match(ID);
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

	public static class ToolContext extends ParserRuleContext {
		public TerminalNode TOOL_TYPE() { return getToken(fannyParser.TOOL_TYPE, 0); }
		public TerminalNode ID() { return getToken(fannyParser.ID, 0); }
		public List<Tool_actionContext> tool_action() {
			return getRuleContexts(Tool_actionContext.class);
		}
		public Tool_actionContext tool_action(int i) {
			return getRuleContext(Tool_actionContext.class,i);
		}
		public ToolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tool; }
	}

	public final ToolContext tool() throws RecognitionException {
		ToolContext _localctx = new ToolContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TOOL_TYPE);
			setState(89);
			match(ID);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(90);
				match(T__5);
				setState(91);
				tool_action();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(92);
					match(T__3);
					setState(93);
					tool_action();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
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

	public static class Tool_actionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(fannyParser.ID, 0); }
		public TerminalNode INGREDIENT_TYPE() { return getToken(fannyParser.INGREDIENT_TYPE, 0); }
		public Tool_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tool_action; }
	}

	public final Tool_actionContext tool_action() throws RecognitionException {
		Tool_actionContext _localctx = new Tool_actionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tool_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			setState(104);
			match(T__7);
			setState(105);
			match(INGREDIENT_TYPE);
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

	public static class StepsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(fannyParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(fannyParser.ID, i);
		}
		public Tool_actionContext tool_action() {
			return getRuleContext(Tool_actionContext.class,0);
		}
		public TerminalNode DESCRIPTION() { return getToken(fannyParser.DESCRIPTION, 0); }
		public StepsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_steps; }
	}

	public final StepsContext steps() throws RecognitionException {
		StepsContext _localctx = new StepsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_steps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(ID);
			setState(108);
			match(T__8);
			setState(109);
			tool_action();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION) {
				{
				setState(110);
				match(DESCRIPTION);
				}
			}

			setState(113);
			match(ID);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30v\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6\62\n\6\r\6\16\6\63\3\6"+
		"\3\6\3\7\3\7\3\7\6\7;\n\7\r\7\16\7<\3\7\3\7\3\b\3\b\3\b\6\bD\n\b\r\b\16"+
		"\bE\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nT\n\n\3\n\3\n\3"+
		"\n\5\nY\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13a\n\13\f\13\16\13d\13\13"+
		"\3\13\3\13\5\13h\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\rr\n\r\3\r\3\r"+
		"\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2r\2\32\3\2\2\2\4!\3\2\2"+
		"\2\6$\3\2\2\2\b*\3\2\2\2\n.\3\2\2\2\f\67\3\2\2\2\16@\3\2\2\2\20J\3\2\2"+
		"\2\22X\3\2\2\2\24Z\3\2\2\2\26i\3\2\2\2\30m\3\2\2\2\32\36\5\4\3\2\33\35"+
		"\5\6\4\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3"+
		"\2\2\2 \36\3\2\2\2!\"\7\r\2\2\"#\5\6\4\2#\5\3\2\2\2$%\7\16\2\2%&\7\27"+
		"\2\2&\'\7\3\2\2\'(\5\b\5\2()\7\4\2\2)\7\3\2\2\2*+\5\n\6\2+,\5\f\7\2,-"+
		"\5\16\b\2-\t\3\2\2\2./\7\17\2\2/\61\7\3\2\2\60\62\5\24\13\2\61\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\4"+
		"\2\2\66\13\3\2\2\2\678\7\22\2\28:\7\3\2\29;\5\22\n\2:9\3\2\2\2;<\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\4\2\2?\r\3\2\2\2@A\7\26\2\2AC\7\3"+
		"\2\2BD\5\30\r\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\5"+
		"\20\t\2HI\7\4\2\2I\17\3\2\2\2JK\7\21\2\2KL\7\27\2\2L\21\3\2\2\2MN\7\30"+
		"\2\2NO\7\27\2\2OP\7\5\2\2PS\7\23\2\2QR\7\6\2\2RT\7\25\2\2SQ\3\2\2\2ST"+
		"\3\2\2\2TU\3\2\2\2UY\7\7\2\2VW\7\16\2\2WY\7\27\2\2XM\3\2\2\2XV\3\2\2\2"+
		"Y\23\3\2\2\2Z[\7\20\2\2[g\7\27\2\2\\]\7\b\2\2]b\5\26\f\2^_\7\6\2\2_a\5"+
		"\26\f\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef"+
		"\7\t\2\2fh\3\2\2\2g\\\3\2\2\2gh\3\2\2\2h\25\3\2\2\2ij\7\27\2\2jk\7\n\2"+
		"\2kl\7\30\2\2l\27\3\2\2\2mn\7\27\2\2no\7\13\2\2oq\5\26\f\2pr\7\f\2\2q"+
		"p\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\27\2\2t\31\3\2\2\2\13\36\63<ESXbgq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}