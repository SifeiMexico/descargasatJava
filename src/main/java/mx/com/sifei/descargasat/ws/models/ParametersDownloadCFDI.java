package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.Converter;

import mx.com.sifei.descargasat.ws.serializer.EmitidoRecibidoSerializer;

public class ParametersDownloadCFDI {
	
	public ParametersDownloadCFDI() {
		//this.setEstadoComprobante(EstadoCFDI.Todos);
	}
	@JsonSerialize(using  =  EmitidoRecibidoSerializer.class)
	private EmitidoRecibido emitidoRecibido;
	
	//private EstadoCFDI estadoComprobante;
	
	private Date fechaFinal;
	
	private Date fechaInicial;
	
	private String efectoCFDI;
	public String getEfectoCFDI() {
		return efectoCFDI;
	}

	public void setEfectoCFDI(String efectoCFDI) {
		this.efectoCFDI = efectoCFDI;
	}

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

	 

	 
	
	public EmitidoRecibido getEmitidoRecibido() {
		return emitidoRecibido;
	}

	public void setEmitidoRecibido(EmitidoRecibido emitidoRecibidoSeleccionado) {
		this.emitidoRecibido = emitidoRecibidoSeleccionado;
	}
/*
	public EstadoCFDI getEstadoComprobante() {
		return estadoComprobante;
	}

	public void setEstadoComprobante(EstadoCFDI estadoComprobanteSeleccionado) {
		this.estadoComprobante = estadoComprobanteSeleccionado;
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
