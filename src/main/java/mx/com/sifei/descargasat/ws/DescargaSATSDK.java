package mx.com.sifei.descargasat.ws;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.sifei.descargasat.ws.CFDIinfo.WsCFDIInfo;
import mx.com.sifei.descargasat.ws.models.ParametersDownloadCFDI;
import mx.com.sifei.descargasat.ws.models.CFDIModelAPI;
import mx.com.sifei.descargasat.ws.models.DataDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.DataDescargaProgramadaDetail;
import mx.com.sifei.descargasat.ws.models.DataResponseCFDIConsulta;
import mx.com.sifei.descargasat.ws.models.DataResponseDescargaProgramada;
import mx.com.sifei.descargasat.ws.models.DescargaProgramadaRequest;
import mx.com.sifei.descargasat.ws.models.ParametersCFDIQuery;
import mx.com.sifei.descargasat.ws.models.WsResponseMaster;
import mx.com.sifei.descargasat.ws.models.request.ParameterDesbloquarItems;
import mx.com.sifei.descargasat.ws.models.request.ParameterSubirEFirma;
import mx.com.sifei.descargasat.ws.models.request.ParametersDescargasDiarias;
import mx.com.sifei.descargasat.ws.models.request.ParametersEsteblecerConfiguracion;
import mx.com.sifei.descargasat.ws.models.response.DataEFirmaResponse;
import mx.com.sifei.descargasat.ws.models.response.ResponseConsultarConfiguracion;
import mx.com.sifei.descargasat.ws.retrofit.CFDIInfoService;
import mx.com.sifei.descargasat.ws.retrofit.ConfiguracionDescargaService;
import mx.com.sifei.descargasat.ws.retrofit.DescargaProgramadaService;
import mx.com.sifei.descargasat.ws.retrofit.EfirmaService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**	
 * 
 * @author Daniel  Hernandez Fco <daniel.hernandez.job@gmail.com>
 * 
 * This SDK uses jackson and retrofit to map and do http operations.
 *  @version 1.1
 */
public class DescargaSATSDK {
	static final String BASE_URL_DEVELOPMENT = "http://localhost:8181";
	static final String BASE_URL_DEVELOPMENT_MIDDLE = "http://localhost:8181";
	static public final String BASE_PRODUCTION_URL="https://descargasat.sifei.com.mx";
	
	private String url;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public DescargaSATSDK() {		
		setUrl(BASE_URL_DEVELOPMENT);//por defecto sera este
	}
	protected String token;
	protected ObjectMapper mapper;
	public ObjectMapper getMapper() {
		return mapper;
	}
	
	protected boolean log;
	public boolean isLog() {
		return log;
	}
	public void setLog(boolean log) {
		this.log = log;
	}
	/**
	 * Si estableces este valor deberas implementar tu propio mapper,
	 * por defecto se usara un mapper que funciona de forma correcta con el API.
	 * @param mapper
	 */
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	public boolean hasMapper() {
		return null!=this.mapper;
	}
	public String getToken() {
		return token;
	}
	
	
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public  Response<WsResponseMaster<CFDIModelAPI>> ObtenerCFDIPorUUID(String uuid) throws IOException {
		if(null==this.token)
			throw new IllegalArgumentException("token no debe ser null para consumir el API");
		Retrofit retrofit = getRetrofit();

		CFDIInfoService service = retrofit.create(CFDIInfoService.class);
		Call<WsResponseMaster<CFDIModelAPI>> repo = service.obtenerCFDI(uuid);
		Response<WsResponseMaster<CFDIModelAPI>> wsResponseCFDIInfo = repo.execute();
		//WsResponseMaster wsresponse = wsResponseCFDIInfo.body();
		
		//System.out.println(wsresponse.toString());
		return wsResponseCFDIInfo;
	}
	public  Response<WsResponseMaster<String>>  descargarCFDI(String uuid) throws IOException {
		if(null==this.token)
			throw new IllegalArgumentException("token no debe ser null para consumir el API");
		
		if(uuid==null||uuid=="") {
			throw new IllegalArgumentException("uuid no debe ser vacio para consumir el API");
		}
		Retrofit retrofit = getRetrofit();

		CFDIInfoService service = retrofit.create(CFDIInfoService.class);
		Call<WsResponseMaster<String>> repo = service.cfdiDownload(uuid);
		Response<WsResponseMaster<String>> wsResponseCFDIInfo = repo.execute();

		return wsResponseCFDIInfo;
	}
	public  Response<WsResponseMaster<DataResponseDescargaProgramada>> ProgramarDescarga(DescargaProgramadaRequest p) throws IOException {
		Retrofit retrofit = getRetrofit();

		DescargaProgramadaService service = retrofit.create(DescargaProgramadaService.class);
		Call<WsResponseMaster<DataResponseDescargaProgramada>> repo = service.crearDescarga(p);
		Response<WsResponseMaster<DataResponseDescargaProgramada>> wsResponseCFDIInfo = repo.execute();
		return wsResponseCFDIInfo;
		
	}
	
