package main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import http.ElasticSearchHttpClient;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Adrian on 2017-03-25.
 */
public class PutSchema {

    public static void main(String[] args) throws IOException {
        ElasticSearchHttpClient client = new ElasticSearchHttpClient();

        String body = fromFile("mapping.json");

        ClientResponse response = client.resource("/uber").entity(body).put(ClientResponse.class);

        System.out.println(response.getStatus());
    }

    public static String fromFile(String fileName) {
         try {
             InputStream inputStream = PutSchema.class.getResourceAsStream(fileName);
             ObjectMapper objectMapper = new ObjectMapper();
             JsonNode jsonNode = objectMapper.readTree(inputStream);
            return objectMapper.writeValueAsString(jsonNode);
        } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
