import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Adrian on 2017-03-21.
 */
public class GenerateSampleMain {

    private Random random = new Random();

    public void generate(InputStream is, PrintStream out) {
        Scanner scanner = new Scanner(is);
        out.println(scanner.nextLine());

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (random.nextDouble() < 0.001) {
                out.println(line);
            }
        }
        scanner.close();
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new GenerateSampleMain().generate(System.in, System.out);
    }
}
