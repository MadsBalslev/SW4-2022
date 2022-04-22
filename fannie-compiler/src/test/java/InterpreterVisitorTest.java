import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import fannieTypes.Ingredient;
import fannieTypes.Tool;
import fannieTypes.ToolAction;
import scope.Scope;

public class InterpreterVisitorTest {

    @Before
    public void init() throws IOException {
        List<Tool> toolsList = new ArrayList<Tool>();
        List<String> recipesList = new ArrayList<String>();
        Scope scope = new Scope();
        List<ToolAction> toolActionsList = new ArrayList<ToolAction>();
    }

     @Test
     public void correctlyVisitsFannie()
     {

     }

     @Test //Jeg fatter ikke hvad vi skal lave ? XD TAK CASPER :DD:D:
     public void correctlyVisitsRecipe()
     {

     }

     // Casper er wack. Skal vi kicke ham? [X] Ja [ ] Nej
     // Skal vi lave en handleplan til ham? [ ] Ja [ ] Nej
}
