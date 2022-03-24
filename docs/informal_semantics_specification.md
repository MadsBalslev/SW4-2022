# Informal semantics specification

## Environments

- Ingredient environment - holds names of the current ingredients in the current scope.
- Tool environment - holds names and functionality of current tools in the current scope.
- Step environment - holds names of continuessteps in the current scope.
- Recipe environment - holds the current declared recipe definitions.

## Scopes

- The Recipe environment is monolithically scoped.
- The Tool enviroment is dynamically scoped to current recipe and all agregate recipes.
- The Ingredient environment is statically scoped to current recipe.
- The Step environment is statically scoped to current recipe.

## IngredientDeclaration

In the current recipe, ingredientdeclaration will create and add a new ingredient to the recipe it is declared in.  After a successful ingredientdeclaration, the ingredient identifier must be used in the stepdeclaration.

## ToolDeclaration

In the current recipe, tooldeclaration will create and add a new tool to the recipe it is declared in, and all aggregate recipes.  After a successful tooldeclaration, the tool identifier must be used in a stepdeclaration.

## StepDeclaration

Steps primarily operate on the ingredient environment using the tools in the tool environment.

`t do a i`
i is removed, and i is added with new type.

<code>t do a i<sub>1</sub> => i<sub>2</sub></code>
One ingredient become one ingredient.

<code>t do a { i<sub>1</sub>, i<sub>2</sub>, i<sub>3</sub>, …, i<sub>n</sub> } => i'</code>
Multiple ingredients become one ingredient.

<code>t do a { i<sub>1</sub>, i<sub>2</sub>, i<sub>3</sub>, …, i<sub>n</sub> } => { i'<sub>1</sub>, i'<sub>2</sub>, i'<sub>3</sub>, …, i'<sub>n</sub> }</code>
Multiple ingredients become multiple ingredients.

<code>t do a i<sub>1</sub> => { i'<sub>1</sub>, i'<sub>2</sub>, i'<sub>3</sub>, …, i'<sub>n</sub> }</code>
One ingredient becomes multiple ingredients.

All ingredients introduced in the step declaration should be used.  
