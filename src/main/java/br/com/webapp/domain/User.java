package br.com.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "USER")
public class User extends Domain{
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "EMAIL", nullable = false, updatable = false, unique = true)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
}