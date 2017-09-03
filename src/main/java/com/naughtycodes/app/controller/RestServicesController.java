package com.naughtycodes.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServicesController {

	@RequestMapping(value = { "/auth" }, method = RequestMethod.GET)
	public String authService(HttpServletRequest req) {
		
//		String username = req.getAttribute("username").toString();
//		String password = req.getAttribute("password").toString();
//		
//		System.out.println(username+"__"+password);
//		
//		UsernamePasswordAuthenticationToken requestAuthentication = new UsernamePasswordAuthenticationToken(username, password);
		
		return req.getRequestURI();
	}
	
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public String loginPage() {
		return "welcome";
	}
}
