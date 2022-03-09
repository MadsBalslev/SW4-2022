lexer grammar fannyLexer;

MAIN : 'main';
RECIPE : 'recipe';

TOOL_LIST : 'tools';
INGREDIENT_LIST : 'ingredients';
STEP_LIST : 'steps';

SERVE : 'serve';

TOOL_BASIC_TYPE_IDENTIFIER : 'tool';
INGREDIENT_BASIC_TYPE_IDENTIFIER : 'ingredient' // Categorised like a shop? no
                                 | 'vegetable'
                                 | 'fruit'
                                 | 'meat'
                                 | 'liquid'
                                 | 'spice'
                                 | 'dry';

COMPLEX_IDENTIFIER : [A-Z][\w]+;

/* TODO this might cause a problem */
WEIGHT : [0-9]+;
WEIGHT_UNIT : 'g' | 'kg' | 'ml' | 'dl' | 'l' | 'mg' | 'lb' | 'oz';
AMOUNT : [0-9]+;
DESCRIPTION_STRING : '\"'[^"]+'\"';