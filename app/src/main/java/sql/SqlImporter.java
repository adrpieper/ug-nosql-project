package sql;

import util.StreamUtils;

import java.io.InputStream;

/**
 * Created by Adrian on 2017-03-26.
 */
public class SqlImporter {

    private SqlClient sqlClient = new SqlClient();

    public void importToDb(InputStream in, int packetSize){
        StreamUtils.forEach(StreamUtils.dtos(in), sqlClient::insert, packetSize);
    }
}
