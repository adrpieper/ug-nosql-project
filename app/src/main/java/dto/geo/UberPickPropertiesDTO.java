package dto.geo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dto.StandardDateSerializer;

import java.time.LocalDateTime;

/**
 * Created by Adrian on 2017-03-25.
 */
public class UberPickPropertiesDTO {

    private final String base;
    private final LocalDateTime dateTime;

    public UberPickPropertiesDTO(String base, LocalDateTime dateTime) {

        this.base = base;
        this.dateTime = dateTime;
    }

    public String getBase() {
        return base;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
