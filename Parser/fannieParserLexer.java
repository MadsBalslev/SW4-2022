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
		DO=16, OR=17, DESCRIPTION_STRING=18, START=19, STOP=20, WHEN=21, SERVE=22, 
		CONTENT_IN=23, TRANSFORM=24, TOOL_BASIC_TYPE_IDENTIFIER=25, INGREDIENT_BASIC_TYPE_IDENTIFIER=26, 
		COMPLEX_IDENTIFIER=27, AMOUNT=28, WEIGHT_UNIT=29, ABSTRACT_UNIT=30, TO_TASTE=31, 
		COMMENT=32;
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
			"DO", "OR", "DESCRIPTION_STRING", "START", "STOP", "WHEN", "SERVE", "CONTENT_IN", 
			"TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", "INGREDIENT_BASIC_TYPE_IDENTIFIER", 
			"COMPLEX_IDENTIFIER", "AMOUNT", "WEIGHT_UNIT", "ABSTRACT_UNIT", "TO_TASTE", 
			"COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0142\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\6\nU\n\n\r\n\16\nV\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\7\23"+
		"\u008f\n\23\f\23\16\23\u0092\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00ec\n\33"+
		"\3\34\3\34\6\34\u00f0\n\34\r\34\16\34\u00f1\3\35\6\35\u00f5\n\35\r\35"+
		"\16\35\u00f6\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\5\36\u0107\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u012f\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\6!\u013d"+
		"\n!\r!\16!\u013e\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"\3\2\b\5\2\13\f\17\17\"\"\3\2$$\3"+
		"\2C\\\6\2\62;C\\aac|\3\2\62;\5\2\61\61``pp\2\u015b\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2"+
		"\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23T\3\2\2\2\25Z\3\2\2\2\27_\3"+
		"\2\2\2\31f\3\2\2\2\33l\3\2\2\2\35x\3\2\2\2\37~\3\2\2\2!\u0086\3\2\2\2"+
		"#\u0089\3\2\2\2%\u008c\3\2\2\2\'\u0095\3\2\2\2)\u009b\3\2\2\2+\u00a0\3"+
		"\2\2\2-\u00a5\3\2\2\2/\u00ab\3\2\2\2\61\u00b6\3\2\2\2\63\u00b9\3\2\2\2"+
		"\65\u00eb\3\2\2\2\67\u00ed\3\2\2\29\u00f4\3\2\2\2;\u0106\3\2\2\2=\u012e"+
		"\3\2\2\2?\u0130\3\2\2\2A\u0139\3\2\2\2CD\7}\2\2D\4\3\2\2\2EF\7\177\2\2"+
		"F\6\3\2\2\2GH\7.\2\2H\b\3\2\2\2IJ\7*\2\2J\n\3\2\2\2KL\7+\2\2L\f\3\2\2"+
		"\2MN\7]\2\2N\16\3\2\2\2OP\7_\2\2P\20\3\2\2\2QR\7<\2\2R\22\3\2\2\2SU\t"+
		"\2\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\b\n\2\2Y\24"+
		"\3\2\2\2Z[\7o\2\2[\\\7c\2\2\\]\7k\2\2]^\7p\2\2^\26\3\2\2\2_`\7t\2\2`a"+
		"\7g\2\2ab\7e\2\2bc\7k\2\2cd\7r\2\2de\7g\2\2e\30\3\2\2\2fg\7v\2\2gh\7q"+
		"\2\2hi\7q\2\2ij\7n\2\2jk\7u\2\2k\32\3\2\2\2lm\7k\2\2mn\7p\2\2no\7i\2\2"+
		"op\7t\2\2pq\7g\2\2qr\7f\2\2rs\7k\2\2st\7g\2\2tu\7p\2\2uv\7v\2\2vw\7u\2"+
		"\2w\34\3\2\2\2xy\7u\2\2yz\7v\2\2z{\7g\2\2{|\7r\2\2|}\7u\2\2}\36\3\2\2"+
		"\2~\177\7e\2\2\177\u0080\7q\2\2\u0080\u0081\7p\2\2\u0081\u0082\7v\2\2"+
		"\u0082\u0083\7c\2\2\u0083\u0084\7k\2\2\u0084\u0085\7p\2\2\u0085 \3\2\2"+
		"\2\u0086\u0087\7f\2\2\u0087\u0088\7q\2\2\u0088\"\3\2\2\2\u0089\u008a\7"+
		"q\2\2\u008a\u008b\7t\2\2\u008b$\3\2\2\2\u008c\u0090\7$\2\2\u008d\u008f"+
		"\n\3\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7$"+
		"\2\2\u0094&\3\2\2\2\u0095\u0096\7U\2\2\u0096\u0097\7V\2\2\u0097\u0098"+
		"\7C\2\2\u0098\u0099\7T\2\2\u0099\u009a\7V\2\2\u009a(\3\2\2\2\u009b\u009c"+
		"\7U\2\2\u009c\u009d\7V\2\2\u009d\u009e\7Q\2\2\u009e\u009f\7R\2\2\u009f"+
		"*\3\2\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7g\2\2\u00a3"+
		"\u00a4\7p\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7t\2\2\u00a8\u00a9\7x\2\2\u00a9\u00aa\7g\2\2\u00aa.\3\2\2\2\u00ab"+
		"\u00ac\7e\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7v\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0\u00b1\7p\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3"+
		"\7\"\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\60\3\2\2\2\u00b6"+
		"\u00b7\7?\2\2\u00b7\u00b8\7@\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7q\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7n\2\2\u00bd\64\3\2\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7i\2\2\u00c1\u00c2\7t\2\2"+
		"\u00c2\u00c3\7g\2\2\u00c3\u00c4\7f\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6"+
		"\7g\2\2\u00c6\u00c7\7p\2\2\u00c7\u00ec\7v\2\2\u00c8\u00c9\7x\2\2\u00c9"+
		"\u00ca\7g\2\2\u00ca\u00cb\7i\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7v\2\2"+
		"\u00cd\u00ce\7c\2\2\u00ce\u00cf\7d\2\2\u00cf\u00d0\7n\2\2\u00d0\u00ec"+
		"\7g\2\2\u00d1\u00d2\7h\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7w\2\2\u00d4"+
		"\u00d5\7k\2\2\u00d5\u00ec\7v\2\2\u00d6\u00d7\7o\2\2\u00d7\u00d8\7g\2\2"+
		"\u00d8\u00d9\7c\2\2\u00d9\u00ec\7v\2\2\u00da\u00db\7n\2\2\u00db\u00dc"+
		"\7k\2\2\u00dc\u00dd\7s\2\2\u00dd\u00de\7w\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00ec\7f\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7r\2\2\u00e2\u00e3\7k\2\2"+
		"\u00e3\u00e4\7e\2\2\u00e4\u00ec\7g\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7"+
		"\7w\2\2\u00e7\u00ec\7v\2\2\u00e8\u00e9\7f\2\2\u00e9\u00ea\7t\2\2\u00ea"+
		"\u00ec\7{\2\2\u00eb\u00be\3\2\2\2\u00eb\u00c8\3\2\2\2\u00eb\u00d1\3\2"+
		"\2\2\u00eb\u00d6\3\2\2\2\u00eb\u00da\3\2\2\2\u00eb\u00e0\3\2\2\2\u00eb"+
		"\u00e5\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\66\3\2\2\2\u00ed\u00ef\t\4\2"+
		"\2\u00ee\u00f0\t\5\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f28\3\2\2\2\u00f3\u00f5\t\6\2\2\u00f4"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7:\3\2\2\2\u00f8\u0107\7i\2\2\u00f9\u00fa\7m\2\2\u00fa\u0107"+
		"\7i\2\2\u00fb\u00fc\7o\2\2\u00fc\u0107\7n\2\2\u00fd\u00fe\7f\2\2\u00fe"+
		"\u0107\7n\2\2\u00ff\u0107\7n\2\2\u0100\u0101\7o\2\2\u0101\u0107\7i\2\2"+
		"\u0102\u0103\7n\2\2\u0103\u0107\7d\2\2\u0104\u0105\7q\2\2\u0105\u0107"+
		"\7|\2\2\u0106\u00f8\3\2\2\2\u0106\u00f9\3\2\2\2\u0106\u00fb\3\2\2\2\u0106"+
		"\u00fd\3\2\2\2\u0106\u00ff\3\2\2\2\u0106\u0100\3\2\2\2\u0106\u0102\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0107<\3\2\2\2\u0108\u0109\7v\2\2\u0109\u010a"+
		"\7d\2\2\u010a\u010b\7u\2\2\u010b\u012f\7r\2\2\u010c\u010d\7v\2\2\u010d"+
		"\u010e\7u\2\2\u010e\u012f\7r\2\2\u010f\u0110\7r\2\2\u0110\u0111\7k\2\2"+
		"\u0111\u0112\7p\2\2\u0112\u0113\7e\2\2\u0113\u012f\7j\2\2\u0114\u0115"+
		"\7y\2\2\u0115\u0116\7j\2\2\u0116\u0117\7q\2\2\u0117\u0118\7n\2\2\u0118"+
		"\u012f\7g\2\2\u0119\u011a\7j\2\2\u011a\u011b\7c\2\2\u011b\u011c\7n\2\2"+
		"\u011c\u012f\7h\2\2\u011d\u011e\7v\2\2\u011e\u011f\7j\2\2\u011f\u0120"+
		"\7k\2\2\u0120\u0121\7t\2\2\u0121\u012f\7f\2\2\u0122\u0123\7s\2\2\u0123"+
		"\u0124\7w\2\2\u0124\u0125\7c\2\2\u0125\u0126\7t\2\2\u0126\u0127\7v\2\2"+
		"\u0127\u0128\7g\2\2\u0128\u012f\7t\2\2\u0129\u012a\7g\2\2\u012a\u012b"+
		"\7k\2\2\u012b\u012c\7i\2\2\u012c\u012d\7j\2\2\u012d\u012f\7v\2\2\u012e"+
		"\u0108\3\2\2\2\u012e\u010c\3\2\2\2\u012e\u010f\3\2\2\2\u012e\u0114\3\2"+
		"\2\2\u012e\u0119\3\2\2\2\u012e\u011d\3\2\2\2\u012e\u0122\3\2\2\2\u012e"+
		"\u0129\3\2\2\2\u012f>\3\2\2\2\u0130\u0131\7v\2\2\u0131\u0132\7q\2\2\u0132"+
		"\u0133\7/\2\2\u0133\u0134\7v\2\2\u0134\u0135\7c\2\2\u0135\u0136\7u\2\2"+
		"\u0136\u0137\7v\2\2\u0137\u0138\7g\2\2\u0138@\3\2\2\2\u0139\u013a\7\61"+
		"\2\2\u013a\u013c\7\61\2\2\u013b\u013d\t\7\2\2\u013c\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\3\2"+
		"\2\2\u0140\u0141\7\f\2\2\u0141B\3\2\2\2\13\2V\u0090\u00eb\u00f1\u00f6"+
		"\u0106\u012e\u013e\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}