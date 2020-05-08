package com.configdemo.springconfig.model;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("user")
public class UserDetails {
	
	private List<String> details;
	private int pwdage;
	private String password;
	/*@Value("#{${user.mapValues}}")
	private Map<String,String> mapValues;*/

	
	public int getPwdage() {
		return pwdage;
	}
	public void setPwdage(int pwdage) {
		this.pwdage = pwdage;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	/*public Map<String, String> getMapValues() {
		return mapValues;
	}
	public void setMapValues(Map<String, String> mapValues) {
		this.mapValues = mapValues;
	}*/

}
