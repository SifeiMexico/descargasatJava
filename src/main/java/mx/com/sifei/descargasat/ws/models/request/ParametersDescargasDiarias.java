package mx.com.sifei.descargasat.ws.models.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonValue;

import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest.TipoDescarga;

public class ParametersDescargasDiarias {
	 public ParametersDescargasDiarias() {
         estadoDescarga = "";
     }
	  public String estadoDescarga;
	  
	  public TIPO_DESCARGA tipoDescarga;

      public METODO_DESCARGA metodoDescarga;

      public Date fechaInicial;

      public Date fechaFinal;
      
      public enum METODO_DESCARGA {
    	  PORTAL(1),OFICIAL(2);
    	 
    	  METODO_DESCARGA(int value){
    		  this.value=value;
    	  }
    	  private int value;
    	  public int getValue() {
    		  return this.value;
    	  }
    	  
      }
     
      public enum TIPO_DESCARGA {
    	  CFDI(1),META(2);
    	  TIPO_DESCARGA(int value){
    		  this.value=value;
    	  }
    	  private int value;
    	  public int getValue() {
    		  return this.value;
    	  }
    	  @JsonValue
    	    public int toValue() {
    	        return ordinal();
    	    }
    	  /*
    	  public static TIPO_DESCARGA fromTypeCode(final int typecode) {
  			switch(typecode) {
	  			case 1: return 1;
	  			case 2: return 2;
  			 
  			}
  			throw new IllegalArgumentException("Tipo invalido para TipoDescarga: " + typecode);
  		}*/
      }
	  
}
