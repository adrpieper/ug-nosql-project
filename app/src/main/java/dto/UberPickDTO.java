package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

/**
 * Created by Adrian on 2017-03-21.
 */
public class UberPickDTO {
    @JsonSerialize(using = StandardDateSerializer.class)
    private final LocalDateTime dateTime;
    private final double[] location = {0,0};
    private final String base;

    public UberPickDTO(LocalDateTime dateTime, double latitude, double longitude, String base) {
        this.dateTime = dateTime;
        this.location[0] = latitude;
        this.location[1] = longitude;
        this.base = base;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double[] getLocation() {
        return location;
    }

    public String getBase() {
        return base;
    }
}
