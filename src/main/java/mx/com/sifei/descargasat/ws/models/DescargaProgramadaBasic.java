package mx.com.sifei.descargasat.ws.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DescargaProgramadaBasic {
	protected String uuid;

	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	protected Date fechaInicial;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	protected Date fechaFinal;
	
	
}
