package mx.com.sifei.descargasat.ws.CFDIinfo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WsCFDIInfo {
	protected String uuid;
	
	protected String rfcEmisor;
	
	protected String rfcReceptor;
	
	protected Date fechaDescarga;
	
	protected Date fechaPago;
	
	protected boolean conciliado;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	protected Date fechaEmision;
	
	protected boolean emitida;
	
	protected boolean estadoCFDI;
	
	protected String efectoComprobante;
	
	protected String totalCFDI;
	
	protected String pacqueCertifico;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	protected Date fechaCertificacion;
	
	
	//pendientes de usar
	protected String complementoPago;
	
	protected String descargaUuid;
	
	protected Boolean disponible;
	
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	@JsonProperty("descarga_uuid")
	public String getDescargaUuid() {
		return descargaUuid;
	}
	@JsonProperty("descarga_uuid")
	public void setDescargaUuid(String descargaUuid) {
		this.descargaUuid = descargaUuid;
	}
	@JsonProperty("complemento_pago")
	public String getComplementoPago() {
		return complementoPago;
	}
	@JsonProperty("complemento_pago")
	public void setComplementoPago(String complementoPago) {
		this.complementoPago = complementoPago;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	protected boolean descargable;
	@JsonProperty("rfc_emisor")
	public String getRfcEmisor() {
		return rfcEmisor;
	}
	@JsonProperty("rfc_emisor")
	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}
	@JsonProperty("rfc_receptor")
	public String getRfcReceptor() {
		return rfcReceptor;
	}
	@JsonProperty("rfc_receptor")
	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}
	@JsonProperty("fecha_descarga")
	public Date getFechaDescarga() {
		return fechaDescarga;
	}
	@JsonProperty("fecha_descarga")
	public void setFechaDescarga(Date fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}
	@JsonProperty("fecha_pago")
	public Date getFechaPago() {
		return fechaPago;
	}
	@JsonProperty("fecha_pago")
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isConciliado() {
		return conciliado;
	}

	public void setConciliado(boolean conciliado) {
		this.conciliado = conciliado;
	}
	@JsonProperty("fecha_emision")
	public Date getFechaEmision() {
		return fechaEmision;
	}
	@JsonProperty("fecha_emision")
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public boolean isEmitida() {
		return emitida;
	}

	public void setEmitida(boolean emitida) {
		this.emitida = emitida;
	}
	@JsonProperty("estado_cfdi")
	public boolean getEstadoCFDI() {
		return estadoCFDI;
	}
	@JsonProperty("estado_cfdi")
	public void setEstadoCFDI(boolean estadoCFDI) {
		this.estadoCFDI = estadoCFDI;
	}
	@JsonProperty("efecto_comprobante")
	public String getEfectoComprobante() {
		return efectoComprobante;
	}
	@JsonProperty("efecto_comprobante")
	public void setEfectoComprobante(String efectoComprobante) {
		this.efectoComprobante = efectoComprobante;
	}
	@JsonProperty("total_cfdi")
	public String getTotalCFDI() {
		return totalCFDI;
	}
	@JsonProperty("total_cfdi")
	public void setTotalCFDI(String totalCFDI) {
		this.totalCFDI = totalCFDI;
	}
	@JsonProperty("pacquecertifico")
	public String getPacqueCertifico() {
		return pacqueCertifico;
	}
	@JsonProperty("pacquecertifico")
	public void setPacqueCertifico(String pacqueCertifico) {
		this.pacqueCertifico = pacqueCertifico;
	}
	@JsonProperty("fechacertificacion")
	public Date getFechaCertificacion() {
		return fechaCertificacion;
	}
	@JsonProperty("fechacertificacion")
	public void setFechaCertificacion(Date fechaCertificacion) {
		this.fechaCertificacion = fechaCertificacion;
	}

	public boolean isDescargable() {
		return descargable;
	}

	public void setDescargable(boolean descargable) {
		this.descargable = descargable;
	}
	
	public String toString() {
		return this.uuid;
	}
	
}
