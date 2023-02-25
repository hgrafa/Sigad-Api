package br.com.sigad.controllers.documents;

import br.com.sigad.model.dto.input.ClasseForm;
import br.com.sigad.model.util.DropdownOption;
import br.com.sigad.services.ClasseService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/classes")
@AllArgsConstructor
public class ClasseController {

	private ClasseService classeService;

	@GetMapping
	public String cadastroclasse(Model model, ClasseForm classeForm) {
		List<DropdownOption> indicadorAtivaoptions = Arrays.asList(
			new DropdownOption("blank", "Selecione"),
			new DropdownOption("ativa", "Ativa"),
			new DropdownOption("inativa", "Inativa")
		);

		List<DropdownOption> permissaoDeUsoOptions = Arrays.asList(
				new DropdownOption("blank", "Selecione"),
				new DropdownOption("Estrutura Hierárquica", "Estrutura Hierárquica"),
				new DropdownOption("Temporalidade e Destinação", "Temporalidade e Destinação")
		);

		List<DropdownOption> destinacaoFinalOptions = Arrays.asList(
				new DropdownOption("blank", "Selecione"),
				new DropdownOption("Eliminação", "Eliminação"),
				new DropdownOption("Guarda Permanente", "Guarda Permanente")
		);

		List<DropdownOption> sigiloOptions = Arrays.asList(
				new DropdownOption("blank", "Selecione"),
				new DropdownOption("Ostensivo", "Ostensivo"),
				new DropdownOption("Sigiloso", "Sigiloso")
		);

		List<DropdownOption> grauSigiloOptions = Arrays.asList(
				new DropdownOption("blank", "Selecione"),
				new DropdownOption("Confidencial", "Confidencial"),
				new DropdownOption("Reservado", "Reservado"),
				new DropdownOption("Secreto", "Secreto"),
				new DropdownOption("Ultra_Secreto", "Ultra-Secreto")
		);

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

}