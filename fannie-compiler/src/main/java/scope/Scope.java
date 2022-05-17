package scope;
import java.util.HashMap;
import java.util.Map;

import Exceptions.CompilerException;
import fannieTypes.Tool;


public class Scope {
    private Scope parent;
    public HashMap<String, Object> symbolTable;
    
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
    
    public Void append(String key, Object value)
    {
        if(symbolTable.get(key)!= null)
        {
            throw new CompilerException("Symbol: " + key + " already exists");
        }
        symbolTable.put(key, value);
        return null;
    }

    public Void overwrite(String key, Object value)
    {
        symbolTable.put(key, value);
        return null;
    }

    public Object retrieve(String name)
    {
        if (symbolTable.containsKey(name)) {
            return symbolTable.get(name);
        }
        else if (!isGlobalScope()) {
            return parent.retrieve(name);
        }
        throw new CompilerException("Undefined variable: " + name);
    }

    
    public int getTypeAmount(HashMap<String, Object> symbolTable, String type)
    {
        int amount = 0;
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals(type)) {
                amount++;
            }
        }
        return amount;
    }
    
    public HashMap<String, Object> getSymbolTable()
    {
        return symbolTable;
    }
    
    public void Remove (String key)
    {
        if (symbolTable.containsKey((key)))
        {
        symbolTable.remove(key);
        }
        else throw new CompilerException("Key: " + key + " not found");
    }
   
    public Boolean hasToolsBeenUsed()
    {
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
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

    public Boolean isContinousDoStepStopped()
    {
        if(getTypeAmount(symbolTable, "fannieTypes.steps.ContinousDoStepDeclaration") == 0)
        {
            return true;
        }
        else return false;
    }

    public String getProcIdentifier()
    {
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            if (entry.getValue().getClass().getName().equals("fannieTypes.steps.ContinousDoStepDeclaration")) {
                return ((fannieTypes.steps.ContinousDoStepDeclaration)entry.getValue()).procIdentifier;
            }
        }
        return null;
    }

}
