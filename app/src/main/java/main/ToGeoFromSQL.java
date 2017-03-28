package main;

import dto.ElasticSearchDTOStreamProvider;
import dto.geo.GeoMapper;
import sql.SqlClient;

import java.io.IOException;

import static main.AddMapping.fromFile;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ToGeoFromSQL {

    public static void main(String[] args) throws IOException {

        GeoMapper mapper = new GeoMapper();
        SqlClient sqlClient = new SqlClient();
        mapper.map(sqlClient.select("SELECT * FROM pick WHERE longitude BETWEEN -73.995864 AND -73.985357 AND latitude BETWEEN 40.741552 AND 40.749692").stream(), System.out);
    }
}
