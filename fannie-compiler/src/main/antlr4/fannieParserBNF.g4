grammar fannieParserBNF;
import fannieLexer;

toolIdentifier : COMPLEX_IDENTIFIER;
toolActionIdentifier : COMPLEX_IDENTIFIER | CONTAIN | REMOVE;
toolTypeIdentifier : COMPLEX_IDENTIFIER | TOOL_BASIC_TYPE_IDENTIFIER;
ingredientTypeIdentifier : COMPLEX_IDENTIFIER | INGREDIENT_BASIC_TYPE_IDENTIFIER;
ingredientIdentifier : COMPLEX_IDENTIFIER;
recipeIdentifier : COMPLEX_IDENTIFIER;
procIdentifier : COMPLEX_IDENTIFIER;

fannie : mainRecipe subRecipe EOF;

mainRecipe : MAIN RECIPE recipeIdentifier '{' recipeBody '}';
subRecipe : RECIPE recipeIdentifier '{' recipeBody '}' subRecipe
          |; 

recipeBody : ingredientsList ',' toolsList ',' stepsList;

ingredientsList : INGREDIENT_LIST '{' ingredientDeclaration possibleIngredientDeclaration '}';

possibleIngredientDeclaration : ',' ingredientDeclaration possibleIngredientDeclaration
                              |;

toolsList : TOOL_LIST '{' toolDeclaration possibleToolDeclaration '}';

possibleToolDeclaration : ',' toolDeclaration possibleToolDeclaration
                        |;

stepsList : STEP_LIST '{' stepDeclaration possibleStepDeclaration '}';

possibleStepDeclaration : ',' stepDeclaration possibleStepDeclaration
                        |;

ingredientDeclaration : deterministicIngredientDeclaration 
                      | nondeterministicIngredientDeclaration
                      | recipeIngredientDeclaration
                      | ingredientTypeDeclaration;

deterministicIngredientDeclaration : ingredientTypeIdentifier ingredientIdentifier amountDeclaration;

nondeterministicIngredientDeclaration : deterministicIngredientDeclaration OR deterministicIngredientDeclaration possibledeterministicIngredientDeclaration;

possibledeterministicIngredientDeclaration : OR deterministicIngredientDeclaration possibledeterministicIngredientDeclaration
                                           |;
 
recipeIngredientDeclaration : RECIPE recipeIdentifier;

ingredientTypeDeclaration : ingredientTypeIdentifier ingredientTypeIdentifier;

amountDeclaration : '(' AMOUNT WEIGHT_UNIT optionalAbstractAmount ')'
                  | '(' TO_TASTE ')';
                  
optionalAbstractAmount : ',' AMOUNT ABSTRACT_UNIT 
                       |;

toolDeclaration : toolTypeIdentifier toolIdentifier toolActionDeclarationsList; 


toolActionDeclarationsList : '[' toolActionDeclaration possibleToolActionDeclaration ']'
                           |;

possibleToolActionDeclaration : ',' toolActionDeclaration possibleToolActionDeclaration
                              |;

toolActionDeclaration : CONTAIN ':' ingredientTypeIdentifier
                      | toolActionIdentifier ':' ingredientTypeIdentifier '=>' ingredientTypeIdentifier
                      | toolActionIdentifier ':' contentIn '=>' ingredientTypeIdentifier;

stepDeclaration : doStepDeclaration
                | continousDoStepStartDeclaration
                | continousDoStepStopDeclaration
                | serveStepDeclaration;

serveStepDeclaration : SERVE stepIn;

doStepDeclaration : toolIdentifier DO toolActionIdentifier optionalDescriptionString stepIn optionalStepOut;


continousDoStepStartDeclaration : START procIdentifier toolIdentifier DO toolActionIdentifier optionalDescriptionString stepIn;

optionalDescriptionString : DESCRIPTION_STRING
                          |;

continousDoStepStopDeclaration : STOP procIdentifier optionalWhenDescriptionString optionalStepOut;

optionalWhenDescriptionString : WHEN DESCRIPTION_STRING 
                              |;

stepIn : ingredientIdentifier | ingredientCollection | contentIn;
stepOut : ingredientIdentifier | ingredientCollection;

optionalStepOut : '=>' stepOut
                |;

contentIn : CONTENT_IN toolIdentifier;

ingredientCollection : '{'ingredientIdentifier possibleIngredientDeclaration '}';

possibleIngredientIdentifier : ',' ingredientIdentifier possibleIngredientIdentifier
                             |;