package dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.UberPickHttpClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Adrian on 2017-03-28.
 */
public class ElasticSearchDTOStreamProvider {

    private ObjectMapper objectMapper = new ObjectMapper();
    private UberPickHttpClient uberPickHttpClient = new UberPickHttpClient();

    public Stream<UberPickDTO> get(String query) {
        try {
            JsonNode jsonNode = objectMapper
                    .readTree(uberPickHttpClient.get(query))
                    .get("hits")
                    .get("hits");
            return StreamSupport.stream(jsonNode.spliterator(), false)
                    .map(node -> node.get("_source"))
                    .map(this::map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UberPickDTO map(JsonNode jsonNode) {
        JsonNode location = jsonNode.get("location");
        return new UberPickDTO(
                LocalDateTime.parse(jsonNode.get("dateTime").asText()),
                (float) location.get(0).asDouble(),
                (float) location.get(1).asDouble(),
                jsonNode.get("base").asText()
        );
    }
}
