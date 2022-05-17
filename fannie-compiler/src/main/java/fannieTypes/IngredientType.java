package fannieTypes;

public class IngredientType {
    public IngredientType parentIngredientType;
    public String identifier;
    public IngredientType(String identifier, IngredientType parentIngredientType) {
        this.identifier = identifier;
        this.parentIngredientType = parentIngredientType;
    }

    public Boolean isType(String type)
    {
        if (this.identifier.equals(type))
        {
            return true;
        }
        else if (this.parentIngredientType != null)
        {
            return this.parentIngredientType.isType(type);
        }
        else
        {
            return false;
        }
    }
}
