package sql;

import org.junit.jupiter.api.Test;
import uber.TestData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-26.
 */
class SqlImporterTest {

    SqlImporter underTest = new SqlImporter();

    @Test
    void importToDb() {
        underTest.importToDb(TestData.sample(), 100);
    }
}