package uber;

import http.UberPickHttpClient;
import org.junit.jupiter.api.Test;
import uber.TestData;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-25.
 */
class UberPickElasticSearchHttpClientTest {

    private UberPickHttpClient unterTest = new UberPickHttpClient();

    @Test
    public void put() {
        unterTest.put(TestData.testDTO());
    }

    @Test
    public void postBulk() {
        unterTest.post(TestData.listDTO());
    }
}