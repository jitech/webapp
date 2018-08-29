package br.com.webapp.utils;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
		
	public static File saveFileIntoDirectory(MultipartFile multipart, String fileName) {
	       
		try { 	
				MessageDigest m = MessageDigest.getInstance("MD5");
				m.update(fileName.getBytes(),0,fileName.length());				
				String name = new BigInteger(1,m.digest()).toString(16);				
	    		File convFile = new File("/export/"+name+".jar");
	    		multipart.transferTo(convFile);
	    		LoggerUtil.info(FileUtil.class, "Arquivo importado com sucesso!");
	    		return convFile;
	    			
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}