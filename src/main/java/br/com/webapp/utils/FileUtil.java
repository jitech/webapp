package br.com.webapp.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static File saveFileIntoDirectory(MultipartFile multipart, String fileName) {
	       
		try { 	
	    		File convFile = new File(fileName);
	    		multipart.transferTo(convFile);
	    		return convFile;
	    			
	    }catch(Exception ex) {
	    		ex.printStackTrace();
	    		return null;
	    }
	}
}
