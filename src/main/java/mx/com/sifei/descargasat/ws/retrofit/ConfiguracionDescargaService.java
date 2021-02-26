package mx.com.sifei.descargasat.ws.retrofit;

import java.util.List;

import mx.com.sifei.descargasat.ws.models.DataDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;
import mx.com.sifei.descargasat.ws.models.request.ParametersDescargasDiarias;
import mx.com.sifei.descargasat.ws.models.request.ParametersEsteblecerConfiguracion;
import mx.com.sifei.descargasat.ws.models.response.ResponseConsultarConfiguracion;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ConfiguracionDescargaService {
	@POST("/api/v2/descargasatsifei/configuracion/query")
    Call<WsResponseMaster<ResponseConsultarConfiguracion>> consultarConfiguracion();
	
	@POST("/api/v2/descargasatsifei/configuracion/metodoDescarga")
    Call<WsResponseMaster<ResponseConsultarConfiguracion>> EstablecerMetodoDescarga(@Body ParametersEsteblecerConfiguracion para);
	
	@POST("/api/v2/descargasatsifei/configuracion/horasEspera")
    Call<WsResponseMaster<ResponseConsultarConfiguracion>> EstablecerHorasEspera(@Body ParametersEsteblecerConfiguracion para);	
}
