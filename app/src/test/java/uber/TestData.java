package uber;

import dto.UberPickDTO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
public class TestData {

    public static UberPickDTO testDTO() {
        LocalDateTime dateTime = LocalDateTime.of(2012, 2, 12, 12, 14, 5);
        return new UberPickDTO(dateTime, 10.2, 20.3, "B02512");
    }

    public static List<UberPickDTO> listDTO() {
        return Arrays.asList(testDTO(), testDTO(), testDTO());
    }
}
