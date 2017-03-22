import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Adrian on 2017-03-22.
 */
public class DTOSerializationTest {

    private final String EXPECTED_JSON = "{\"dateTime\":\"12/2/2012 12:14:05\",\"latitude\":10.2,\"longitude\":20.3,\"base\":\"B02512\"}";

    @Test
    public void convert() throws JsonProcessingException {
        LocalDateTime dateTime = LocalDateTime.of(2012, 2, 12, 12, 14, 5);
        DTO dto = new DTO(dateTime, 10.2, 20.3, "B02512");
        ObjectMapper objectMapper = new ObjectMapper();

        String result = objectMapper.writeValueAsString(dto);

        assertThat(result).isEqualTo(EXPECTED_JSON);
    }
}
