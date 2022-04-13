import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Scope {
    private Scope parent;
    private HashMap<String, Object> symbolTable;
    
    private boolean isGlobalScope() {
        return parent == null;
    }
    public Scope parentScope() {
        return parent;
    }

    Scope() {
        this.parent = null;
        this.symbolTable = new HashMap<>();
    }
    Scope(Scope parent)
    {
        this.parent = parent;
        this.symbolTable = new HashMap<>();
    }
    public Scope createScope() {
        Scope scope = new Scope();
        scope.setParent(this);
        return scope;
    }
    public Scope setParent(Scope parent) {
        this.parent = parent;
        return this;
    }

    public void append(String key, Object value)
    {
        symbolTable.put(key, value);
    }
    public Object retrieve(Object name)
    {
        if (symbolTable.containsKey(name)) {
            return symbolTable.get(name);
        }
        else if (!isGlobalScope()) {
            return parent.retrieve(name);
        }
        throw new RuntimeException("Undefined variable: " + name);
    }
    //Prints all the objects of the type given, for example ingredients
    public void stringPrinter(HashMap<String, Object> symbolTable, String type)
    {
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals(type)) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }
    }
    public HashMap<String, Object> getSymbolTable()
    {
        return symbolTable;
    }
    public void Remove (String key)
    {
        symbolTable.remove(key);
    }
    public List<Ingredient> GetIngredients()
    {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals("Ingredient")) {
                ingredients.add((Ingredient)entry.getValue());
            }
        }
        return ingredients;
    }
        
}
