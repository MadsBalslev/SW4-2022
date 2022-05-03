package fannieTypes.toolActions;
public abstract class ToolAction {
    public String toolActionIdentifier;
    public String input;
    public String output;
    //debug code
    public String toString() {
        return toolActionIdentifier + ": " + input + " -> " + output;
    } 
    //debug code
}
