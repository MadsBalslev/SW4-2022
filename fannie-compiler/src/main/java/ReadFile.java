import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReadFile {
    public static InputStream read(String path) {
        try {
            File file = new File(path);
            System.out.println("Jeg har læst en fil: " + file.getName());
            InputStream content = new FileInputStream(file);
            return content;
        } catch (Exception e) {
            System.out.println("File could not be read");
            return null;
        }
    }
}
