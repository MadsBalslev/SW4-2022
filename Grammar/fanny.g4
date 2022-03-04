grammar fanny;

program : MAIN (recipe)+;

recipe : RECIPE ID '{' recipe_body '}';

recipe_body : tool_list ingredient_list steps_list;

tool_list : TOOLS '{' (tool)* '}';
ingredient_list : INGREDIENTS '{' (ingredient)+ '}';
steps_list : STEPS '{' (steps)+ serve_step '}';

ingredient : INGREDIENT;

MAIN : 'main';
RECIPE : 'recipe';
TOOLS : 'tools';
INGREDIENTS : 'ingredients';
STEPS : 'steps';
ID : [A-Z][a-z]+ ;
