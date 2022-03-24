grammar fannieParser;
import fannieLexer;

program : mainRecipe (subRecipe)* EOF;

toolIdentifier : COMPLEX_IDENTIFIER;
toolActionIdentifier : COMPLEX_IDENTIFIER | CONTAIN | REMOVE;
toolTypeIdentifier : COMPLEX_IDENTIFIER | TOOL_BASIC_TYPE_IDENTIFIER;
ingredientTypeIdentifier : COMPLEX_IDENTIFIER | INGREDIENT_BASIC_TYPE_IDENTIFIER;
ingredientIdentifier : COMPLEX_IDENTIFIER;
recipeIdentifier : COMPLEX_IDENTIFIER;
procIdentifier : COMPLEX_IDENTIFIER;

mainRecipe : MAIN RECIPE recipeIdentifier '{' recipeBody '}';

subRecipe : RECIPE recipeIdentifier '{' recipeBody '}'; 

recipeBody : ingredientsList ',' toolsList ',' stepsList;

stepIn : ingredientIdentifier | collection | CONTENT_IN toolIdentifier;
stepOut : ingredientIdentifier | collection;

ingredientsList : INGREDIENT_LIST '{' ingredientDeclaration (',' ingredientDeclaration)* '}';

ingredientDeclaration : deterministicIngredientDeclaration 
                      | nondeterministicIngredientDeclaration
                      | recipeIngredientDeclaration
                      | ingredientSubtypeDeclaration;

deterministicIngredientDeclaration : ingredientTypeIdentifier ingredientIdentifier amountDeclaration;

nondeterministicIngredientDeclaration : deterministicIngredientDeclaration (OR deterministicIngredientDeclaration)+;
 
recipeIngredientDeclaration : RECIPE recipeIdentifier;

ingredientSubtypeDeclaration : ingredientTypeIdentifier ingredientTypeIdentifier;

amountDeclaration : '(' AMOUNT WEIGHT_UNIT (',' AMOUNT ABSTRACT_UNIT)?  ')'
                  | '(' TO_TASTE ')';

toolsList : TOOL_LIST '{' toolDeclaration (',' toolDeclaration)* '}';

stepsList : STEP_LIST '{' stepDeclaration (',' stepDeclaration)* '}';

toolDeclaration : toolTypeIdentifier toolIdentifier toolActionDeclarationsList; 

toolActionDeclarationsList : ('[' toolActionDeclaration (',' toolActionDeclaration)* ']')?;

toolActionDeclaration : CONTAIN ':' ingredientIdentifier
                      | toolActionIdentifier ':' ingredientTypeIdentifier '=>' ingredientTypeIdentifier
                      | toolActionIdentifier ':' CONTENT_IN toolIdentifier '=>' ingredientTypeIdentifier;

stepDeclaration : doStepDeclaration
                | continousDoStepStartDeclaration
                | continousDoStepStopDeclaration
                | serveStepDeclaration;

serveStepDeclaration : SERVE recipeIdentifier
                     | SERVE CONTENT_IN toolIdentifier;

doStepDeclaration : toolIdentifier DO toolActionIdentifier (DESCRIPTION_STRING)? stepIn ('=>' stepOut)?;

collection : '{'ingredientIdentifier (',' ingredientIdentifier)* '}';

continousDoStepStartDeclaration : START procIdentifier doStepDeclaration;

continousDoStepStopDeclaration : STOP procIdentifier (WHEN DESCRIPTION_STRING)? ('=>' stepOut)?;
