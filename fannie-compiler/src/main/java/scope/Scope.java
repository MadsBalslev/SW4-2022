package scope;
import java.util.HashMap;
import java.util.Map;
import fannieTypes.Tool;
import fannieTypes.BaseFannieType;


public class Scope {
    private Scope parent;
    private HashMap<String, BaseFannieType> symbolTable;
    
    private boolean isGlobalScope() {
        return parent == null;
    }

    public Scope parentScope() {
        return parent;
    }
    
    public Scope() {
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
    
    public void append(String key, BaseFannieType value)
    {
        if(symbolTable.get(key)!= null)
        {
            throw new IllegalArgumentException("Symbol already exists");
        }
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
    //debug code
    public void stringPrinter(HashMap<String, BaseFannieType> symbolTable, String type)
    {
        for (Map.Entry<String, BaseFannieType> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals("fannieTypes." + type)) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }   
    }
    //debug code
    
    public int getTypeAmount(HashMap<String, BaseFannieType> symbolTable, String type)
    {
        int amount = 0;
        for (Map.Entry<String, BaseFannieType> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals(type)) {
                amount++;
            }
        }
        return amount;
    }
    
    public HashMap<String, BaseFannieType> getSymbolTable()
    {
        return symbolTable;
    }
    
    public void Remove (String key)
    {
        if (symbolTable.containsKey((key)))
        {
        symbolTable.remove(key);
        }
        else throw new RuntimeException("Key not found");
    }
   
    public Boolean hasToolsBeenUsed()
    {
        for (Map.Entry<String, BaseFannieType> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals("Tool")) {
                if (((Tool)entry.getValue()).getHasToolBeenUsed() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean isIngredientListEmpty()
    {
        if(getTypeAmount(symbolTable, "fannieTypes.Ingredient") == 0)
        {
            return true;
        }
        else return false;
    }

    public Boolean isProcListEmpty()
    {
        if(getTypeAmount(symbolTable, "fannieTypes.ProcIdentifier") == 0)
        {
            return true;
        }
        else return false;
    }
}
