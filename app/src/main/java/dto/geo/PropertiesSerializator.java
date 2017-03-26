package dto.geo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Adrian on 2017-03-25.
 */
public class PropertiesSerializator extends JsonSerializer<UberPickPropertiesDTO> {
    @Override
    public void serialize(UberPickPropertiesDTO dto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("marker-size","medium");
        jsonGenerator.writeStringField("marker-symbol","airport");
        jsonGenerator.writeStringField("title",dto.getBase() + " " + dto.getDateTime().toString());
        jsonGenerator.writeEndObject();
    }
}
