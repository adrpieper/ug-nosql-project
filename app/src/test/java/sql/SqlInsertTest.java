package sql;

import org.junit.jupiter.api.Test;
import uber.TestData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-26.
 */
class SqlInsertTest {

    private SqlInsert sqlInsert = new SqlInsert();
    @Test
    void insert() {
        sqlInsert.insert(TestData.listDTO());
    }

}