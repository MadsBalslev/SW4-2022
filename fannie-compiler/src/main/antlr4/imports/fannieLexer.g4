lexer grammar fannieLexer;

WS: (' ' | '\t' | '\n' | '\r')+ -> channel(HIDDEN);

MAIN: 'main';
RECIPE: 'recipe';

TOOL_LIST: 'tools';
INGREDIENT_LIST: 'ingredients';
STEP_LIST: 'steps';

CONTAIN: 'contain';
REMOVE: 'remove';

DO: 'do';
OR: 'or';

DESCRIPTION_STRING: '"' (~["])* '"';
START: 'START';
STOP: 'STOP';
WHEN: 'when';
SERVE: 'serve';
CONTENT_IN: 'content in';
TRANSFORM: '=>';

TOOL_BASIC_TYPE_IDENTIFIER: 'tool';
INGREDIENT_BASIC_TYPE_IDENTIFIER:
	'ingredient' // Categorised like a shop? no
	| 'vegetable'
	| 'fruit'
	| 'meat'
	| 'liquid'
	| 'spice'
	| 'nut'
	| 'dry';
COMPLEX_IDENTIFIER: [A-Z][a-zA-Z0-9_]+;

AMOUNT: [0-9]+;
WEIGHT_UNIT:
	'g'
	| 'kg'
	| 'ml'
	| 'dl'
	| 'l'
	| 'mg'
	| 'lb'
	| 'oz';
ABSTRACT_UNIT:
	'tbsp'
	| 'tsp'
	| 'pinch'
	| 'whole'
	| 'half'
	| 'third'
	| 'quarter'
	| 'eight';
TO_TASTE: 'to-taste';

COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
