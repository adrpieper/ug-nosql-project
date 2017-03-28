package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dto.geo.UberPickGeoDTO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Adrian on 2017-03-21.
 */
public class UberPickDTO {
    @JsonSerialize(using = StandardDateSerializer.class)
    @JsonDeserialize(using = StandardDateDeserializer.class)
    private final LocalDateTime dateTime;
    private final float[] location = {0,0};
    private final String base;

    public UberPickDTO(
            @JsonProperty("dateTime") LocalDateTime dateTime,
            @JsonProperty("location") float[] location,
            @JsonProperty("base") String base) {
        this(dateTime, location[0], location[1], base);
    }

    public UberPickDTO(LocalDateTime dateTime, float longitude, float latitude, String base) {
        this.dateTime = dateTime;
        this.location[0] = longitude;
        this.location[1] = latitude;
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

    @Override
    public String toString() {
        return "UberPickDTO{" +
                "dateTime=" + dateTime +
                ", location=" + Arrays.toString(location) +
                ", base='" + base + '\'' +
                '}';
    }
}
