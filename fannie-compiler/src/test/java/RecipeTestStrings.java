public class RecipeTestStrings {
    
    String IngredientListMissingFromRecipeTest = "main recipe Pasta{


        tools{
            tool Pot[contain : ingredient],
            tool Knife[Dice : ingredient => vegetable],
            tool Stove[Heat : content in Pot => ingredient],
            tool Sifter[contain : ingredient, Sift : content in Sifter => ingredient]
        },
        
        
        steps{
            Knife do Dice Pasta,
            Pot do contain Water,
    
            Stove do Heat "bring to boil" content in Pot,
    
            START Proc1 Stove do Heat content in Pot,
            
            Pot do contain Pasta,
            Pot do contain Salt,
    
            STOP Proc1 when "boil pasta for 6-10 minutes",
    
            Sifter do contain content in Pot,
            Sifter do Sift content in Sifter,
    
            serve content in Sifter
        }
    }";
}
