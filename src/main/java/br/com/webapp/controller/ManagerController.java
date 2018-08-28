package br.com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerController implements IController{
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirectToLoginPage(Model model) {    
    	return "login";    
    }
}