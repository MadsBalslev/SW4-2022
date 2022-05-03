package fannieTypes;

public class ProcIdentifier extends BaseFannieType {
    private String value;
    public ProcIdentifier(String Value)
    {
        super(Value, "ProcIdentifier");
        this.value = Value;
    }
    public String getValue()
    {
        return this.value;
    }
}