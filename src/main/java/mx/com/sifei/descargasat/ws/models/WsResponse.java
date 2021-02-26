package mx.com.sifei.descargasat.ws.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class WsResponse {
	
	
	protected statusem status;
	
	public enum statusem{
		success, //ok
		fail,	//error en datos,error de logica, etc, es decir, fail sera cuando la operacion deseada no se pudo realizar.
		error,	//error interno del servidor
	}
	
 	private String message;
 	
 	
 	private String code;
 	/*
 	private String data;

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	*/

	 
	public statusem getStatus() {
		return status;
	}


	public void setStatus(statusem success) {
		this.status = success;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
 	
	public String toString() {
	//	return "status: "+this.status+" ,message:["+this.getMessage()+"] ,code: "+this.getCode()+" ,data: "+this.getData();
		return "status: "+this.status+" ,message:["+this.getMessage()+"] ,code: "+this.getCode();
	}
 	
	
	public boolean isStatusSuccess() {		
		return this.getStatus()==statusem.success;
	}
	public boolean isStatusFail() {
		return this.getStatus()==statusem.fail;
	}
	public boolean isStatusError() {
		return this.getStatus()==statusem.error;
	}
}
