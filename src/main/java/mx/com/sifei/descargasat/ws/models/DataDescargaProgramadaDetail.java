package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

public class DataDescargaProgramadaDetail extends DataDescargaProgramada{
	private Date fechaOrigenProgramacion;
	
	private int cfdiDescargados;
	
	private Date ultimaEjecucion;
	
	//private String metodoDescarga;
	
	private String metodoDescargaString;
	
	
	
	private String rfcEmisor;
	private String rfcReceptor;
	
	private String tipoDeDescarga;
	
	public String getTipoDeDescarga() {
		return tipoDeDescarga;
	}
	public void setTipoDeDescarga(String tipoDeDescarga) {
		this.tipoDeDescarga = tipoDeDescarga;
	}
	public String getRfcReceptor() {
		return rfcReceptor;
	}
	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}
	public String getRfcEmisor() {
		return rfcEmisor;
	}
	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


	//protected String estado;
	
	public Date getFechaOrigenProgramacion() {
		return fechaOrigenProgramacion;
	}
	public void setFechaOrigenProgramacion(Date fechaOrigenProgramacion) {
		this.fechaOrigenProgramacion = fechaOrigenProgramacion;
	}
	/*
	private int cfdiNumeroTotal;
	public int getCfdiNumeroTotal() {
		return cfdiNumeroTotal;
	}
	public void setCfdiNumeroTotal(int cfdiNumeroTotal) {
		this.cfdiNumeroTotal = cfdiNumeroTotal;
	}
	*/
	public int getCfdiDescargados() {
		return cfdiDescargados;
	}
	public void setCfdiDescargados(int cfdiDescargados) {
		this.cfdiDescargados = cfdiDescargados;
	}
	public Date getUltimaEjecucion() {
		return ultimaEjecucion;
	}
	public void setUltimaEjecucion(Date ultimaEjecucion) {
		this.ultimaEjecucion = ultimaEjecucion;
	}
	/*
	public String getMetodoDescarga() {
		return metodoDescarga;
	}
	public void setMetodoDescarga(String metodoDescarga) {
		this.metodoDescarga = metodoDescarga;
	}
	*/
	public String getMetodoDescargaString() {
		return metodoDescargaString;
	}
	public void setMetodoDescargaString(String metodoDescargaString) {
		this.metodoDescargaString = metodoDescargaString;
	}
	
	//private String wsSATReceptorEstatus;
	
		//private String wsSATEmisorEstatus;
		
		//private int numeroCfdiEmitidos;
		//private int numeroCfdiRecibidos;
	/*
	public String getWsSATReceptorEstatus() {
		return wsSATReceptorEstatus;
	}
	public void setWsSATReceptorEstatus(String wsSATReceptorEstatus) {
		this.wsSATReceptorEstatus = wsSATReceptorEstatus;
	}
	public String getWsSATEmisorEstatus() {
		return wsSATEmisorEstatus;
	}
	public void setWsSATEmisorEstatus(String wsSATEmisorEstatus) {
		this.wsSATEmisorEstatus = wsSATEmisorEstatus;
	}
	public int getNumeroCfdiEmitidos() {
		return numeroCfdiEmitidos;
	}
	public void setNumeroCfdiEmitidos(int numeroCfdiEmitidos) {
		this.numeroCfdiEmitidos = numeroCfdiEmitidos;
	}
	public int getNumeroCfdiRecibidos() {
		return numeroCfdiRecibidos;
	}
	public void setNumeroCfdiRecibidos(int numeroCfdiRecibidos) {
		this.numeroCfdiRecibidos = numeroCfdiRecibidos;
	}
	*/
	
	public String toString() {
		return super.toString()+"data: "+
				"fecha origen"+getCfdiDescargados();
	}
	
	
}
