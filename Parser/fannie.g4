grammar fannie;

program : main_recipe (recipe)*;

main_recipe : MAIN recipe;

recipe : RECIPE ID '{' recipe_body '}';

recipe_body : tool_list ingredient_list steps_list;

tool_list : TOOLS '{' (tool)+ '}';

ingredient_list : INGREDIENTS '{' (ingredient)+ '}';

steps_list : STEPS '{' (steps)+ serve_step '}';

serve_step : SERVE ID;

ingredient : INGREDIENT_TYPE ID '(' MEASUREMENT (',' AMOUNT)? ')'
           | RECIPE ID;

tool : TOOL_TYPE ID ('[' tool_action (',' tool_action)* ']')?;
tool_action: ID ':' INGREDIENT_TYPE;


steps : ID 'do' tool_action (DESCRIPTION)? ID;
DESCRIPTION: '["' [^()] '"]';

MAIN : 'main';
RECIPE : 'recipe';
TOOLS : 'tools';
TOOL_TYPE : 'tool';
SERVE : 'serve';
INGREDIENTS : 'ingredients';
MEASUREMENT : [0-9]+ WEIGHT_UNIT;
WEIGHT_UNIT : 'g' | 'kg' | 'ml' | 'dl' | 'l' | 'mg' | 'lb' | 'oz';
AMOUNT : [0-9]+;
STEPS : 'steps';
ID : [A-Z][a-z0-9]+ ;
INGREDIENT_TYPE: 'ingredient'|'vegetable'|'fruit'|'meat';