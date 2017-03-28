import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UberPickDTO;
import org.junit.jupiter.api.Test;
import uber.TestData;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Adrian on 2017-03-22.
 */
public class UberPickDTOSerializationTest {

    private final String JSON = "{\"dateTime\":\"2012-02-12T12:14:05\",\"location\":[10.2,20.3],\"base\":\"B02512\"}";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void toJSON() throws JsonProcessingException {
        String result = objectMapper.writeValueAsString(TestData.testDTO());

        assertThat(result).isEqualTo(JSON);
    }

    @Test
    public void toDTO() throws IOException {
        UberPickDTO EXPECTED_DTO = TestData.testDTO();

        UberPickDTO result = objectMapper.readValue(JSON, UberPickDTO.class);

        assertThat(result).isEqualsToByComparingFields(EXPECTED_DTO);
    }
}
