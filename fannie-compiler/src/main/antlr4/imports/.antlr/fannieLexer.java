// Generated from /home/lugialukas/Github/SW4-2022/fannie-compiler/src/main/antlr4/imports/fannieLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fannieLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, MAIN=2, RECIPE=3, TOOL_LIST=4, INGREDIENT_LIST=5, STEP_LIST=6, CONTAIN=7, 
		REMOVE=8, DO=9, OR=10, DESCRIPTION_STRING=11, START=12, STOP=13, WHEN=14, 
		SERVE=15, CONTENT_IN=16, TRANSFORM=17, TOOL_BASIC_TYPE_IDENTIFIER=18, 
		INGREDIENT_BASIC_TYPE_IDENTIFIER=19, COMPLEX_IDENTIFIER=20, AMOUNT=21, 
		WEIGHT_UNIT=22, ABSTRACT_UNIT=23, TO_TASTE=24, COMMENT=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "MAIN", "RECIPE", "TOOL_LIST", "INGREDIENT_LIST", "STEP_LIST", 
			"CONTAIN", "REMOVE", "DO", "OR", "DESCRIPTION_STRING", "START", "STOP", 
			"WHEN", "SERVE", "CONTENT_IN", "TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", 
			"INGREDIENT_BASIC_TYPE_IDENTIFIER", "COMPLEX_IDENTIFIER", "AMOUNT", "WEIGHT_UNIT", 
			"ABSTRACT_UNIT", "TO_TASTE", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'main'", "'recipe'", "'tools'", "'ingredients'", "'steps'", 
			"'contain'", "'remove'", "'do'", "'or'", null, "'START'", "'STOP'", "'when'", 
			"'serve'", "'content in'", "'=>'", "'tool'", null, null, null, null, 
			null, "'to-taste'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "MAIN", "RECIPE", "TOOL_LIST", "INGREDIENT_LIST", "STEP_LIST", 
			"CONTAIN", "REMOVE", "DO", "OR", "DESCRIPTION_STRING", "START", "STOP", 
			"WHEN", "SERVE", "CONTENT_IN", "TRANSFORM", "TOOL_BASIC_TYPE_IDENTIFIER", 
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


	public fannieLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "fannieLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u012b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\6\2\67\n\2\r\2\16\28\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\7\fx\n\f\f\f\16\f{\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d5\n\24\3\25\3\25"+
		"\6\25\u00d9\n\25\r\25\16\25\u00da\3\26\6\26\u00de\n\26\r\26\16\26\u00df"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00f0\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0118\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\6\32\u0126\n\32\r\32\16\32\u0127\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\3\2\b\5\2\13\f\17\17\"\"\3\2$$\3\2C\\"+
		"\6\2\62;C\\aac|\3\2\62;\5\2\61\61``pp\2\u0144\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\3\66\3\2\2\2\5<\3\2\2\2\7A\3\2\2\2\tH\3\2\2\2\13N\3\2\2\2\rZ\3\2"+
		"\2\2\17`\3\2\2\2\21h\3\2\2\2\23o\3\2\2\2\25r\3\2\2\2\27u\3\2\2\2\31~\3"+
		"\2\2\2\33\u0084\3\2\2\2\35\u0089\3\2\2\2\37\u008e\3\2\2\2!\u0094\3\2\2"+
		"\2#\u009f\3\2\2\2%\u00a2\3\2\2\2\'\u00d4\3\2\2\2)\u00d6\3\2\2\2+\u00dd"+
		"\3\2\2\2-\u00ef\3\2\2\2/\u0117\3\2\2\2\61\u0119\3\2\2\2\63\u0122\3\2\2"+
		"\2\65\67\t\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2"+
		"\2\2:;\b\2\2\2;\4\3\2\2\2<=\7o\2\2=>\7c\2\2>?\7k\2\2?@\7p\2\2@\6\3\2\2"+
		"\2AB\7t\2\2BC\7g\2\2CD\7e\2\2DE\7k\2\2EF\7r\2\2FG\7g\2\2G\b\3\2\2\2HI"+
		"\7v\2\2IJ\7q\2\2JK\7q\2\2KL\7n\2\2LM\7u\2\2M\n\3\2\2\2NO\7k\2\2OP\7p\2"+
		"\2PQ\7i\2\2QR\7t\2\2RS\7g\2\2ST\7f\2\2TU\7k\2\2UV\7g\2\2VW\7p\2\2WX\7"+
		"v\2\2XY\7u\2\2Y\f\3\2\2\2Z[\7u\2\2[\\\7v\2\2\\]\7g\2\2]^\7r\2\2^_\7u\2"+
		"\2_\16\3\2\2\2`a\7e\2\2ab\7q\2\2bc\7p\2\2cd\7v\2\2de\7c\2\2ef\7k\2\2f"+
		"g\7p\2\2g\20\3\2\2\2hi\7t\2\2ij\7g\2\2jk\7o\2\2kl\7q\2\2lm\7x\2\2mn\7"+
		"g\2\2n\22\3\2\2\2op\7f\2\2pq\7q\2\2q\24\3\2\2\2rs\7q\2\2st\7t\2\2t\26"+
		"\3\2\2\2uy\7$\2\2vx\n\3\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|"+
		"\3\2\2\2{y\3\2\2\2|}\7$\2\2}\30\3\2\2\2~\177\7U\2\2\177\u0080\7V\2\2\u0080"+
		"\u0081\7C\2\2\u0081\u0082\7T\2\2\u0082\u0083\7V\2\2\u0083\32\3\2\2\2\u0084"+
		"\u0085\7U\2\2\u0085\u0086\7V\2\2\u0086\u0087\7Q\2\2\u0087\u0088\7R\2\2"+
		"\u0088\34\3\2\2\2\u0089\u008a\7y\2\2\u008a\u008b\7j\2\2\u008b\u008c\7"+
		"g\2\2\u008c\u008d\7p\2\2\u008d\36\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7t\2\2\u0091\u0092\7x\2\2\u0092\u0093\7g\2\2\u0093"+
		" \3\2\2\2\u0094\u0095\7e\2\2\u0095\u0096\7q\2\2\u0096\u0097\7p\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2"+
		"\u009b\u009c\7\"\2\2\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\"\3\2"+
		"\2\2\u009f\u00a0\7?\2\2\u00a0\u00a1\7@\2\2\u00a1$\3\2\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"&\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7i\2\2\u00aa"+
		"\u00ab\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2\u00b0\u00d5\7v\2\2\u00b1\u00b2"+
		"\7x\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7i\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7v\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7d\2\2\u00b8\u00b9\7n\2\2"+
		"\u00b9\u00d5\7g\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd"+
		"\7w\2\2\u00bd\u00be\7k\2\2\u00be\u00d5\7v\2\2\u00bf\u00c0\7o\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00d5\7v\2\2\u00c3\u00c4\7n\2\2"+
		"\u00c4\u00c5\7k\2\2\u00c5\u00c6\7s\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8"+
		"\7k\2\2\u00c8\u00d5\7f\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7r\2\2\u00cb"+
		"\u00cc\7k\2\2\u00cc\u00cd\7e\2\2\u00cd\u00d5\7g\2\2\u00ce\u00cf\7p\2\2"+
		"\u00cf\u00d0\7w\2\2\u00d0\u00d5\7v\2\2\u00d1\u00d2\7f\2\2\u00d2\u00d3"+
		"\7t\2\2\u00d3\u00d5\7{\2\2\u00d4\u00a7\3\2\2\2\u00d4\u00b1\3\2\2\2\u00d4"+
		"\u00ba\3\2\2\2\u00d4\u00bf\3\2\2\2\u00d4\u00c3\3\2\2\2\u00d4\u00c9\3\2"+
		"\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5(\3\2\2\2\u00d6\u00d8"+
		"\t\4\2\2\u00d7\u00d9\t\5\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db*\3\2\2\2\u00dc\u00de\t\6\2\2"+
		"\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0,\3\2\2\2\u00e1\u00f0\7i\2\2\u00e2\u00e3\7m\2\2\u00e3\u00f0"+
		"\7i\2\2\u00e4\u00e5\7o\2\2\u00e5\u00f0\7n\2\2\u00e6\u00e7\7f\2\2\u00e7"+
		"\u00f0\7n\2\2\u00e8\u00f0\7n\2\2\u00e9\u00ea\7o\2\2\u00ea\u00f0\7i\2\2"+
		"\u00eb\u00ec\7n\2\2\u00ec\u00f0\7d\2\2\u00ed\u00ee\7q\2\2\u00ee\u00f0"+
		"\7|\2\2\u00ef\u00e1\3\2\2\2\u00ef\u00e2\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef"+
		"\u00e6\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00eb\3\2"+
		"\2\2\u00ef\u00ed\3\2\2\2\u00f0.\3\2\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3"+
		"\7d\2\2\u00f3\u00f4\7u\2\2\u00f4\u0118\7r\2\2\u00f5\u00f6\7v\2\2\u00f6"+
		"\u00f7\7u\2\2\u00f7\u0118\7r\2\2\u00f8\u00f9\7r\2\2\u00f9\u00fa\7k\2\2"+
		"\u00fa\u00fb\7p\2\2\u00fb\u00fc\7e\2\2\u00fc\u0118\7j\2\2\u00fd\u00fe"+
		"\7y\2\2\u00fe\u00ff\7j\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7n\2\2\u0101"+
		"\u0118\7g\2\2\u0102\u0103\7j\2\2\u0103\u0104\7c\2\2\u0104\u0105\7n\2\2"+
		"\u0105\u0118\7h\2\2\u0106\u0107\7v\2\2\u0107\u0108\7j\2\2\u0108\u0109"+
		"\7k\2\2\u0109\u010a\7t\2\2\u010a\u0118\7f\2\2\u010b\u010c\7s\2\2\u010c"+
		"\u010d\7w\2\2\u010d\u010e\7c\2\2\u010e\u010f\7t\2\2\u010f\u0110\7v\2\2"+
		"\u0110\u0111\7g\2\2\u0111\u0118\7t\2\2\u0112\u0113\7g\2\2\u0113\u0114"+
		"\7k\2\2\u0114\u0115\7i\2\2\u0115\u0116\7j\2\2\u0116\u0118\7v\2\2\u0117"+
		"\u00f1\3\2\2\2\u0117\u00f5\3\2\2\2\u0117\u00f8\3\2\2\2\u0117\u00fd\3\2"+
		"\2\2\u0117\u0102\3\2\2\2\u0117\u0106\3\2\2\2\u0117\u010b\3\2\2\2\u0117"+
		"\u0112\3\2\2\2\u0118\60\3\2\2\2\u0119\u011a\7v\2\2\u011a\u011b\7q\2\2"+
		"\u011b\u011c\7/\2\2\u011c\u011d\7v\2\2\u011d\u011e\7c\2\2\u011e\u011f"+
		"\7u\2\2\u011f\u0120\7v\2\2\u0120\u0121\7g\2\2\u0121\62\3\2\2\2\u0122\u0123"+
		"\7\61\2\2\u0123\u0125\7\61\2\2\u0124\u0126\t\7\2\2\u0125\u0124\3\2\2\2"+
		"\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u012a\7\f\2\2\u012a\64\3\2\2\2\13\28y\u00d4\u00da\u00df"+
		"\u00ef\u0117\u0127\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}