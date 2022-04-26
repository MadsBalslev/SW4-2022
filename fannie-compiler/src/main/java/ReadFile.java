import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFile {
    public static InputStream read(String path) {
        try {
            File file = new File(path);
            InputStream content = new FileInputStream(file);
            return content;
        } catch (Exception e) {
            System.out.println("[ERROR] File could not be read");
            return null;
        }
    }
}
