package fannieTypes;
import scope.Scope;
public class HasBeenServed extends BaseFannieType {
    public boolean isServed;
    public HasBeenServed(Scope scope) {
        super("HasbeenServed", "HasBeenServed");
        this.isServed = false;
        scope.append(this.identifier, this);
    }
}