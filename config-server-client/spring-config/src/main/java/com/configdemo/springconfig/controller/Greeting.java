package com.configdemo.springconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configdemo.springconfig.model.UserDetails;

@RestController
@RefreshScope
public class Greeting {
	
	@Value("${greeting:default hwllow world}")
	private String greeting;
	@Value("${list:default,hwllow,world}")

	private List<String> listValues;
	
	@Value("#{${mapValues}}")

	private Map<String,String> mapValues;
	@Autowired
	private UserDetails userDetails;

	@RequestMapping("/greetings")
	public String getGreetings(){
		 
		return greeting+listValues.size()+mapValues + userDetails.getPassword();
		
	}
	@Autowired
	Environment environment;

	 @GetMapping("/env")
		public String getgreeting(){
			 
			return environment.toString();
			
		}
}
