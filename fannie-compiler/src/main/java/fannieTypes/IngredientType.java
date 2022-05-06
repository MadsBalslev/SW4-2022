package fannieTypes;

public class IngredientType extends BaseFannieType {
    public IngredientType parentIngredientType;
    public IngredientType(String identifier, IngredientType parentIngredientType) {
        super(identifier, "IngredientType");
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
    
    public String toString()
    {
        return this.identifier;
    }
    //debug code
}
