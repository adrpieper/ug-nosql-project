package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

/**
 * Created by Adrian on 2017-03-21.
 */
public class DTO {
    @JsonSerialize(using = DataSerializer.class)
    private final LocalDateTime dateTime;
    private final double latitude;
    private final double longitude;
    private final String base;

    public DTO(LocalDateTime dateTime, double latitude, double longitude, String base) {
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.base = base;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getBase() {
        return base;
    }
}
