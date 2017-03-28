package main;

import dto.ElasticSearchDTOStreamProvider;
import dto.geo.GeoMapper;

import java.io.IOException;

import static main.AddMapping.fromFile;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ToGeoFromES {

    public static void main(String[] args) throws IOException {

        GeoMapper mapper = new GeoMapper();

        ElasticSearchDTOStreamProvider streamProvider = new ElasticSearchDTOStreamProvider();
        mapper.map(streamProvider.get(fromFile("query.json")), System.out);
    }
}
