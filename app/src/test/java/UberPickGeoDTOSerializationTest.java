import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.geo.GeoJsonDTO;
import org.junit.jupiter.api.Test;
import uber.TestData;

/**
 * Created by Adrian on 2017-03-25.
 */
public class UberPickGeoDTOSerializationTest {

    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(TestData.testGeoDTO()));
    }

    @Test
    public void testList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        GeoJsonDTO geoJsonDTO = new GeoJsonDTO(TestData.listGeoDTO());
        System.out.println(objectMapper.writeValueAsString(geoJsonDTO));
    }
}
