grammar fannieParser;
import fannieLexer;

toolIdentifier : COMPLEX_IDENTIFIER;
toolActionIdentifier : COMPLEX_IDENTIFIER | CONTAIN | REMOVE;
toolTypeIdentifier : COMPLEX_IDENTIFIER | TOOL_BASIC_TYPE_IDENTIFIER;
ingredientTypeIdentifier : COMPLEX_IDENTIFIER | INGREDIENT_BASIC_TYPE_IDENTIFIER;
ingredientIdentifier : COMPLEX_IDENTIFIER;
recipeIdentifier : COMPLEX_IDENTIFIER;
procIdentifier : COMPLEX_IDENTIFIER;

fannie : mainRecipe (subRecipe)* EOF;

mainRecipe : MAIN RECIPE recipeIdentifier '{' recipeBody '}';
subRecipe : RECIPE recipeIdentifier '{' recipeBody '}'; 

recipeBody : ingredientsList ',' toolsList ',' stepsList;

ingredientsList : INGREDIENT_LIST '{' ingredientDeclaration (',' ingredientDeclaration)* '}';

toolsList : TOOL_LIST '{' toolDeclaration (',' toolDeclaration)* '}';

stepsList : STEP_LIST '{' stepDeclaration (',' stepDeclaration)* '}';

ingredientDeclaration : deterministicIngredientDeclaration 
                      | nondeterministicIngredientDeclaration
                      | recipeIngredientDeclaration
                      | ingredientTypeDeclaration;

deterministicIngredientDeclaration : ingredientTypeIdentifier ingredientIdentifier amountDeclaration;

nondeterministicIngredientDeclaration : deterministicIngredientDeclaration (OR deterministicIngredientDeclaration)+;
 
recipeIngredientDeclaration : RECIPE recipeIdentifier;

ingredientTypeDeclaration : ingredientTypeIdentifier ingredientTypeIdentifier;

amountDeclaration : '(' AMOUNT WEIGHT_UNIT (',' AMOUNT ABSTRACT_UNIT)?  ')'
                  | '(' TO_TASTE ')';

toolDeclaration : toolTypeIdentifier toolIdentifier toolActionDeclarationsList; 

toolActionDeclarationsList : ('[' toolActionDeclaration (',' toolActionDeclaration)* ']')?;

toolActionDeclaration : CONTAIN ':' ingredientTypeIdentifier
                      | toolActionIdentifier ':' ingredientTypeIdentifier '=>' ingredientTypeIdentifier
                      | toolActionIdentifier ':' contentIn '=>' ingredientTypeIdentifier;

stepDeclaration : doStepDeclaration
                | continousDoStepStartDeclaration
                | continousDoStepStopDeclaration
                | serveStepDeclaration;

serveStepDeclaration : SERVE stepIn;

doStepDeclaration : toolIdentifier DO toolActionIdentifier (DESCRIPTION_STRING)? stepIn ('=>' stepOut)?;

continousDoStepStartDeclaration : START procIdentifier toolIdentifier DO toolActionIdentifier (DESCRIPTION_STRING)? stepIn;

continousDoStepStopDeclaration : STOP procIdentifier (WHEN DESCRIPTION_STRING)? ('=>' stepOut)?;

stepIn : ingredientIdentifier | ingredientCollection | contentIn;
stepOut : ingredientIdentifier | ingredientCollection;

contentIn : CONTENT_IN toolIdentifier;

ingredientCollection : '{'ingredientIdentifier (',' ingredientIdentifier)* '}';