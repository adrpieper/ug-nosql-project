package dto.geo;

import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
public class GeoJsonDTO {

    private List<UberPickGeoDTO> features;

    public GeoJsonDTO(List<UberPickGeoDTO> features) {
        this.features = features;
    }

    public String getType() {
        return "FeatureCollection";
    }

    public List<UberPickGeoDTO> getFeatures() {
        return features;
    }
}
