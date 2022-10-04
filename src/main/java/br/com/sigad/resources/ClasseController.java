package br.com.sigad.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigad.controllers.dto.ClasseDto;
import br.com.sigad.entities.Classe;
import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.services.ClasseService;

@RestController
@RequestMapping(value = "api/0.0.1/classes")
public class ClasseController {

	@Autowired
	private ClasseService classeService;

	@GetMapping
	public ResponseEntity<List<ClasseDto>> findAll() {
		List<ClasseDto> classes = classeService
				.findAll()
				.stream()
				.map(c -> new ClasseDto(c))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(classes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClasseDto> findById(@PathVariable Long id) {
		ClasseDto classe = new ClasseDto(classeService.findById(id));
		return ResponseEntity.ok().body(classe);
	}
	
	@GetMapping(value = "/busca") 
	public ResponseEntity<List<ClasseDto>> findByDestinacao (@RequestParam String destinacaoFinal){
		List<ClasseDto> classes = classeService
				.findByDestinacao(destinacaoFinal)
				.stream()
				.map( c -> new ClasseDto(c) ) 
				.collect(Collectors.toList());
				
		return ResponseEntity.ok().body(classes);
	}

}
