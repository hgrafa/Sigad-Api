package br.com.sigad.resources;

import br.com.sigad.model.dto.input.ClasseForm;
import br.com.sigad.model.dto.output.ClasseDto;
import br.com.sigad.model.entities.Classe;
import br.com.sigad.services.ClasseService;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/0.0.1/classes")
@AllArgsConstructor
public class ClasseResourceController {


	private ClasseService classeService;

	@GetMapping
	public ResponseEntity<List<ClasseDto>> getAll() {
		List<ClasseDto> classes = classeService
				.findAll()
				.stream()
				.map(c -> new ClasseDto(c))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(classes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClasseDto> getById (@PathVariable Long id) {
		ClasseDto classe = new ClasseDto(classeService.findById(id));
		return ResponseEntity.ok().body(classe);
	}
	
	@GetMapping(value = "/busca") 
	public ResponseEntity<List<ClasseDto>> getByDestinacao (@RequestParam String destinacaoFinal){
		List<ClasseDto> classes = classeService
				.findByDestinacao(destinacaoFinal)
				.stream()
				.map(ClasseDto::new)
				.collect(Collectors.toList());
				
		return ResponseEntity.ok().body(classes);
	}

	@PostMapping(value = "/registrar")
	public ResponseEntity<ClasseDto> addClasse (@RequestBody ClasseForm classeForm) {
			ClasseDto classe = new ClasseDto( classeService.register(classeForm) );
			return ResponseEntity.accepted().body(classe);
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<ClasseDto> updateClasse(@PathVariable Long id, @RequestBody ClasseForm classeUpdateForm) throws Exception {
		ClasseDto classe;
		
		try {
			Classe classeEntity = classeService.updateClasse(id, classeUpdateForm);
			classe = new ClasseDto(classeEntity);
		} catch(ClasseNaoEncontradaException e1) {
			throw new ApiException(e1.getStatus(), e1.getMessage());
		}

		return ResponseEntity.ok().body(classe);
	}

}
