package mx.com.sifei.descargasat.ws.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ZipUtil {

	public void Unzip() throws IOException {
		  String fileZip = "src/main/resources/unzipTest/compressed.zip";
	        File destDir = new File("src/main/resources/unzipTest");
	        byte[] buffer = new byte[1024];
	        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
	        ZipEntry zipEntry = zis.getNextEntry();
	        while (zipEntry != null) {
	            File newFile = newFile(destDir, zipEntry);
	            FileOutputStream fos = new FileOutputStream(newFile);
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	            }
	            fos.close();
	            zipEntry = zis.getNextEntry();
	        }
	        zis.closeEntry();
	}
	
	public static void ExtractFile(byte[] bytes) throws IOException, SAXException, ParserConfigurationException {
		  ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(bytes));
	        ZipEntry zipEntry = zis.getNextEntry();
	        byte[] buffer = new byte[1024]; 
	        while (zipEntry != null) {
	        	DocumentBuilderFactory factory =
	        			DocumentBuilderFactory.newInstance();
	        			DocumentBuilder builder = factory.newDocumentBuilder();
	        
	            //FileOutputStream fos = new FileOutputStream(newFile);
	        			ByteArrayOutputStream xml= new ByteArrayOutputStream();
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	            	xml.write(buffer, 0, len);
	            }
	            xml.close();
	            ByteArrayInputStream xmlinput = new ByteArrayInputStream(xml.toByteArray());
	        	Document doc = builder.parse(xmlinput);
	        	
	            zipEntry = zis.getNextEntry();
	        }
	        zis.closeEntry();
		
	}
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
         
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
         
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
         
        return destFile;
    }
}
