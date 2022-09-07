package br.com.sigad.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigad.entities.Classe;
import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
import br.com.sigad.entities.enums.Sigilo;
import br.com.sigad.services.ClasseService;

@RestController
@RequestMapping(value = "/classes")
public class ClasseController {

	@Autowired
	private ClasseService classeService;
		
	@GetMapping
	public ResponseEntity<List<Classe>> findAll() {
		List<Classe> classes = classeService.findAll();
		return ResponseEntity.ok().body(classes);
	}
	
	
	
}
