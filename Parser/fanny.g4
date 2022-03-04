grammar fanny;

program : main_recipe (recipe)*;

main_recipe : MAIN recipe;
recipe : RECIPE ID '{' recipe_body '}';

recipe_body : tool_list ingredient_list steps_list;

tool_list : TOOLS '{' (tool)+ '}';
ingredient_list : INGREDIENTS '{' (ingredient)+ '}';
steps_list : STEPS '{' (steps)+ serve_step '}';

ingredient : INGREDIENT_TYPE ID '(' MEASUREMENT ')' 
           | INGREDIENT_TYPE ID '(' MEASUREMENT',' AMOUNT ')'
           | RECIPE ID;

MAIN : 'main';
RECIPE : 'recipe';
TOOLS : 'tools';
INGREDIENTS : 'ingredients';
MEASUREMENT : [0-9]+ WEIGHT_UNIT;
WEIGHT_UNIT : 'g' | 'kg' | 'ml' | 'dl' | 'l' | 'mg' | 'lb' | 'oz';
AMOUNT : [0-9]+;
STEPS : 'steps';
ID : [A-Z][a-z]+ ;
INGREDIENT_TYPE: 'ingredient'|'vegetable'|'fruit'|'meat';