package br.com.webapp.utils;

import org.apache.log4j.Logger;

public class LoggerUtil {

	public static void info(Class c, String message) {
		Logger.getLogger(c.getName()).info(message);
	}
	
	public static void error(Class c, String message) {
		Logger.getLogger(c.getName()).error(message);
	}
}