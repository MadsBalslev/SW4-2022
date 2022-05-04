package fannieTypes.toolActions;

import fannieTypes.Ingredient;
import Handlers.IngredientTypeHandler;

public class ContainToolActionDeclaration extends ToolAction {
    
    public ContainToolActionDeclaration(String input) {
        this.input = input;
        this.output = "content in";
        this.toolActionIdentifier = "contain";
    }

}