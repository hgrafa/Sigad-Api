package br.com.sigad.resources;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.domain.model.Classe;
import br.com.sigad.services.ClasseService;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/0.0.1/classes")
public class ClasseController {

	private ClasseService classeService;

	// TODO endpoint para buscar opções a serem exibidas no front

	@GetMapping
	public ResponseEntity<List<ClasseViewDto>> getAll() {
		var classes = classeService.findAll();
		return ResponseEntity.ok().body(classes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClasseViewDto> getById (@PathVariable Long id) {
		var classe = classeService.findById(id);
		return ResponseEntity.ok().body(classe);
	}

	// TODO isolar lógica na service
	//	@GetMapping(value = "/busca")
	//	public ResponseEntity<List<ClasseDto>> getByDestinacao (@RequestParam String destinacaoFinal){
	//		List<ClasseDto> classes = classeService
	//				.findByDestinacao(destinacaoFinal)
	//				.stream()
	//				.map(ClasseDto::new)
	//				.collect(Collectors.toList());
	//
	//		return ResponseEntity.ok().body(classes);
	//	}

	@PostMapping(value = "/registrar")
	public ResponseEntity<ClasseViewDto> addClasse (@RequestBody ClasseForm classeForm) {
			// TODO isolar mapeamento na service
			var registeredClasse = classeService.register(classeForm);
			return ResponseEntity.accepted().body(registeredClasse);
	}

	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<?> updateClasse(
			@PathVariable Long id,
			@RequestBody ClasseForm classeUpdateForm
	)
			throws Exception {
		// TODO isolar mapeamento na service

		try {
			var updated = classeService.updateClasse(id, classeUpdateForm);
			return ResponseEntity.ok().body(updated);
		} catch(ClasseNaoEncontradaException e1) {
			// throw new ApiException(e1.getStatus(), e1.getMessage());
			return ResponseEntity.badRequest().body("");
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteClasseById(long id) {
		return ResponseEntity.ok("");
	}
}
