package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UberPickDTO;
import dto.UberPickParser;
import dto.geo.GeoJsonDTO;
import dto.geo.GeoMapper;
import dto.geo.UberPickGeoDTO;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ToGeo {

    private UberPickParser parser = new UberPickParser();
    private GeoMapper mapper = new GeoMapper();
    private ObjectMapper objectMapper = new ObjectMapper();

    public void toGeo(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        List<UberPickGeoDTO> geoDTOS = new ArrayList<>();
        while (scanner.hasNext()) {
            try {
                UberPickDTO dto = parser.parse(scanner.nextLine());
                UberPickGeoDTO geoDTO = mapper.map(dto);
                geoDTOS.add(geoDTO);
            }catch (Exception e) {}
        }
        try {
            GeoJsonDTO geoJsonDTO = new GeoJsonDTO(geoDTOS);
            out.println(objectMapper.writeValueAsString(geoJsonDTO));
        } catch (JsonProcessingException e) {
            new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ToGeo().toGeo(System.in, System.out);
    }
}
