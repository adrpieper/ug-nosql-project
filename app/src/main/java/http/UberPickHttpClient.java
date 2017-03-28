package http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import dto.UberPickDTO;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
public class UberPickHttpClient {

    private ElasticSearchHttpClient elasticSearchHttpClient = new ElasticSearchHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    private BulkGenerator bulkGenerator = new BulkGenerator();
    private final String path = "/uber/pick";
    private long id = 1L;

    public void put(UberPickDTO uberPickDto) {

        ClientResponse response;
        try {
            response = elasticSearchHttpClient.resource(path + "/" + id++)
                    .entity(objectMapper.writeValueAsString(uberPickDto))
                    .post(ClientResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
    }

    public void post(List<UberPickDTO> uberPickDto) {
        ClientResponse response;

        response = elasticSearchHttpClient.resource(path + "/_bulk")
                    .entity(bulkGenerator.generate(uberPickDto, id))
                    .post(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        id+= uberPickDto.size();
    }

    public InputStream get(String query) {

        ClientResponse response;

        response = elasticSearchHttpClient.resource("/uber/_search")
                .entity(query)
                .post(ClientResponse.class);

        /*if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }*/

        return response.getEntityInputStream();
    }
}
