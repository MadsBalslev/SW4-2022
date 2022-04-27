import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.*;
import fannieTypes.*;

public class RecipeTestStrings {
    
    public static InputStream ingredientListMissingFromRecipeTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/IngredientListMissingFromRecipeTest.fannie");
    }

    public static InputStream ingredientNotDeclaredButUsedTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/IngredientNotDeclaredButUsedTest.fannie");
    }

    public static InputStream mainRecipeKeywordMissingTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/MainRecipeKeywordMissingTest.fannie");
    }
    
    public static InputStream stepListMissingFromRecipeTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/StepListMissingFromRecipeTest.fannie");
    }

    public static InputStream toolNotDeclaredButUsedTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/ToolNotDeclaredButUsedTest.fannie");
    }

    public static InputStream toolsListMissingFromRecipeTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/ToolsListMissingFromRecipeTest.fannie");
    }

    public static InputStream CommasAfterListingsMissingFromTestRecipe() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/CommasAfterListingsMissingFromTestRecipe.fannie");
    }

    public static InputStream CommasMissingInsideIngredientBlockTest() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/CommasMissingInsideIngredientBlockTest.fannie");
    }

    public static InputStream ServeKeywordMissingFromRecipe() throws IOException 
    {
        return ReadFile.read("../RecipeExamples/TestRecipes/ServeKeywordMissingFromRecipe.fannie");
    }

    
    
}
