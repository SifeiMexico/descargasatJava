package mx.com.sifei.descargasat.ws.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParametersEsteblecerConfiguracion {
	@JsonProperty("metodoDescarga")
	public MetodoDescarga MetodoDescarga;

	@JsonProperty("horasEsperaWs")
	public int HorasEsperaWs;

	@JsonProperty("horasEsperaPortal")
	public int HorasEsperaPortal;
	
	
	public enum MetodoDescarga{
		WS("WS"),PORTAL("PORTAL");
		
		private String value;
		private MetodoDescarga(String value) {
			this.value=value;
		}
		public String getValue() {
			 return value;
		 }
	}
}
