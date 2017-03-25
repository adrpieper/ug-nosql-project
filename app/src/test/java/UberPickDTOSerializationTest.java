import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UberPickDTO;
import org.junit.jupiter.api.Test;
import uber.TestData;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Adrian on 2017-03-22.
 */
public class UberPickDTOSerializationTest {

    private final String EXPECTED_JSON = "{\"dateTime\":\"2012-02-12T12:14:05\",\"latitude\":10.2,\"longitude\":20.3,\"base\":\"B02512\"}";

    @Test
    public void convert() throws JsonProcessingException {
        UberPickDTO uberPickDto = TestData.testDTO();
        ObjectMapper objectMapper = new ObjectMapper();

        String result = objectMapper.writeValueAsString(uberPickDto);

        assertThat(result).isEqualTo(EXPECTED_JSON);
    }
}
