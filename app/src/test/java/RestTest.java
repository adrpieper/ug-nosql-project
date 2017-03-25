import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Created by Adrian on 2017-03-25.
 */
public class RestTest {


    private Client client = Client.create();

    @Test
    public void putTest() {
        WebResource webResource = client
                .resource("http://localhost:9200/uber/pick/100");

        ClientResponse response = webResource.accept("application/json")
                .entity("{\"dateTime\":\"12/2/2013 12:14:05\",\"latitude\":10.2,\"longitude\":20.3,\"base\":\"B02512\"}")
                .post(ClientResponse.class);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

    }

    @Test
    public void getTest() throws IOException {

        WebResource webResource = client
                .resource("http://localhost:9200/uber/pick/_search");

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }


        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }
}
