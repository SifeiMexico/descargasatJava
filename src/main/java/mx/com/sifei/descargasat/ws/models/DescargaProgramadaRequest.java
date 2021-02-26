package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DescargaProgramadaRequest {
	//private String uuid;

	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaInicial;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechaFinal;

	private TipoDescarga tipodeDescargaDescarga;

	//private 
	
	
	
	
	public enum TipoDescarga {
		META(2), CFDI(1);
		private final int tipodescarga;

		TipoDescarga(int tipodescarga) {
			this.tipodescarga = tipodescarga;
		}

		int getTipoDescarga() {
			return this.tipodescarga;
		}
		public static TipoDescarga fromTypeCode(final int typecode) {
			switch(typecode) {
			case 1: return CFDI;
			case 2: return META;
			 
			}
			throw new IllegalArgumentException("Tipo invalido para TipoDescarga: " + typecode);
		}
	}
/*
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	*/
	@JsonProperty("FechaInicial")
	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	@JsonProperty("FechaFinal")
	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	@JsonProperty("TipoDeDescarga")
	public TipoDescarga getTipodeDescargaDescarga() {
		return tipodeDescargaDescarga;
	}

	public void setTipodeDescargaDescarga(TipoDescarga tipodeDescargaDescarga) {
		this.tipodeDescargaDescarga = tipodeDescargaDescarga;
	}

}
