package mx.com.sifei.descargasat.ws;

import java.io.IOException;
import java.text.MessageFormat;

 

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import mx.com.sifei.descargasat.ws.CFDIinfo.WSResponseCFDIInfo;
import mx.com.sifei.descargasat.ws.CFDIinfo.WsCFDIInfo;
import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest;
import mx.com.sifei.descargasat.ws.models.WsResponse;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;

public class ClientDescargaSAT extends Client {

	/**
	 * Created on 11/24/15.
	 */
	public static class Builder {

		private String token;
		private String host;
		private int port;

		public Builder setToken(String token) {
			this.token = token;
			return this;
		}

		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		public ClientDescargaSAT build() {
			return new ClientDescargaSAT();
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	private ClientDescargaSAT() {

	}

	private WsResponse response;
	private String strResponse = null;

	/**
	 * Ultimo error al realizar la peticion
	 */
	private Exception lastError;

	public String PROGRAMAR_DESCARGAR = "/api/v2/descargasatsifei/DescargaProgramada";

	
	public Exception getLastError() {
		return lastError;
	}

	public void setLastError(Exception lastError) {
		this.lastError = lastError;
	}

	public void Mapear() throws JsonParseException, JsonMappingException, IOException {
		if (null == this.strResponse)
			return;
		ObjectMapper mapper = new ObjectMapper();
	//	response = mapper.readValue(strResponse, WsResponseProgramarDescarga.class);
	}

	public <T> void MapearCFDIInfo(Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		if (null == this.strResponse)
			return;
		ObjectMapper mapper = new ObjectMapper();
		
		 
		response = (WsResponse) mapper.readValue(strResponse, valueType);
	}
}
