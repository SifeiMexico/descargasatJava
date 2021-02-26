package mx.com.sifei.descargasat.ws.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest.TipoDescarga;

/**
 * 
 * @author Daniel J Hdz Fco.
 * This class deserialize the TipoDescarga values according to enumeration value.
 * this is because response returns an integer instead of string value.
 * 
 *
 */
public class TipoDescargaSerializer extends JsonDeserializer<TipoDescarga>{

	@Override
	public TipoDescarga deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return TipoDescarga.fromTypeCode(p.getValueAsInt());
	
	}
	
}
