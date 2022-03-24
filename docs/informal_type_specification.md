# Informal type system specification

**Program** is ok if main recipe is ok.

**Main Recipe** and Sub Recipe is ok if ingredients list, tools list and steps list are ok.

**Ingredients list** is ok if each ingredient declaration in ingredients list is ok.

**Tools list** is ok if each tool declaration in tools list is ok.

**Steps list** is ok if each step declaration is ok.

## Ingredient declarations

For ingredient declaration to be ok. The type of the ingredient type identifier must be ingredient type identifier. The amount must be a positive integer, and the unit must be a valid unit. The optional abstract amount must be a positive integer, and the abstract unit must be an abstract unit. The Declared ingredient becomes of the type specified in the ingredient type identifier.

## Tool declarations

A tool declaration is ok, if the tool type identifier is an identifier for another tool already declared, or tool primitive. And the tool action declaration is ok. The type of this new tool is the tool itself with a base type of the tool type identifier.  

## Tool Action Declarations

The type of the tool action becomes the tuple where the first member is the type of the tool for which it is defined, and the second is either the target tool or target ingredient. Thus, the right-hand side of the “:” must be of either base type tool or ingredient.  

## Step Declarations

### DostepDeclaration  

A do step declaration is ok if, the action type matches the type of the tool and the target of the tool is either an ingredient or tool. The type of the transformation output is ingredient.

### ContinousDoStepStartDeclaration

START C doStepDeclaration

ContinousDoStepStartDeclaration is ok, if doStepDeclaration is ok. Type of c becomes process.

### ContinousDoStepStopDeclaration

A ContinousDoStepStopDeclaration is ok if C is a valid Step and T is a description string, and the C after TRANSFORM is a valid ingredient.

STOP C (WHEN T) or STOP C (TRANSFORM C)

ContinousDoStepStopDeclaration is ok, if C is of type COMPLEX_IDENTIFIER, optionally you can add an WHEN T, T being of type DESCRIPTION_SCRING OR TRANSFORM with C is of type COMPLEX_IDENTIFIER  

### ServeStepDeclaration

‘Serve’ CONTENT_IN s

Is ok when it starts with the keyword serve, followed by an optional CONTENT_IN and ends with an s that is the name of the current recipe, thus it must be of type recipe.

### Collection

The members of an ingredient collection must all be of the base type ingredient.

{C1, C2, ... CN}
