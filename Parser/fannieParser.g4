grammar fannieParser;
import fannieLexer;

program : mainRecipe (subRecipe)* EOF;

mainRecipe : MAIN RECIPE COMPLEX_IDENTIFIER '{' recipeBody '}';

subRecipe : RECIPE COMPLEX_IDENTIFIER '{' recipeBody '}'; 

recipeBody : ingredientsList ',' toolsList ',' stepsList;

ingredientsList : INGREDIENT_LIST '{' ingredientDeclaration (',' ingredientDeclaration)* '}';

ingredientDeclaration : INGREDIENT_BASIC_TYPE_IDENTIFIER  COMPLEX_IDENTIFIER amountDeclaration
                      | RECIPE COMPLEX_IDENTIFIER
                      | (INGREDIENT_BASIC_TYPE_IDENTIFIER | COMPLEX_IDENTIFIER)  COMPLEX_IDENTIFIER amountDeclaration OR (INGREDIENT_BASIC_TYPE_IDENTIFIER | COMPLEX_IDENTIFIER)  COMPLEX_IDENTIFIER amountDeclaration
                      | COMPLEX_IDENTIFIER COMPLEX_IDENTIFIER amountDeclaration;

amountDeclaration : '(' AMOUNT WEIGHT_UNIT (',' AMOUNT ABSTRACT_UNIT)?  ')'
                  | '(' TO_TASTE ')';

toolsList : TOOL_LIST '{' toolDeclaration (',' toolDeclaration)* '}';

stepsList : STEP_LIST '{' stepDeclaration (',' stepDeclaration)* '}';

toolDeclaration : TOOL_BASIC_TYPE_IDENTIFIER COMPLEX_IDENTIFIER ('[' toolActionDeclaration (',' toolActionDeclaration)* ']')?
                | COMPLEX_IDENTIFIER COMPLEX_IDENTIFIER ('[' toolActionDeclaration (',' toolActionDeclaration)* ']')?;

toolActionDeclaration : COMPLEX_IDENTIFIER ':' INGREDIENT_BASIC_TYPE_IDENTIFIER
                      | COMPLEX_IDENTIFIER ':' COMPLEX_IDENTIFIER
                      | CONTAIN ':' COMPLEX_IDENTIFIER
                      | CONTAIN ':' INGREDIENT_BASIC_TYPE_IDENTIFIER
                      | CONTAIN ':' amountDeclaration
                      | COMPLEX_IDENTIFIER ':' CONTENT_IN COMPLEX_IDENTIFIER;

stepDeclaration : doStepDeclaration
                | continousDoStepStartDeclaration
                | continousDoStepStopDeclaration
                | serveStepDeclaration;

serveStepDeclaration : SERVE COMPLEX_IDENTIFIER
                     | SERVE CONTENT_IN COMPLEX_IDENTIFIER;

doStepDeclaration : COMPLEX_IDENTIFIER DO (COMPLEX_IDENTIFIER | CONTAIN) (DESCRIPTION_STRING)? (COMPLEX_IDENTIFIER | collection | CONTENT_IN COMPLEX_IDENTIFIER) (TRANSFORM COMPLEX_IDENTIFIER)?;

collection : '{'COMPLEX_IDENTIFIER (',' COMPLEX_IDENTIFIER)* '}';

continousDoStepStartDeclaration : START COMPLEX_IDENTIFIER doStepDeclaration;

continousDoStepStopDeclaration : STOP COMPLEX_IDENTIFIER (WHEN DESCRIPTION_STRING)? (TRANSFORM COMPLEX_IDENTIFIER)?;