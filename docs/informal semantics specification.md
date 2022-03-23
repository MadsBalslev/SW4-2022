# Informal semantics specification
## Environments 
-   Ingredient environment 
-   Tool environment 
-   Step environment 
-   Recipe environment 

## IngredientDeclaration 
In the current recipe, ingredientdeclaration will create and add a new ingredient to the recipe it is declared in.  After a successful ingredientdeclaration, the ingredient identifier must be used in the stepdeclaration. 

## ToolDeclaration 
In the current recipe, tooldeclaration will create and add a new tool to the recipe it is declared in, and all aggregate recipes.  After a successful tooldeclaration, the tool identifier must be used in a stepdeclaration. 

## StepDeclaration 
Steps primarily operate on the ingredient environment using the tools in the tool environment. 

```t do a i``` 

Nothing happens. 

```t do a i1 => i2```
One ingredient become one ingredient. 

```t do a { i1, i2, i3, …, in } => Ik``` 
More ingredients become one ingredient.

```t do a { i1, i2, i3, …, in } => { ik1, ik2, ik3, …, ikn }``` 
More ingredients become more ingredients. 

```t do a i1 => { ik1, ik2, ik3, …, ikn }``` 
One ingredient becomes one ingredient.

All ingredients introduced in the step declaration should be used.