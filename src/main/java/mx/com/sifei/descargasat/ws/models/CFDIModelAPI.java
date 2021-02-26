package mx.com.sifei.descargasat.ws.models;
import java.math.BigDecimal; 
import java.util.Date;

public class CFDIModelAPI {
    public String uuid;
	    public String rfcEmisor;
	    public String rfcReceptor;
	    public Date fechaDescarga;
	    public String total;
	    public Date fechaEmision;
	    public String pacquecertifico;
	    public Date fechaCertificacion;
	    public Boolean  disponibleXML;
	    public Boolean  disponibleMETA;
	    public String solicitadaMetodo;
	    public String estado;
		public String efecto;
		

		public boolean EsIngreso(){
			return this.efecto.equals("I")||this.efecto.equalsIgnoreCase("Ingreso");
		}
		public boolean EsNomina(){
			return this.efecto.equals("N")||this.efecto.equalsIgnoreCase("Nómina")||this.efecto.equalsIgnoreCase("Nomina");
		}
		public boolean EsTraslado(){
			return this.efecto.equals("T")||this.efecto.equalsIgnoreCase("Traslado");
		}
		public boolean EsPago(){
			return this.efecto.equals("P")||this.efecto.equalsIgnoreCase("Pago");
		}
		public boolean EsEgreso(){
			return this.efecto.equals("E")||this.efecto.equalsIgnoreCase("Egreso");
		}
		public boolean EsEstadoVigente(){
			return this.estado.equals("1")||this.estado.equalsIgnoreCase("Vigente");
		}
		public boolean EsEstadoCancelado(){
			return this.estado.equals("0")||this.estado.equalsIgnoreCase("Cancelado");
		}
		

	    public boolean   isSolicitadaPorMeta(){
	           return  this.solicitadaMetodo.equalsIgnoreCase("META");
	    }
	    public  boolean isSolicitadaPorDesc(){
	        return   this.solicitadaMetodo.equalsIgnoreCase("DESC");
	    }
	    public  boolean isSolicitadaPorBOTH(){
	        return  this.solicitadaMetodo.equalsIgnoreCase("BOTH");
	    }

}
