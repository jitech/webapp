package br.com.webapp.enums;

public enum StatusEnum {

	ACTIVE("ACTIVE"),
	INATIVE("INACTIVE");
	
	public String value;
	
	StatusEnum(String code){
		value = code;
	}
}
