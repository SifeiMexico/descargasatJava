# ![Sifei](https://www.sifei.com.mx/web/image/res.company/1/logo?unique=38c7250)



# SDK API consumo de descargaSAT

Este repositorio incluye en el SDK en JAVA y ejemplos para el consumo de endpoints del API REST de descargaSAT

[DescargaSAT](https://descargasat.sifei.com.mx/)

[Sifei](https://www.sifei.com.mx/) 

La clase principal es DescargaSATSDK
# Ejemplos

## Ejemplo Descargar CFDI por UUID:


```java
public static void consultarCFDIPorUUID() {		
		
		DescargaSATSDK sdk = new DescargaSATSDK();
	 	sdk.setLog(true);
		sdk.setToken(token);
		try {
			Response<WsResponseMaster<CFDIModelAPI>> response=  sdk.ObtenerCFDIPorUUID("E23DF780-96DC-4AF3-80AF-EB12AFDEAE35");
			if(response.isSuccessful()){
				//deserializa body
				WsResponseMaster<CFDIModelAPI> body=response.body();
					if(body.isStatusSuccess()) {
						//todo bien, hago lo que necesite con el CFDI
						CFDIModelAPI cfdiInfo=body.getData();
						System.out.println(cfdiInfo.uuid);
					}
			}else{
				//error de conexion, porpias de la peticion
				System.err.println("Error http code:" + response.code());
				//obtenemos el body del error
				ResponseBody dc = response.errorBody();
				String error= Utils.parseErrorBody(dc);
				System.err.println(error);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
```

## Ejemplo programar Descarga

```java
public static void programarDescarga() throws IOException {
		//objeto tipo descarga que espera el WS.
		DescargaProgramadaRequest descargaProgramadaRequest = new DescargaProgramadaRequest();
		//se establece la fecha inicial
		descargaProgramadaRequest.setFechaInicial(new Date()); 
		Date datefinal = new Date();
		Calendar cd = Calendar.getInstance();
		cd.add(Calendar.DATE, 1);
		datefinal = cd.getTime();
		//se establece la fecha final
		descargaProgramadaRequest.setFechaFinal(datefinal); 
		descargaProgramadaRequest.setTipodeDescargaDescarga(TipoDescarga.CFDI);//estebles el tipo
		//se inicializa el SDK
		DescargaSATSDK sdk = new DescargaSATSDK();
		//se establece el token que es necesario para consumir
		sdk.setToken(token); 
		
		try {
			//ahora se consume el servicio
			Response<WsResponseMaster<DataResponseDescargaProgramada>> response=	sdk.ProgramarDescarga(descargaProgramadaRequest);
			//con el metodo isSuccessful se verficiar si  la peticion http fue correcta
			if(response.isSuccessful()) {
				//si a nivel http fue correcto, entonces se deserializa el body:
				WsResponseMaster<DataResponseDescargaProgramada> body=response.body();
				//en el body verificamos que con isStatusSuccess que la OPERACION fue correcta.
				if(body.isStatusSuccess()) {
					 //si status es success en el body entonces operar con data
					DataResponseDescargaProgramada data= body.getData();
					 
				}else {
					//algo fue mal un codigo de error
					System.err.println("Codigo:"+body.getCode());
					System.err.println("Error:"+body.getMessage());
					//... haz lo que necesites
				}
				
			}else {//codigo diferente de 200 a 300.
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
                       
		}
	}

```

## Ejemplo Consulta de CFDI (varios parametros)

```java
 public static void ConsultarCFDI() {
		DescargaSATSDK sdk = new DescargaSATSDK();
		sdk.setLog(true);
		 //token
		sdk.setToken(token);		
		try {
			//se instancia el objeto que permite establecer el criterio de busqueda
			ParametersCFDIQuery params= new ParametersCFDIQuery();
			//efecto es el mismo que de clave TipoCFDI:
			params.setEfectoCFDI("I");		
			//si se quiere filtrar por RFC EMISOR
			params.setRfcEmisor(rfcEmisor); 
			//numero de resultados que deseamos obtener(como maximo)
			params.setLimit(3);
			//
			Calendar fechaInicial = Calendar.getInstance();
			fechaInicial.add(Calendar.MONTH, -15);
			//fecha inicial de busqueda.
			params.setFechaInicial(fechaInicial.getTime());
			 
			//se setea el objeto query y se consume el ws
			Response<WsResponseMaster<DataResponseCFDIConsulta>> response = sdk.ConsultarCFDIDatos(params);
			if (response.isSuccessful()) {// everything is ok
				WsResponseMaster<DataResponseCFDIConsulta> body =response.body();
				//checamos el estaus
				if (body.isStatusSuccess()) {
					//obtenemos el data
					 DataResponseCFDIConsulta data=body.getData();
					 //este objeto alberga varios campos, el de mayor interes es la lista de CFDI que consultamos
					 //asi que se extrae via getter y se recorre:
					List<CFDIModelAPI> lstCFDI= data.getCfdi();
					for(CFDIModelAPI cfdi : lstCFDI){
						System.out.println(cfdi.uuid);
					}
					//otros campos:
					//total de cfdi existentes que cumplen el criterio:
					System.out.println(data.getTotal());
					//cantidad de cfdi devuelvtos en la peticion(delimitado por el limit de la peticion)
					System.out.println(data.getCount());
			
					
				}else {
					System.err.println(response.body().getMessage());
				}
			} else { 
				// si algo fue mal en la respuesta y deseas ver lo que devuelve el server en la peticion:
				System.err.println("Error http code:" + response.code());
				//obtenemos el body
				ResponseBody dc = response.errorBody(); 
				//se obtiene el stream stream y se convierte a String
				InputStream inputStream = dc.byteStream();				
				String body = convert(inputStream, Charset.forName("utf-8"));
				//imprimmos el error:
				System.err.println(body);
			}

		} catch (Exception e) {			 
			e.printStackTrace();
		}
		
	}

```


## Ejemplo descarga de CFDI

```java
/**
	 * Descarga CFDI via UUID
	 */
	public static void descargarXML() {
		DescargaSATSDK sdk = new DescargaSATSDK();
		sdk.setLog(true);
		sdk.setToken(token);
		
		try {
			Response<WsResponseMaster<String>> response=  sdk.descargarCFDI(uuidCFDI);
			if(response.isSuccessful()){
				WsResponseMaster<String> body= response.body();
					if(body.isStatusSuccess()) {
						//todo bien, hago lo que necesite con el CFDI
						String XMLB64=body.getData();
						//escribir a archivo, enviar por correo, insertar en BD, etc
					}
			}else{
				//error de conexion, propias de la peticion
				System.err.println("Error http code:" + response.code());
				//obtenemos el body del error
				ResponseBody dc = response.errorBody();
				String error= Utils.parseErrorBody(dc);
				System.err.println(error);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
```

## Ejemplo Verificar SI existe CFDI


```java
public static void ExisteXMlTest() {
		DescargaSATSDK sdk = new DescargaSATSDK();
	 	sdk.setLog(true);
		sdk.setToken(token);		 
		try {
			//se le pasa el UUID que se desea verificar si existe en ACI DescargaSAT
			Response<WsResponseMaster<Boolean>> response = sdk.ExisteCFDI(uuidCFDI);
			//verficiamos si la peticion fue recibida:
			if (response.isSuccessful()) { 
				//deserializamos el JSON y obtenemos el body
				WsResponseMaster<Boolean> body=response.body();
				//a nivel de API se verifica que todo fue bien
				if (body.isStatusSuccess()) {
					//para este servicio data es un booleano, true indica que esta resguardo,false indica que no lo esta.
					if (body.getData() == true) {
						System.out.println("Existe el cfdi");
					} else {						
						System.out.println("No existe el CFDI");
					}
				}else {
					System.err.println(body.getMessage());
				}
			} else {  //algo fue mal en la peticion
				System.err.println("Error http code:" + response.code());
				//obtenemos el body del error
				ResponseBody dc = response.errorBody();
				String error= Utils.parseErrorBody(dc);
				System.err.println(error);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```