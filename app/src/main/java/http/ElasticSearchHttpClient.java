package http;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Adrian on 2017-03-25.
 */
public class ElasticSearchHttpClient {

    private Client client = Client.create();
    private final String url = "http://localhost:9200";

    public WebResource.Builder resource(String path){
        return client.resource(url + path).accept("application/json");
    }
}
