package dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dto.geo.UberPickGeoDTO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Adrian on 2017-03-21.
 */
public class UberPickDTO {
    @JsonSerialize(using = StandardDateSerializer.class)
    private final LocalDateTime dateTime;
    private final float[] location = {0,0};
    private final String base;

    public UberPickDTO(LocalDateTime dateTime, float latitude, float longitude, String base) {
        this.dateTime = dateTime;
        this.location[0] = latitude;
        this.location[1] = longitude;
        this.base = base;
    }



    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public float[] getLocation() {
        return location;
    }

    public String getBase() {
        return base;
    }
}
