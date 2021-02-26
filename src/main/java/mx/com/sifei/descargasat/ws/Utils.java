package mx.com.sifei.descargasat.ws;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

import okhttp3.ResponseBody;
/***
 * 
 * @author Daniel
 *
 */
public class Utils {
	
	public static String readFileAndGetBase64(String filePath) throws IOException {
		File file = new File(filePath); 
		  
		FileInputStream fs =  new FileInputStream(file);
		 byte[] bytes= new byte[(int) file.length()];
		 fs.read(bytes);
		fs.close();
		return Base64.encodeBase64String(bytes);
		
	}
	 
	public static String parseErrorBody(ResponseBody dc) throws IOException {
		 
		InputStream inputStream = dc.byteStream();
		//tomamos el input stream y lo escribimos a un String
		String body = convert(inputStream, Charset.forName("utf-8"));
	 
		return body;
	}
	public static String convert(InputStream inputStream, Charset charset) throws IOException {

		 
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset));
		String line=null;
		StringBuilder sb= new StringBuilder();
		
		while((line= br.readLine())!=null) {
			sb.append(line);
			sb.append(System.lineSeparator());
		}
		br.close();
		 return sb.toString();
		//return br.lines().collect(Collectors.joining());
	 
}
}
