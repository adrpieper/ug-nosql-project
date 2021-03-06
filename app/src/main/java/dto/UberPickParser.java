package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static dto.FormatterProvider.provide;

/**
 * Created by Adrian on 2017-03-21.
 */
public class UberPickParser {

    private final DateTimeFormatter formatter = provide();

    public UberPickDTO parse(String line) {
        String[] split = line.replace("\"","").split(",");
        LocalDateTime dateTime = LocalDateTime.parse(split[0], formatter);
        float latitude = Float.parseFloat(split[1]);
        float longitude = Float.parseFloat(split[2]);
        String base = split[3];
        return new UberPickDTO(dateTime, longitude, latitude, base);
    }
}
