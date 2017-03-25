package http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dto.UberPickDTO;

import java.util.List;

/**
 * Created by Adrian on 2017-03-25.
 */
public class BulkGenerator {
    private final ObjectWriter writer = new ObjectMapper().writer();

    public String generate(List<UberPickDTO> uberPickDtos, long id) {
        StringBuilder builder = new StringBuilder();
        for (UberPickDTO uberPickDto : uberPickDtos) {
            builder.append("{ \"create\": { \"_id\": "+(id++)+" } }\n");
            try {
                builder.append(writer.writeValueAsString(uberPickDto));
                builder.append('\n');
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return builder.toString();
    }
}
