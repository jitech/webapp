package br.com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.com.webapp.domain.User;

public interface IController {

	default Logger loadLog() {
		return Logger.getLogger(this.getClass().getName());
	} 
	
	default User loadLoggedUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
}