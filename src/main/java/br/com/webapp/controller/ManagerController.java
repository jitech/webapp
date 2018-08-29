package br.com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webapp.domain.User;

@Controller
public class ManagerController implements IController{
	
	@RequestMapping(value = {"/login", "/upload", "/enter", "/home"}, method = RequestMethod.GET)
    public String redirectToHomeOrLoginPage(User user, Model model, HttpSession session) { 
		
		try {
				if(loadLoggedUser(session) != null) {
					model.addAttribute("user", loadLoggedUser(session));
					return "home";					
				}else {
					model.addAttribute("user",user);
					return "login";
				}				 
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return "error";
		}	   
    }
}