package br.com.sigad.controllers.documents;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.enums.*;
import br.com.sigad.domain.util.DropdownOption;
import br.com.sigad.services.ClasseService;
import br.com.sigad.util.Dropdown;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "classes")
@AllArgsConstructor
public class ClasseController {

//	private ClasseService classeService;
//
//	@GetMapping
//	public String cadastroclasse(Model model, ClasseForm classeForm) {
//
//		List<DropdownOption> indicadorAtivaoptions = new ArrayList<>(Arrays.asList(
//				new DropdownOption("blank", "Selecione")
//				// new DropdownOption("ativa", "Ativa"),
//				// new DropdownOption("inativa", "Inativa")
//		));
//
//		List<DropdownOption> permissaoDeUsoOptions = new ArrayList<>(Arrays.asList(
//				new DropdownOption("blank", "Selecione")
//				// new DropdownOption("Estrutura Hierárquica", "Estrutura Hierárquica"),
//				// new DropdownOption("Temporalidade e Destinação", "Temporalidade e
//				// Destinação")
//		));
//
//		List<DropdownOption> destinacaoFinalOptions = new ArrayList<>(Arrays.asList(
//				new DropdownOption("blank", "Selecione")
//				// new DropdownOption("Eliminação", "Eliminação"),
//				// new DropdownOption("Guarda Permanente", "Guarda Permanente")
//		));
//
//		List<DropdownOption> sigiloOptions = new ArrayList<>(Arrays.asList(
//				new DropdownOption("blank", "Selecione")
//				// new DropdownOption("Ostensivo", "Ostensivo"),
//				// new DropdownOption("Sigiloso", "Sigiloso")
//		));
//
//		List<DropdownOption> grauSigiloOptions = new ArrayList<>(Arrays.asList(
//				new DropdownOption("blank", "Selecione")
//				// new DropdownOption("Confidencial", "Confidencial"),
//				// new DropdownOption("Reservado", "Reservado"),
//				// new DropdownOption("Secreto", "Secreto"),
//				// new DropdownOption("Ultra_Secreto", "Ultra-Secreto")
//		));
//
//		Dropdown.addEnumsOptions(indicadorAtivaoptions, IndicadorAtiva.values());
//		Dropdown.addEnumsOptions(permissaoDeUsoOptions, Permissao.values());
//		Dropdown.addEnumsOptions(destinacaoFinalOptions, Destinacao.values());
//		Dropdown.addEnumsOptions(grauSigiloOptions, GrauSigilo.values());
//		Dropdown.addEnumsOptions(sigiloOptions, Sigilo.values());
//
//		model.addAttribute("opcoesGrauSigilo", grauSigiloOptions);
//		model.addAttribute("opcoesSigilo", sigiloOptions);
//		model.addAttribute("opcoesIndicadorAtiva", indicadorAtivaoptions);
//		model.addAttribute("opcoesPermissaoDeUso", permissaoDeUsoOptions);
//		model.addAttribute("opcoesDestinacaoFinal", destinacaoFinalOptions);
//		model.addAttribute("classes", classeService.findAll());
//		return "/classificacao/cadastroclasse";
//	}
}
