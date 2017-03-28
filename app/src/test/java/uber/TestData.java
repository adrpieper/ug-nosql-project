package uber;

import dto.UberPickDTO;
import dto.geo.GeoMapper;
import dto.geo.UberPickGeoDTO;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
public class TestData {

    public static UberPickDTO testDTO() {
        return testDTO(12);
    }

    public static UberPickDTO testDTO(int hour) {
        LocalDateTime dateTime = LocalDateTime.of(2012, 2, 12, hour, 14, 5);
        return new UberPickDTO(dateTime, 10.2f, 20.3f, "B02512");
    }

    public static List<UberPickDTO> listDTO() {
        return Arrays.asList(testDTO(1), testDTO(12), testDTO(16));
    }

    public static UberPickGeoDTO testGeoDTO() {
        return new GeoMapper().map(testDTO());
    }

    public static List<UberPickGeoDTO> listGeoDTO() {
        return Arrays.asList(testGeoDTO(), testGeoDTO(), testGeoDTO());
    }

    public static InputStream sample() {
        return TestData.class.getResourceAsStream("sample.csv");
    }
}
