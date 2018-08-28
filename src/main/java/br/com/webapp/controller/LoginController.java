package br.com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webapp.domain.User;

@Controller
public class LoginController implements IController{
	
    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String enter(User user, HttpSession session) {
        
    	try {
    			user.setName("Jonas Goulart");    			
    			session.setAttribute("user", user);
    			loadLog().info("User logged: "+loadLoggedUser(session).getEmail());
    			return "home"; 
    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		loadLog().error("Ocorreu um erro ao realizar o login do usuário "+user.getEmail());
    		return "login";
    	}    
    }
}