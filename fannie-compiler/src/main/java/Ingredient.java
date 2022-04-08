public class Ingredient {
    public String identifier;
    public String type;
    @Override 
    public String toString() {
        return identifier + ": " + type;
    }
}
