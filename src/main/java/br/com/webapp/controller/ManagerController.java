package br.com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webapp.domain.User;

@Controller
public class ManagerController{
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectToLoginPage(User user, Model model) {    
		model.addAttribute("user",user);
    	return "login";    
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String redirectToTestPage(Model model) {    
    	return "test";    
    }
}