package mx.com.sifei.descargasat.ws.models;
/**	
 * 
 * @author Daniel Hernandez daniel.hernandez.fco@gmail.com 
 *  Implementation for Jsend
 * @param <T>
 */
public class WsResponseMaster<T> extends WsResponse {
	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
