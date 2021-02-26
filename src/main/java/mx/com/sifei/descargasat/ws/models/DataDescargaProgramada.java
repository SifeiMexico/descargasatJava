package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest.TipoDescarga;
import mx.com.sifei.descargasat.ws.serializer.TipoDescargaSerializer;

public class DataDescargaProgramada extends DescargaProgramadaBasic{
		
	protected String estado;
	

	@JsonDeserialize(using = TipoDescargaSerializer.class)
	protected TipoDescarga tipoDescarga;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getUuid() {
		return uuid;
	}
	@JsonProperty("fechaInicial")
	public Date getFechaInicial() {
		return fechaInicial;
	}
	@JsonProperty("fechaFinal")
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@JsonProperty("fechaInicial")
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	@JsonProperty("fechaFinal")
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	} 
	@JsonProperty("tipoDescarga")
	public TipoDescarga getTipoDescarga() {
		return tipoDescarga;
	}
	@JsonProperty("tipoDescarga")
	public void setTipoDescarga(TipoDescarga tipoDescarga) {
		this.tipoDescarga = tipoDescarga;
	}
	
	private int metodoDescarga;
	
	@JsonProperty("metodoDescarga")
	public int getMetodoDescarga() {
		return metodoDescarga;
	}
	@JsonProperty("metodoDescarga")
	public void setMetodoDescarga(int metodoDescarga) {
		this.metodoDescarga = metodoDescarga;
	}

	public static final String ESTADO_ESPERANDO = "ESPERANDO";    
	public static final String ESTADO_EN_PROCESO = "EN PROCESO"; //aplica cuando esta en proceso la descargaprogramada
	public static final String ESTADO_COMPLETADO = "COMPLETADO"; //aplica cuando ha sido correcta la descarga programada
	public static final String ESTADO_ERROR = "ERROR";
	public static final String ESTADO_INCOMPLETO="INCOMPLETA";
	public static final String ESTADO_BLOQUEADO="BLOQUEADA";
	public static final String ESTADO_ALL="BLOQUEADA"; //no es un estado, implica que la consulta no incluira este campo
	
	
	public boolean isEstadoEsperando() {
		return this.estado.equals(ESTADO_ESPERANDO);
	}
	public boolean isEstadoEnProceso() {
		return this.estado.equals(ESTADO_EN_PROCESO);
	}
	public boolean isEstadoCompletado() {
		return this.estado.equals(ESTADO_COMPLETADO);
	}
	public boolean isEstadoERROR() {
		return this.estado.equals(ESTADO_ERROR);
	}
	public boolean isEstadoIncompleto() {
		return this.estado.equals(ESTADO_INCOMPLETO);
	}
	public boolean isEstadoBloqueado() {
		return this.estado.equals(ESTADO_BLOQUEADO);
	}
	
	
}
