package mx.com.sifei.descargasat.ws.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class StringAsNullDeserializer  extends JsonDeserializer<String>{

	@Override
	public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		JsonNode node = p.readValueAsTree();
		
        if (node.get("data").asText().isEmpty()) {
            return null;
        }
        
        return node.toString();
	}

}
