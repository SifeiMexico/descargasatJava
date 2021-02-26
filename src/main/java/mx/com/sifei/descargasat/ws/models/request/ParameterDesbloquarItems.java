package mx.com.sifei.descargasat.ws.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParameterDesbloquarItems {
	 @JsonProperty("TipoDesbloqueo")
	  public TipoDesbloqueo tipoDesbloqueo;
	 
	 
	 public ParameterDesbloquarItems() {
		 
		 this.tipoDesbloqueo=TipoDesbloqueo.CFDI;
	 }
	 
	 public enum TipoDesbloqueo {
		 CFDI("CFDI"),META("META");
		 private String value;
		 TipoDesbloqueo(String tipoDesbloqueo){
			 this.value=tipoDesbloqueo;
		 }
		 public String getValue() {
			 return value;
		 }
		 
	 }
}
