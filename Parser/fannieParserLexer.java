// Generated from fannieParser.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fannieParserLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "WS", 
			"MAIN", "RECIPE", "TOOL_LIST", "INGREDIENT_LIST", "STEP_LIST", "CONTAIN", 
			"REMOVE", "DO", "OR", "DESCRIPTION_STRING", "START", "STOP", "WHEN", 
			"SERVE", "CONTENT_IN", "TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", "INGREDIENT_BASIC_TYPE_IDENTIFIER", 
			"COMPLEX_IDENTIFIER", "AMOUNT", "WEIGHT_UNIT", "ABSTRACT_UNIT", "TO_TASTE", 
			"COMMENT"
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


	public fannieParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "fannieParser.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u014b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\6\nW\n\n\r\n\16\nX\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\7\24\u0098\n\24\f\24\16\24\u009b"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u00f5\n\34\3\35\3\35\6\35\u00f9\n\35\r"+
		"\35\16\35\u00fa\3\36\6\36\u00fe\n\36\r\36\16\36\u00ff\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0110\n\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0138\n \3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3\"\3\"\3\"\6\"\u0146\n\"\r\"\16\"\u0147\3\"\3\"\2\2#"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#\3\2\b\5\2\13\f\17\17\"\"\3\2$$\3\2C\\\6\2\62;C\\aac|\3\2\62"+
		";\5\2\61\61``pp\2\u0164\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3\2\2\2"+
		"\17Q\3\2\2\2\21S\3\2\2\2\23V\3\2\2\2\25\\\3\2\2\2\27a\3\2\2\2\31h\3\2"+
		"\2\2\33n\3\2\2\2\35z\3\2\2\2\37\u0080\3\2\2\2!\u0088\3\2\2\2#\u008f\3"+
		"\2\2\2%\u0092\3\2\2\2\'\u0095\3\2\2\2)\u009e\3\2\2\2+\u00a4\3\2\2\2-\u00a9"+
		"\3\2\2\2/\u00ae\3\2\2\2\61\u00b4\3\2\2\2\63\u00bf\3\2\2\2\65\u00c2\3\2"+
		"\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00fd\3\2\2\2=\u010f\3\2\2\2?\u0137"+
		"\3\2\2\2A\u0139\3\2\2\2C\u0142\3\2\2\2EF\7}\2\2F\4\3\2\2\2GH\7\177\2\2"+
		"H\6\3\2\2\2IJ\7.\2\2J\b\3\2\2\2KL\7*\2\2L\n\3\2\2\2MN\7+\2\2N\f\3\2\2"+
		"\2OP\7]\2\2P\16\3\2\2\2QR\7_\2\2R\20\3\2\2\2ST\7<\2\2T\22\3\2\2\2UW\t"+
		"\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\n\2\2[\24"+
		"\3\2\2\2\\]\7o\2\2]^\7c\2\2^_\7k\2\2_`\7p\2\2`\26\3\2\2\2ab\7t\2\2bc\7"+
		"g\2\2cd\7e\2\2de\7k\2\2ef\7r\2\2fg\7g\2\2g\30\3\2\2\2hi\7v\2\2ij\7q\2"+
		"\2jk\7q\2\2kl\7n\2\2lm\7u\2\2m\32\3\2\2\2no\7k\2\2op\7p\2\2pq\7i\2\2q"+
		"r\7t\2\2rs\7g\2\2st\7f\2\2tu\7k\2\2uv\7g\2\2vw\7p\2\2wx\7v\2\2xy\7u\2"+
		"\2y\34\3\2\2\2z{\7u\2\2{|\7v\2\2|}\7g\2\2}~\7r\2\2~\177\7u\2\2\177\36"+
		"\3\2\2\2\u0080\u0081\7e\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083"+
		"\u0084\7v\2\2\u0084\u0085\7c\2\2\u0085\u0086\7k\2\2\u0086\u0087\7p\2\2"+
		"\u0087 \3\2\2\2\u0088\u0089\7t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7o\2"+
		"\2\u008b\u008c\7q\2\2\u008c\u008d\7x\2\2\u008d\u008e\7g\2\2\u008e\"\3"+
		"\2\2\2\u008f\u0090\7f\2\2\u0090\u0091\7q\2\2\u0091$\3\2\2\2\u0092\u0093"+
		"\7q\2\2\u0093\u0094\7t\2\2\u0094&\3\2\2\2\u0095\u0099\7$\2\2\u0096\u0098"+
		"\n\3\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7$"+
		"\2\2\u009d(\3\2\2\2\u009e\u009f\7U\2\2\u009f\u00a0\7V\2\2\u00a0\u00a1"+
		"\7C\2\2\u00a1\u00a2\7T\2\2\u00a2\u00a3\7V\2\2\u00a3*\3\2\2\2\u00a4\u00a5"+
		"\7U\2\2\u00a5\u00a6\7V\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8\7R\2\2\u00a8"+
		",\3\2\2\2\u00a9\u00aa\7y\2\2\u00aa\u00ab\7j\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\u00ad\7p\2\2\u00ad.\3\2\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7x\2\2\u00b2\u00b3\7g\2\2\u00b3\60\3\2\2\2\u00b4"+
		"\u00b5\7e\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7v\2\2"+
		"\u00b8\u00b9\7g\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc"+
		"\7\"\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be\62\3\2\2\2\u00bf"+
		"\u00c0\7?\2\2\u00c0\u00c1\7@\2\2\u00c1\64\3\2\2\2\u00c2\u00c3\7v\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7n\2\2\u00c6\66\3\2\2\2\u00c7"+
		"\u00c8\7k\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7i\2\2\u00ca\u00cb\7t\2\2"+
		"\u00cb\u00cc\7g\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf"+
		"\7g\2\2\u00cf\u00d0\7p\2\2\u00d0\u00f5\7v\2\2\u00d1\u00d2\7x\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3\u00d4\7i\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7v\2\2"+
		"\u00d6\u00d7\7c\2\2\u00d7\u00d8\7d\2\2\u00d8\u00d9\7n\2\2\u00d9\u00f5"+
		"\7g\2\2\u00da\u00db\7h\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7w\2\2\u00dd"+
		"\u00de\7k\2\2\u00de\u00f5\7v\2\2\u00df\u00e0\7o\2\2\u00e0\u00e1\7g\2\2"+
		"\u00e1\u00e2\7c\2\2\u00e2\u00f5\7v\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5"+
		"\7k\2\2\u00e5\u00e6\7s\2\2\u00e6\u00e7\7w\2\2\u00e7\u00e8\7k\2\2\u00e8"+
		"\u00f5\7f\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7k\2\2"+
		"\u00ec\u00ed\7e\2\2\u00ed\u00f5\7g\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0"+
		"\7w\2\2\u00f0\u00f5\7v\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7t\2\2\u00f3"+
		"\u00f5\7{\2\2\u00f4\u00c7\3\2\2\2\u00f4\u00d1\3\2\2\2\u00f4\u00da\3\2"+
		"\2\2\u00f4\u00df\3\2\2\2\u00f4\u00e3\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4"+
		"\u00ee\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f58\3\2\2\2\u00f6\u00f8\t\4\2\2"+
		"\u00f7\u00f9\t\5\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb:\3\2\2\2\u00fc\u00fe\t\6\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100<\3\2\2\2\u0101\u0110\7i\2\2\u0102\u0103\7m\2\2\u0103\u0110"+
		"\7i\2\2\u0104\u0105\7o\2\2\u0105\u0110\7n\2\2\u0106\u0107\7f\2\2\u0107"+
		"\u0110\7n\2\2\u0108\u0110\7n\2\2\u0109\u010a\7o\2\2\u010a\u0110\7i\2\2"+
		"\u010b\u010c\7n\2\2\u010c\u0110\7d\2\2\u010d\u010e\7q\2\2\u010e\u0110"+
		"\7|\2\2\u010f\u0101\3\2\2\2\u010f\u0102\3\2\2\2\u010f\u0104\3\2\2\2\u010f"+
		"\u0106\3\2\2\2\u010f\u0108\3\2\2\2\u010f\u0109\3\2\2\2\u010f\u010b\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u0110>\3\2\2\2\u0111\u0112\7v\2\2\u0112\u0113"+
		"\7d\2\2\u0113\u0114\7u\2\2\u0114\u0138\7r\2\2\u0115\u0116\7v\2\2\u0116"+
		"\u0117\7u\2\2\u0117\u0138\7r\2\2\u0118\u0119\7r\2\2\u0119\u011a\7k\2\2"+
		"\u011a\u011b\7p\2\2\u011b\u011c\7e\2\2\u011c\u0138\7j\2\2\u011d\u011e"+
		"\7y\2\2\u011e\u011f\7j\2\2\u011f\u0120\7q\2\2\u0120\u0121\7n\2\2\u0121"+
		"\u0138\7g\2\2\u0122\u0123\7j\2\2\u0123\u0124\7c\2\2\u0124\u0125\7n\2\2"+
		"\u0125\u0138\7h\2\2\u0126\u0127\7v\2\2\u0127\u0128\7j\2\2\u0128\u0129"+
		"\7k\2\2\u0129\u012a\7t\2\2\u012a\u0138\7f\2\2\u012b\u012c\7s\2\2\u012c"+
		"\u012d\7w\2\2\u012d\u012e\7c\2\2\u012e\u012f\7t\2\2\u012f\u0130\7v\2\2"+
		"\u0130\u0131\7g\2\2\u0131\u0138\7t\2\2\u0132\u0133\7g\2\2\u0133\u0134"+
		"\7k\2\2\u0134\u0135\7i\2\2\u0135\u0136\7j\2\2\u0136\u0138\7v\2\2\u0137"+
		"\u0111\3\2\2\2\u0137\u0115\3\2\2\2\u0137\u0118\3\2\2\2\u0137\u011d\3\2"+
		"\2\2\u0137\u0122\3\2\2\2\u0137\u0126\3\2\2\2\u0137\u012b\3\2\2\2\u0137"+
		"\u0132\3\2\2\2\u0138@\3\2\2\2\u0139\u013a\7v\2\2\u013a\u013b\7q\2\2\u013b"+
		"\u013c\7/\2\2\u013c\u013d\7v\2\2\u013d\u013e\7c\2\2\u013e\u013f\7u\2\2"+
		"\u013f\u0140\7v\2\2\u0140\u0141\7g\2\2\u0141B\3\2\2\2\u0142\u0143\7\61"+
		"\2\2\u0143\u0145\7\61\2\2\u0144\u0146\t\7\2\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014a\7\f\2\2\u014aD\3\2\2\2\13\2X\u0099\u00f4\u00fa\u00ff"+
		"\u010f\u0137\u0147\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}