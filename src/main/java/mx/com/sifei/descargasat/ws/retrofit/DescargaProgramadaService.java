package mx.com.sifei.descargasat.ws.retrofit;

import java.util.List;

import mx.com.sifei.descargasat.ws.models.DataDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.DataDescargaProgramadaDetail;
import mx.com.sifei.descargasat.ws.models.DataResponseDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;
import mx.com.sifei.descargasat.ws.models.request.ParametersDescargasDiarias;
//import mx.com.sifei.descargasat.ws.models.programarDescarga.WsResponseProgramarDescarga;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DescargaProgramadaService {
	@POST("/api/v2/descargasatsifei/DescargaProgramada")
	Call<WsResponseMaster<DataResponseDescargaProgramada>> crearDescarga(@Body DescargaProgramadaRequest DescargaProgramadaRequest);
	
	//@GET("/api/v2/descargasatsifei/DescargaProgramada")
	@POST("/api/v2/descargasatsifei/DescargaProgramadas/query")
     Call<WsResponseMaster<List<DataDescargaProgramada>>> ObtenerDescargasProgramadasDiarias(@Body ParametersDescargasDiarias para);
	
	@GET("/api/v2/descargasatsifei/DescargaProgramada/{uuid}")
    Call<WsResponseMaster<DataDescargaProgramadaDetail>> ObtenerDescargasProgramadasDetalle(@Path("uuid") String uuid);
	
	@POST("/api/v2/descargasatsifei/DescargaProgramada/{uuid}")
    Call<WsResponseMaster<String>> ReactivarDescargaProgramada(@Path("uuid") String uuid);
}
