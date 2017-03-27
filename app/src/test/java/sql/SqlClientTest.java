package sql;

import org.junit.jupiter.api.Test;
import uber.TestData;

/**
 * Created by Adrian on 2017-03-26.
 */
class SqlClientTest {

    private SqlClient sqlClient = new SqlClient();

    @Test
    void insert() {
        sqlClient.insert(TestData.listDTO());
    }

    @Test
    void clear() {
        sqlClient.clear();
    }

}