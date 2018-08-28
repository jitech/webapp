package br.com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.webapp.domain.User;

@Controller
@SessionAttributes("user")
public class LoginController implements IController{
	
	@ModelAttribute("user")
	public User loadUser() {
		return new User();
	}
	
    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String enter(@ModelAttribute("user") User user, Model model) {
        
    	try {
    			user.setName("Jonas Goulart");
    			return "home"; 
    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		loadLog().error("Ocorreu um erro ao realizar o login do usuário "+user.getEmail());
    		return "login";
    	}    
    }
}