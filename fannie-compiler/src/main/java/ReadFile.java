import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {
    public static String read(File fannieFile) {
        String data = "";
        Scanner scan = new Scanner(fannieFile);
        try {
            while (scan.hasNextLine()) {
                data += scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldnt find file!");
            e.printStackTrace();
        }
        return data;
    }
}
