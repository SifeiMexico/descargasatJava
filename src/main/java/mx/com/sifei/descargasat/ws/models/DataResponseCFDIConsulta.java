package mx.com.sifei.descargasat.ws.models;

import java.util.List;

public class DataResponseCFDIConsulta {
	public List<CFDIModelAPI> cfdi;
	
	public int total;
	public int count;
	public List<CFDIModelAPI> getCfdi() {
		return cfdi;
	}
	public void setCfdi(List<CFDIModelAPI> cfdi) {
		this.cfdi = cfdi;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
