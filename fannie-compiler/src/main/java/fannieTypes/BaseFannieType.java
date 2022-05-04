package fannieTypes;
public abstract class BaseFannieType 
{
    public String identifier;
    public String typeIdentifier;
    public BaseFannieType(String identifier, String typeIdentifier)
    {
        this.identifier = identifier;
        this.typeIdentifier = typeIdentifier;
    }

}