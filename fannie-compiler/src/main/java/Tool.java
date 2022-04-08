import java.util.ArrayList;
import java.util.List;
public class Tool {
    public String toolTypeIdentifier;
    public String toolIdentifier;
    public List<ToolAction> toolActionDeclarationsList = new ArrayList<ToolAction>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toolIdentifier + ": " + toolTypeIdentifier + "\n Toolactions \n");
        for (ToolAction toolAction : toolActionDeclarationsList) {
            sb.append(toolAction.toString() + "\n");
        }
        return sb.toString();
    }
}
