package br.com.webapp.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.webapp.domain.User;
import br.com.webapp.utils.FileUtil;
import br.com.webapp.utils.LoggerUtil;

@Controller
public class TestController implements IController{

	@RequestMapping(value = "/test/generate", method = RequestMethod.GET)
    public String generate(Model model, User user, HttpSession session) {
        
    	try {			
    			model.addAttribute("test", "JAVATEST");
    			return "home"; 
    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return "login";
    	}    
    }
	
	@RequestMapping(value = "/test/load/{code}", method = RequestMethod.GET)
    public String loadTest(@PathVariable String code, User user, Model model, HttpSession session) {
        
    	try {		
    			if(loadLoggedUser(session) != null) {
    				LoggerUtil.info(getClass(), "Carregando teste: "+code);
    				model.addAttribute("test", "JAVATEST");
    				return "test";
    			}
    		
    			return "login"; 
    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return "login";
    	}    
    }
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, HttpSession session) {
		
		try {			
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				MultipartFile multipartFile = multipartRequest.getFile("file");   	    	
				File file = FileUtil.saveFileIntoDirectory(multipartFile, loadLoggedUser(session).getEmail());															
				//new CodeAnalyserUtil(file.getAbsolutePath(), TestCodeUtil.loadTestCode());
				return "sucess";
				
		}catch(Exception ex) {
			ex.printStackTrace();
			LoggerUtil.error(getClass(), "Ocorreu um erro ao realizar upload do arquivo");
    		return "error";
		}
    }
}