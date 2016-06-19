package com.hc.stage.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.metier.utilisateur.InterfaceMetierUtilisateur;

@Controller
public class LoginControler {
//	
//	@RequestMapping(value="/loginm")
//	public String loginm(){
//		return "loginm";
//	}
//	@RequestMapping(value="/login")
//	public String login(){
//		return "loginm";
//	}
	@Autowired
	private InterfaceMetierUtilisateur iMetierUtilisateur;
	@RequestMapping(value="/home")
	public @ResponseBody List<Utilisateur> home(){
		return iMetierUtilisateur.getTousUtl();
	}
//	@RequestMapping(value="/logout")
//	public String logout(){
//		return "j_spring_security_logout";
//	}
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public @ResponseBody String selectUtl(@PathVariable String id) {
//		return "login";	
//	}

//	
//	@RequestMapping(method=RequestMethod.POST)
//	@ResponseBody
//	public String performLogin(
//	@RequestParam("j_username") String username, 
//	@RequestParam("j_password") String password,
//	HttpServletRequest request, HttpServletResponse response) 
//	{
//	UsernamePasswordAuthenticationToken token = 
//	new UsernamePasswordAuthenticationToken(username, password);
//	try {
//	Authentication auth = authenticationManager.authenticate(token);
//	SecurityContextHolder.getContext().setAuthentication(auth);
//	repository.saveContext(SecurityContextHolder.getContext(), request, response);
//	rememberMeServices.loginSuccess(request, response, auth);
//	return "{\"status\": true}";
//	} catch (BadCredentialsException ex) {
//	return "{\"status\": false, \"error\": \"Bad Credentials\"}";
//	}
//	}
	
}
