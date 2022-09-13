package br.com.sigad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/autenticacao/*")
public class RegisterController {
	
	@GetMapping
	public String register() {
		return "/autenticacao/register";
	}
	
	

}
