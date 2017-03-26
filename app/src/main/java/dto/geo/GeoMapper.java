package dto.geo;

import dto.UberPickDTO;

/**
 * Created by Adrian on 2017-03-25.
 */
public class GeoMapper {

    public UberPickGeoDTO map(UberPickDTO dto) {
        Point point = new Point(dto.getLocation());
        UberPickPropertiesDTO propertiesDTO = new UberPickPropertiesDTO(dto.getBase(), dto.getDateTime());
        return new UberPickGeoDTO(point, propertiesDTO);
    }
}
