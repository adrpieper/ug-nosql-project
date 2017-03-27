import org.junit.jupiter.api.Test;
import uber.ElasticSearchImporter;
import uber.TestData;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ImportTest {

    private ElasticSearchImporter elasticSearchImporter = new ElasticSearchImporter();

    @Test
    public void importSampleFile() {
        elasticSearchImporter.sendToDb(TestData.sample(), 10);
    }

}
