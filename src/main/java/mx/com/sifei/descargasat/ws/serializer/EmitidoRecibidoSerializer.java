package mx.com.sifei.descargasat.ws.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import mx.com.sifei.descargasat.ws.models.ParametersDownloadCFDI.EmitidoRecibido;

public class EmitidoRecibidoSerializer extends JsonSerializer<EmitidoRecibido>{

	@Override
	public void serialize(EmitidoRecibido value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		gen.writeNumber(value.getValor());
	}

	 

}
