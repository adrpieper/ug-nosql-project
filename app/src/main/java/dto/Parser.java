package dto;

import dto.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Adrian on 2017-03-21.
 */
public class Parser {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:mm:ss");

    public DTO parse(String line) {
        String[] split = line.replace("\"","").split(",");
        LocalDateTime dateTime = LocalDateTime.parse(split[0], formatter);
        double latitude = Double.parseDouble(split[1]);
        double longitude = Double.parseDouble(split[2]);
        String base = split[3];
        return new DTO(dateTime, latitude, longitude, base);
    }
}
