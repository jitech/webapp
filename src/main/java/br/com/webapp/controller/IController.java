package br.com.webapp.controller;

import javax.servlet.http.HttpSession;

import br.com.webapp.domain.User;

public interface IController {
	
	default User loadLoggedUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
}