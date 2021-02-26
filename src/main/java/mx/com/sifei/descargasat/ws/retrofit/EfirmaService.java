package mx.com.sifei.descargasat.ws.retrofit;

import mx.com.sifei.descargasat.ws.models.DataResponseDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;
import mx.com.sifei.descargasat.ws.models.request.ParameterSubirEFirma;
import mx.com.sifei.descargasat.ws.models.response.DataEFirmaResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EfirmaService {
	@POST("/api/v2/descargasatsifei/certificado")
	Call<WsResponseMaster<DataEFirmaResponse>> subirEfirma(@Body ParameterSubirEFirma DescargaProgramadaRequest);
}