	public Response<WsResponseMaster<List<DataDescargaProgramada>>> obtenerDescargasDiarias(ParametersDescargasDiarias para) throws IOException{
		Retrofit retrofit = getRetrofit();
		DescargaProgramadaService service = retrofit.create(DescargaProgramadaService.class);
		Call<WsResponseMaster<List<DataDescargaProgramada>>> repo = service.ObtenerDescargasProgramadasDiarias(para);
		Response<WsResponseMaster<List<DataDescargaProgramada>>> wsResponseCFDIInfo = repo.execute();
		return wsResponseCFDIInfo;
	}
	public Response<WsResponseMaster<DataDescargaProgramadaDetail>> obtenerDetalleDescarga(String uuid) throws IOException{
		Retrofit retrofit = getRetrofit();
		DescargaProgramadaService service = retrofit.create(DescargaProgramadaService.class);
		Call<WsResponseMaster<DataDescargaProgramadaDetail>> call = service.ObtenerDescargasProgramadasDetalle(uuid);
		return call.execute();
	}
 
	public Response<WsResponseMaster<String>> DescargarCFDIS(ParametersDownloadCFDI cfdirequest) throws IOException{
		CFDIInfoService service= getRetrofit().create(CFDIInfoService.class);
		Call<WsResponseMaster<String>> call= service.downloadCfdis(cfdirequest);
		return call.execute();
	}
	
	public Response<WsResponseMaster<Boolean>> ExisteCFDI(String uuid) throws IOException{
		CFDIInfoService service= getRetrofit().create(CFDIInfoService.class);
		Call<WsResponseMaster<Boolean>> call= service.existeCfdi(uuid);
		return call.execute();
	}
	public Response<WsResponseMaster<DataResponseCFDIConsulta>> ConsultarCFDIDatos(ParametersCFDIQuery $params) throws IOException{
		CFDIInfoService service= getRetrofit().create(CFDIInfoService.class);
		Call<WsResponseMaster<DataResponseCFDIConsulta>> call= service.consultarCFDI($params);
		return call.execute();
	}
	
	public Response<WsResponseMaster<String>> ReactivarDescarga(String uuid) throws IOException{
		Call<WsResponseMaster<String>> call= getRetrofit().create(DescargaProgramadaService.class).ReactivarDescargaProgramada(uuid);
		return call.execute();		
	}
	public Response<WsResponseMaster<DataEFirmaResponse>> SubirEfirma(ParameterSubirEFirma para) throws IOException{
		Call<WsResponseMaster<DataEFirmaResponse>> call= getRetrofit().create(EfirmaService.class).subirEfirma(para);
		return call.execute();		
	}
	public Response<WsResponseMaster<Integer>> DesbloquearItems(ParameterDesbloquarItems para) throws IOException{
		Call<WsResponseMaster<Integer>> call= getRetrofit().create(CFDIInfoService.class).desbloquear(para);
		return call.execute();		
	}
	public Response<WsResponseMaster<ResponseConsultarConfiguracion>> consultarConfiguracion() throws IOException{
		Call<WsResponseMaster<ResponseConsultarConfiguracion>> call= getRetrofit().create(ConfiguracionDescargaService.class).consultarConfiguracion();
		return call.execute();		
	}
	public Response<WsResponseMaster<ResponseConsultarConfiguracion>> EstablecerMetodoDescarga(ParametersEsteblecerConfiguracion para) throws IOException{
		Call<WsResponseMaster<ResponseConsultarConfiguracion>> call= getRetrofit().create(ConfiguracionDescargaService.class).EstablecerMetodoDescarga(para);
		return call.execute();		
	}
	public Response<WsResponseMaster<ResponseConsultarConfiguracion>> EstablecerHorasEspera(ParametersEsteblecerConfiguracion para) throws IOException{
		Call<WsResponseMaster<ResponseConsultarConfiguracion>> call= getRetrofit().create(ConfiguracionDescargaService.class).EstablecerHorasEspera(para);
		return call.execute();		
	}
	public   Retrofit getRetrofit() {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		if(isLog()) {
			HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor();
			loggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
			httpClient.interceptors().add(loggerInterceptor);
		}
		
		httpClient.addInterceptor(new Interceptor() {

			//@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				Request original =chain.request();
				Request request = original.newBuilder()
						.header("Authorization", DescargaSATSDK.this.getToken())
						.method(original.method(),original.body())
						.build();
				
				return chain.proceed(request);
			}
			
		});
		//establezco mas tiempo debido a que algunas operaciones como desbloqueo lleva mas de 10 segundos 
		httpClient.connectTimeout(30,TimeUnit.SECONDS).readTimeout(30,TimeUnit.SECONDS);
		
		OkHttpClient client = httpClient.build();
		if(!this.hasMapper()) {
			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			mapper.setDateFormat(df);
			this.setMapper(mapper);
		}
		
		//the api oficcially supports the next format, so i set up this format for the ObjectMapper 
		
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
				.addConverterFactory(JacksonConverterFactory.create(mapper)).client(client).build();
		
		return retrofit;

	}

}
