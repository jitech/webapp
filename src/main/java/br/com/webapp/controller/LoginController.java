package br.com.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.webapp.utils.FileUtil;

@Controller
public class LoginController implements IController{
	
    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String enter(Model model, @RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password) {
        
    	try {
    			model.addAttribute("name", "Jonas");
    			return "home"; 
    		
    	}catch(Exception ex) {
    		getLog().error("Ocorreu um erro ao realizar o login do usuário "+email);
    		return "login";
    	}    
    }
    
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request) {
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    	MultipartFile multipartFile = multipartRequest.getFile("file");   	    	
    	FileUtil.saveFileIntoDirectory(multipartFile, "test"); 	
    	return "home";
    }
}