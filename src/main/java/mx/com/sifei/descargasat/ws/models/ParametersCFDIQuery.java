package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import mx.com.sifei.descargasat.ws.models.ParametersDownloadCFDI.EmitidoRecibido;
import mx.com.sifei.descargasat.ws.models.ParametersDownloadCFDI.EstadoCFDI;
import mx.com.sifei.descargasat.ws.serializer.EmitidoRecibidoSerializer;

public class ParametersCFDIQuery {
	public ParametersCFDIQuery() {
		//this.setEstadoComprobanteSeleccionado(EstadoCFDI.Todos);
	}
	//@JsonSerialize(using  =  EmitidoRecibidoSerializer.class)
	//private EmitidoRecibido emitidoRecibidoSeleccionado;
	
	//private EstadoCFDI estadoComprobanteSeleccionado;
	
	private Date fechaFinal;
	
	private Date fechaInicial;
	/*
	public enum EstadoCFDI {
		Vigente(1),Cancelado(0),Todos(-1);
		private int valor;
		EstadoCFDI(int valor){
			this.valor=valor;
		}
		public int gerValor() {
			return this.valor;
		}
	}
	*/
	/*
	public enum EmitidoRecibido{
		Todos(-1), Emitidos(1),Recibido(2);
		private int valor;
		EmitidoRecibido(int valor){
			this.valor=valor;
		}
		public int getValor() {
			return this.valor;
		}
	}
	*/
	
	
	
	
	private String rfcEmisor;
	
	private String rfcReceptor;

	private String uuidCFDI; 

	private String efectoCFDI;
	 
	private int limit;
	
	private int offset;
	
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getEfectoCFDI() {
		return efectoCFDI;
	}

	public void setEfectoCFDI(String efectoCFDI) {
		this.efectoCFDI = efectoCFDI;
	}

	public String getRfcEmisor() {
		return rfcEmisor;
	}

	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}

	public String getRfcReceptor() {
		return rfcReceptor;
	}

	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}

	public String getUuidCFDI() {
		return uuidCFDI;
	}

	public void setUuidCFDI(String uuidCFDI) {
		this.uuidCFDI = uuidCFDI;
	}
	/*
	public EmitidoRecibido getEmitidoRecibidoSeleccionado() {
		return emitidoRecibidoSeleccionado;
	}

	public void setEmitidoRecibidoSeleccionado(EmitidoRecibido emitidoRecibidoSeleccionado) {
		this.emitidoRecibidoSeleccionado = emitidoRecibidoSeleccionado;
	}

	public EstadoCFDI getEstadoComprobanteSeleccionado() {
		return estadoComprobanteSeleccionado;
	}

	public void setEstadoComprobanteSeleccionado(EstadoCFDI estadoComprobanteSeleccionado) {
		this.estadoComprobanteSeleccionado = estadoComprobanteSeleccionado;
	}
	*/
	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
}
