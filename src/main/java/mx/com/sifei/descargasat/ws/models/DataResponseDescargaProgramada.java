package mx.com.sifei.descargasat.ws.models;

public class DataResponseDescargaProgramada implements IData {
	private String resultado;
	
	private String[] errores;
	
	private String[] exitosos;
	
	private String[] repetidos;
	
	private int diasyaprogramados;
	
	

	private int diasTotalesDeDescarga;
	
	private int totalDiasNuevosProgramados;
	
	private String tipoDescargaName;
	

	
	public String toString() {
		return String.format("resultado: %s , dias previos: %s , total dias de descarga:%s , total nuevos Dias programados: %s", this.resultado,this.diasyaprogramados,this.diasTotalesDeDescarga,this.totalDiasNuevosProgramados);
		
	
		
	}
	
	public int getDiasyaprogramados() {
		return diasyaprogramados;
	}

	public void setDiasyaprogramados(int diasyaprogramados) {
		this.diasyaprogramados = diasyaprogramados;
	}

	public String[] getRepetidos() {
		return repetidos;
	}

	public void setRepetidos(String[] repetidos) {
		this.repetidos = repetidos;
	}
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String[] getErrores() {
		return errores;
	}

	public void setErrores(String[] errores) {
		this.errores = errores;
	}

	public String[] getExitosos() {
		return exitosos;
	}

	public void setExitosos(String[] exitosos) {
		this.exitosos = exitosos;
	}

	public int getDiasTotalesDeDescarga() {
		return diasTotalesDeDescarga;
	}

	public void setDiasTotalesDeDescarga(int diasTotalesDeDescarga) {
		this.diasTotalesDeDescarga = diasTotalesDeDescarga;
	}

	public int getTotalDiasNuevosProgramados() {
		return totalDiasNuevosProgramados;
	}

	public void setTotalDiasNuevosProgramados(int totalDiasNuevosProgramados) {
		this.totalDiasNuevosProgramados = totalDiasNuevosProgramados;
	}

	public String getTipoDescargaName() {
		return tipoDescargaName;
	}

	public void setTipoDescargaName(String tipoDescargaName) {
		this.tipoDescargaName = tipoDescargaName;
	}
	
	

	
	
}
