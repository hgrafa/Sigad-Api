package br.com.sigad.controllers.documents;

import br.com.sigad.model.dto.input.ClasseForm;
import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.*;
import br.com.sigad.model.util.DropdownOption;
import br.com.sigad.repositories.ClasseRepository;
import br.com.sigad.services.ClasseService;
import br.com.sigad.util.Dropdown;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "classes")
@AllArgsConstructor
public class ClasseController {

	private ClasseService classeService;

	@GetMapping
	public String cadastroclasse(Model model, ClasseForm classeForm) {
		var indicadorAtivaoptions = new ArrayList<DropdownOption>();
		var permissaoDeUsoOptions = new ArrayList<DropdownOption>();
		var destinacaoFinalOptions = new ArrayList<DropdownOption>();
		var sigiloOptions = new ArrayList<DropdownOption>();
		var grauSigiloOptions = new ArrayList<DropdownOption>();

		Dropdown.addEnumsOptions(indicadorAtivaoptions, IndicadorAtiva.values());
		Dropdown.addEnumsOptions(permissaoDeUsoOptions, Permissao.values());
		Dropdown.addEnumsOptions(destinacaoFinalOptions, Destinacao.values());
		Dropdown.addEnumsOptions(grauSigiloOptions, GrauSigilo.values());
		Dropdown.addEnumsOptions(sigiloOptions, Sigilo.values());


		model.addAttribute("opcoesGrauSigilo", grauSigiloOptions);
		model.addAttribute("opcoesSigilo", sigiloOptions);
		model.addAttribute("opcoesIndicadorAtiva", indicadorAtivaoptions);
		model.addAttribute("opcoesPermissaoDeUso", permissaoDeUsoOptions);
		model.addAttribute("opcoesDestinacaoFinal", destinacaoFinalOptions);
		model.addAttribute("classes", classeService.findAll());
		return "/classificacao/cadastroclasse";
	}

	@PostMapping @Transactional
	public String registraClasse(@Valid ClasseForm classeForm, BindingResult result) {
		if(result.hasErrors()){
			result.getAllErrors().forEach(System.err::println);
			return "redirect:/classes"; // TODO redirect to error page
		}

		classeService.register(classeForm);
		return "redirect:/classes";
	}

	@GetMapping(value ="/editar/{id}")
	public String editarClasses(@PathVariable("id") Long id, Model model){
		Classe classe = classeService.buscarClassePorId(id);
		model.addAttribute("classe", classe);
		return "editarClasse";
	}

	@GetMapping("/classe/{id}")
	public String obterClassePorId(@PathVariable("id") Long id, Model model) {
		Classe classe = classeService.buscarClassePorId(id);
		model.addAttribute("classe", classe);
		return "/classes";
	}



	@GetMapping (value = "cadastro/subclasse")
	public String cadastrosubclasse() {
		return "/classificacao/cadastrosubclasse";
	}
	
	@GetMapping (value = "cadastro/grupo")
	public String cadastrogrupo() {
		return "/classificacao/cadastrogrupo";
	}
	
	@GetMapping (value = "cadastro/subgrupo")
	public String cadastrosubgrupo() {
		return "/classificacao/cadastrosubgrupo";
	}
	
	@ExceptionHandler(Exception.class)
	public String onError() {
		return "";
	}

}