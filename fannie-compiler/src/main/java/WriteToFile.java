import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void write(String filename, StringBuilder markdownFormat) {
        try {
            FileWriter markdownfile = new FileWriter(filename += ".md");
            markdownfile.write(markdownFormat.toString());
            System.out.println("Succesfully wrote markdown file");
            markdownfile.close();
        } catch (IOException e) {
            System.out.println("Can not create file!");
            e.printStackTrace();
        }
    }
}