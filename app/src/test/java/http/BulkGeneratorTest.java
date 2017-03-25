package http;

import dto.UberPickDTO;
import org.junit.jupiter.api.Test;
import uber.TestData;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
class BulkGeneratorTest {

    private BulkGenerator unterTest = new BulkGenerator();

    @Test
    void generate() {
        List<UberPickDTO> uberPickDtos = Arrays.asList(TestData.testDTO(), TestData.testDTO(), TestData.testDTO());
        System.out.println(unterTest.generate(uberPickDtos,1L));
    }

}