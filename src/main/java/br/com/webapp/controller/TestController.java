package br.com.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.webapp.utils.FileUtil;

@Controller
public class TestController implements IController{

	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, HttpSession session) {
		
		try {
				loadLog().info("User sending test: "+loadLoggedUser(session).getName());
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile multipartFile = multipartRequest.getFile("file");   	    	
				FileUtil.saveFileIntoDirectory(multipartFile, "test"); 	
				return "test";
				
		}catch(Exception ex) {
			ex.printStackTrace();
			loadLog().error("Ocorreu um erro ao realizar upload do arquivo");
    		return "test";
		}
    }
}