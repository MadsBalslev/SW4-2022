import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void write(String filename, String content) throws IOException {
        // File path = new File(filename);
        // path.getParentFile().mkdirs();
        FileWriter file = new FileWriter(filename);
        file.write(content);
        file.close();
    }
}
