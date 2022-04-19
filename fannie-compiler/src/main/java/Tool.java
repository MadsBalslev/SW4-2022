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
    public ToolAction getToolAction(String toolActionIdentifier) throws Exception
    {
        ToolAction toolAction = new ToolAction();
        Boolean actionFound = false;
        for (ToolAction toolActionDeclaration : toolActionDeclarationsList) {
            //System.out.println(toolActionDeclaration.toolActionIdentifier+"1");
            //System.out.println(toolActionIdentifier+"2");
            if (toolActionDeclaration.toolActionIdentifier.equals(toolActionIdentifier)) {
                toolAction = toolActionDeclaration;
                actionFound = true;
            }
        }
        if (actionFound == false) {
            throw new Exception("ToolAction not found");
        }
        return toolAction;
    }
}
