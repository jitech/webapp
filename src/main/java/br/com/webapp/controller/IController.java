package br.com.webapp.controller;

import org.apache.log4j.Logger;

public interface IController {

	default Logger getLog() {
		return Logger.getLogger(this.getClass().getName());
	} 
}
