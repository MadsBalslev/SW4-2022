// Generated from c:\Users\caspe\Documents\GitHub\SW4-2022\Parser\fanny.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fannyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		DESCRIPTION=10, MAIN=11, RECIPE=12, TOOLS=13, TOOL_TYPE=14, SERVE=15, 
		INGREDIENTS=16, MEASUREMENT=17, WEIGHT_UNIT=18, AMOUNT=19, STEPS=20, ID=21, 
		INGREDIENT_TYPE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"DESCRIPTION", "MAIN", "RECIPE", "TOOLS", "TOOL_TYPE", "SERVE", "INGREDIENTS", 
			"MEASUREMENT", "WEIGHT_UNIT", "AMOUNT", "STEPS", "ID", "INGREDIENT_TYPE"
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


	public fannyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "fanny.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\6\22t\n\22\r\22\16\22u\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0088\n\23\3\24"+
		"\6\24\u008b\n\24\r\24\16\24\u008c\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\6\26\u0097\n\26\r\26\16\26\u0098\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00b7\n\27\2\2\30\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30\3\2\6\4\2*+``\3\2\62;\3\2C\\\4\2\62;c|\2\u00c4\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2"+
		"\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3"+
		"\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25B\3\2\2\2\27I\3\2\2\2\31N\3\2\2\2\33"+
		"U\3\2\2\2\35[\3\2\2\2\37`\3\2\2\2!f\3\2\2\2#s\3\2\2\2%\u0087\3\2\2\2\'"+
		"\u008a\3\2\2\2)\u008e\3\2\2\2+\u0094\3\2\2\2-\u00b6\3\2\2\2/\60\7}\2\2"+
		"\60\4\3\2\2\2\61\62\7\177\2\2\62\6\3\2\2\2\63\64\7*\2\2\64\b\3\2\2\2\65"+
		"\66\7.\2\2\66\n\3\2\2\2\678\7+\2\28\f\3\2\2\29:\7]\2\2:\16\3\2\2\2;<\7"+
		"_\2\2<\20\3\2\2\2=>\7<\2\2>\22\3\2\2\2?@\7f\2\2@A\7q\2\2A\24\3\2\2\2B"+
		"C\7]\2\2CD\7$\2\2DE\3\2\2\2EF\t\2\2\2FG\7$\2\2GH\7_\2\2H\26\3\2\2\2IJ"+
		"\7o\2\2JK\7c\2\2KL\7k\2\2LM\7p\2\2M\30\3\2\2\2NO\7t\2\2OP\7g\2\2PQ\7e"+
		"\2\2QR\7k\2\2RS\7r\2\2ST\7g\2\2T\32\3\2\2\2UV\7v\2\2VW\7q\2\2WX\7q\2\2"+
		"XY\7n\2\2YZ\7u\2\2Z\34\3\2\2\2[\\\7v\2\2\\]\7q\2\2]^\7q\2\2^_\7n\2\2_"+
		"\36\3\2\2\2`a\7u\2\2ab\7g\2\2bc\7t\2\2cd\7x\2\2de\7g\2\2e \3\2\2\2fg\7"+
		"k\2\2gh\7p\2\2hi\7i\2\2ij\7t\2\2jk\7g\2\2kl\7f\2\2lm\7k\2\2mn\7g\2\2n"+
		"o\7p\2\2op\7v\2\2pq\7u\2\2q\"\3\2\2\2rt\t\3\2\2sr\3\2\2\2tu\3\2\2\2us"+
		"\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5%\23\2x$\3\2\2\2y\u0088\7i\2\2z{\7m\2"+
		"\2{\u0088\7i\2\2|}\7o\2\2}\u0088\7n\2\2~\177\7f\2\2\177\u0088\7n\2\2\u0080"+
		"\u0088\7n\2\2\u0081\u0082\7o\2\2\u0082\u0088\7i\2\2\u0083\u0084\7n\2\2"+
		"\u0084\u0088\7d\2\2\u0085\u0086\7q\2\2\u0086\u0088\7|\2\2\u0087y\3\2\2"+
		"\2\u0087z\3\2\2\2\u0087|\3\2\2\2\u0087~\3\2\2\2\u0087\u0080\3\2\2\2\u0087"+
		"\u0081\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0085\3\2\2\2\u0088&\3\2\2\2"+
		"\u0089\u008b\t\3\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d(\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090"+
		"\7v\2\2\u0090\u0091\7g\2\2\u0091\u0092\7r\2\2\u0092\u0093\7u\2\2\u0093"+
		"*\3\2\2\2\u0094\u0096\t\4\2\2\u0095\u0097\t\5\2\2\u0096\u0095\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099,\3"+
		"\2\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d\7i\2\2\u009d"+
		"\u009e\7t\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7k\2\2"+
		"\u00a1\u00a2\7g\2\2\u00a2\u00a3\7p\2\2\u00a3\u00b7\7v\2\2\u00a4\u00a5"+
		"\7x\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7i\2\2\u00a7\u00a8\7g\2\2\u00a8"+
		"\u00a9\7v\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7d\2\2\u00ab\u00ac\7n\2\2"+
		"\u00ac\u00b7\7g\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7t\2\2\u00af\u00b0"+
		"\7w\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b7\7v\2\2\u00b2\u00b3\7o\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b7\7v\2\2\u00b6\u009a\3\2\2"+
		"\2\u00b6\u00a4\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7."+
		"\3\2\2\2\b\2u\u0087\u008c\u0098\u00b6\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}