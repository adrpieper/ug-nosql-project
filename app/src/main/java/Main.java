import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Adrian on 2017-03-21.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("uber-raw-data-apr14.csv");
        Scanner scanner = new Scanner(fileInputStream);

        long lines = 0;
        while (scanner.hasNext()) {
            lines++;
            scanner.nextLine();
        }
        System.out.println(lines);
    }
}
