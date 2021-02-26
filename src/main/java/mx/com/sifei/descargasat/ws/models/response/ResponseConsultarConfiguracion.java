package mx.com.sifei.descargasat.ws.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseConsultarConfiguracion {

	@JsonProperty("metodoDescarga")
	public String MetodoDescarga;

	@JsonProperty("horasEsperaWs")
	public int HorasEsperaWs;

	@JsonProperty("horasEsperaPortal")
	public int HorasEsperaPortal;
	@JsonProperty("mensaje")
	public String Mensaje;
}
