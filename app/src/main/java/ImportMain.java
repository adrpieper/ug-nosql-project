import uber.Importer;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ImportMain {

    public static void main(String[] args) {
        new Importer().sendToDb(System.in, 100);
    }
}