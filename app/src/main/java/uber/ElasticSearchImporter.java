package uber;

import dto.UberPickDTO;
import dto.UberPickParser;
import http.UberPickHttpClient;
import util.StreamUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static util.StreamUtils.dtos;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ElasticSearchImporter {

    private UberPickHttpClient client = new UberPickHttpClient();

    public void sendToDb(InputStream is, int maxPacketSize) {
        StreamUtils.forEach(dtos(is), client::post, maxPacketSize);
    }
}
