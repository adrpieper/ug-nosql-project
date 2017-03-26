import org.junit.jupiter.api.Test;
import uber.Importer;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ImportTest {

    private Importer importer = new Importer();

    @Test
    public void importSampleFile() {
        importer.sendToDb(ImportTest.class.getResourceAsStream("uber/sample.csv"), 10);
    }
}
