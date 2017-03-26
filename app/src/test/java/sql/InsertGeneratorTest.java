package sql;

import org.junit.jupiter.api.Test;
import uber.TestData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-26.
 */
class InsertGeneratorTest {

    private InsertGenerator unterTest = new InsertGenerator();

    @Test
    public void generate() {
        String sql = unterTest.generate(TestData.listDTO());
        System.out.println(sql);
    }

}