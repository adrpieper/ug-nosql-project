package dto.geo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ElasticSearchDTOStreamProvider;
import dto.UberPickDTO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Adrian on 2017-03-25.
 */
public class GeoMapper {

    public UberPickGeoDTO map(UberPickDTO dto) {
        Point point = new Point(dto.getLocation());
        UberPickPropertiesDTO propertiesDTO = new UberPickPropertiesDTO(dto.getBase(), dto.getDateTime());
        return new UberPickGeoDTO(point, propertiesDTO);
    }


    public void map(Stream<UberPickDTO> in, OutputStream out) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<UberPickGeoDTO> collect = in
                .map(this::map)
                .collect(Collectors.toList());

        GeoJsonDTO geoJsonDTO = new GeoJsonDTO(collect);
        objectMapper.writeValue(out, geoJsonDTO);
    }
}
