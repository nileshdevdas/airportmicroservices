package com.vinsys.airports;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * This class methods can be exposed 
 * as a api :- 
 * 
 * 
 */
@RestController
public class VersionController {

	@GetMapping(path = "version")
	public String getVersion() {
		System.out.println("Here we are....");
		//Whatever you compute here can be returned as
		// rest response 
		return Math.random()+"xx";
	}
}
