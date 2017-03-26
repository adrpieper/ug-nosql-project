package dto.geo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Adrian on 2017-03-25.
 */
public class UberPickGeoDTO {

    private final Point geometry;
    @JsonSerialize(using = PropertiesSerializator.class)
    private final UberPickPropertiesDTO properties;

    public UberPickGeoDTO(Point geometry, UberPickPropertiesDTO properties) {
        this.geometry = geometry;
        this.properties = properties;
    }

    public String getType() {
        return "Feature";
    }

    public Point getGeometry() {
        return geometry;
    }

    public UberPickPropertiesDTO getProperties() {
        return properties;
    }
}
