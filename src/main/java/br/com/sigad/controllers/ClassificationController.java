package br.com.sigad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/classificacao/*")
public class ClassificationController {
	
	@GetMapping (value = "/classificacao/cadastroclasse")
	public String cadastroclasse() {
		return "/classificacao/cadastroclasse";
	}
	
	@GetMapping (value = "/classificacao/cadastrosubclasse")
	public String cadastrosubclasse() {
		return "/classificacao/cadastrosubclasse";
	}
	
	@GetMapping (value = "/classificacao/cadastrogrupo")
	public String cadastrogrupo() {
		return "/classificacao/cadastrogrupo";
	}
	
	@GetMapping (value = "/classificacao/cadastrosubgrupo")
	public String cadastrosubgrupo() {
		return "/classificacao/cadastrosubgrupo";
	}
	
	
	
	

}
