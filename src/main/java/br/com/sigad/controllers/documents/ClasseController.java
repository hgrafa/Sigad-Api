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
	@Autowired
	private ClasseRepository classeRepository;

	@GetMapping
	public String cadastroclasse(Model model, ClasseForm classeForm) {
	/*
	public ClasseController(ClasseService classeService) {
		this.classeService = classeService;
	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)

	public String cadastroclasse(Model model) {
	*/

		List<DropdownOption> indicadorAtivaoptions = new ArrayList<>(Arrays.asList(
			new DropdownOption("blank", "Selecione")
//			new DropdownOption("ativa", "Ativa"),
//			new DropdownOption("inativa", "Inativa")
		));

		List<DropdownOption> permissaoDeUsoOptions = new ArrayList<>(Arrays.asList(
				new DropdownOption("blank", "Selecione")
//				new DropdownOption("Estrutura Hierárquica", "Estrutura Hierárquica"),
//				new DropdownOption("Temporalidade e Destinação", "Temporalidade e Destinação")
		));

		List<DropdownOption> destinacaoFinalOptions = new ArrayList<>(Arrays.asList(
				new DropdownOption("blank", "Selecione")
//				new DropdownOption("Eliminação", "Eliminação"),
//				new DropdownOption("Guarda Permanente", "Guarda Permanente")
		));

		List<DropdownOption> sigiloOptions = new ArrayList<>(Arrays.asList(
				new DropdownOption("blank", "Selecione")
//				new DropdownOption("Ostensivo", "Ostensivo"),
//				new DropdownOption("Sigiloso", "Sigiloso")
		));

		List<DropdownOption> grauSigiloOptions = new ArrayList<>(Arrays.asList(
				new DropdownOption("blank", "Selecione")
//				new DropdownOption("Confidencial", "Confidencial"),
//				new DropdownOption("Reservado", "Reservado"),
//				new DropdownOption("Secreto", "Secreto"),
//				new DropdownOption("Ultra_Secreto", "Ultra-Secreto")
		));


		Dropdown.addEnumsOptions(indicadorAtivaoptions, IndicadorAtiva.values());
		Dropdown.addEnumsOptions(permissaoDeUsoOptions, Permissao.values());
		Dropdown.addEnumsOptions(destinacaoFinalOptions, Destinacao.values());
		Dropdown.addEnumsOptions(grauSigiloOptions, GrauSigilo.values());
		Dropdown.addEnumsOptions(sigiloOptions, Sigilo.values());


		// TODO adicionar este método para outras enums


		model.addAttribute("opcoesGrauSigilo", grauSigiloOptions);
		model.addAttribute("opcoesSigilo", sigiloOptions);
		model.addAttribute("opcoesIndicadorAtiva", indicadorAtivaoptions);
		model.addAttribute("opcoesPermissaoDeUso", permissaoDeUsoOptions);
		model.addAttribute("opcoesDestinacaoFinal", destinacaoFinalOptions);
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

	@RequestMapping(method = RequestMethod.GET, value="/classes")
	public ModelAndView listClasses(){
		ModelAndView andView = new ModelAndView("/classes");
		Iterable<Classe> classeIterable = classeRepository.findAll();
		andView.addObject("listClasses", classeIterable);
		return andView;
	}

}