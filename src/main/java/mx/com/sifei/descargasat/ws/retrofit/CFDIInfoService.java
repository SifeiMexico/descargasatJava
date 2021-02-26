package mx.com.sifei.descargasat.ws.retrofit;

import java.util.List;

import mx.com.sifei.descargasat.ws.CFDIinfo.WsCFDIInfo;
import mx.com.sifei.descargasat.ws.models.ParametersDownloadCFDI;
import mx.com.sifei.descargasat.ws.models.CFDIModelAPI;
import mx.com.sifei.descargasat.ws.models.DataResponseCFDIConsulta;
import mx.com.sifei.descargasat.ws.models.ParametersCFDIQuery;
//import mx.com.sifei.descargasat.ws.models.SimpleWsReponse;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;
import mx.com.sifei.descargasat.ws.models.request.ParameterDesbloquarItems;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface CFDIInfoService {
	
	@GET("/api/v2/descargasatsifei/cfdi/query/{uuid}")
	public Call<WsResponseMaster<CFDIModelAPI>> obtenerCFDI(@Path("uuid") String uuid);
	//public Call<WsResponseMaster<WsCFDIInfo>> obtenerCFDI(@Path("uuid") String uuid);
	
	@GET("/api/v2/descargasatsifei/cfdi/download/{uuid}")
	public Call<WsResponseMaster<String>> cfdiDownload(@Path("uuid") String uuid);
	
	
//@GET("/api/v2/descargasatsifei/cfdi/uuid")
 //	public Call<WsResponseMaster<List<String>>> obtenerUUIDsCFDIDisponibles();
	 
	
	@POST("/api/v2/descargasatsifei/cfdi/download")
	Call<WsResponseMaster<String>> downloadCfdis(@Body ParametersDownloadCFDI ConsultarCFDIRequest);
	
	@GET("/api/v2/descargasatsifei/cfdi/exist/{uuid}")
	Call<WsResponseMaster<Boolean>> existeCfdi(@Path("uuid") String uuid);
	//@POST("/api/v2/descargasatsifei/cfdi/query")
	//public Call<> consultarCFDIPorParametros(@Body ConsultarCFDIRequest ConsultarCFDIRequest);
	
	@POST("/api/v2/descargasatsifei/cfdi/query")//buscar
	public Call<WsResponseMaster<DataResponseCFDIConsulta>> consultarCFDI(@Body  ParametersCFDIQuery $params);
	
	
	@POST("/api/v2/descargasatsifei/cfdi/DesbloquearCFDIAPI")//buscar
	public Call<WsResponseMaster<Integer>> desbloquear(@Body  ParameterDesbloquarItems params);
	
}
