package br.com.sigad.resources.controllers;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.infrastructure.services.ClasseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "classes")
public class ClasseController {

	@NonNull private ClasseService classeService;

	@GetMapping
	public ResponseEntity<Page<ClasseViewDto>> getAll(
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "1") int page
	) {

		var classes = classeService.getAll(PageRequest.of(size, page));
		return ResponseEntity.ok(classes);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClasseViewDto> getById (
			@PathVariable Long id
	) {
		var classe = classeService.getById(id);
		return ResponseEntity.ok().body(classe);
	}

	@PostMapping(value = "new")
	public ResponseEntity<ClasseViewDto> register (
			@RequestBody ClasseForm classeForm
	) {
			var registeredClasse = classeService.register(classeForm);
			return ResponseEntity.accepted().body(registeredClasse);
	}

	@PatchMapping(value = "update/{id}")
	public ResponseEntity<?> partialUpdate (
			@PathVariable Long id
	) {
		// TODO implementar modelo de request PATH para atualizacao parcial
		return null;
	}

	@PutMapping(value = "update/{id}")
	public ResponseEntity<?> update (
			@PathVariable Long id,
			@RequestBody ClasseForm classeUpdateForm
	)  {

		var updated = classeService.updateClasse(id, classeUpdateForm);
		return ResponseEntity.ok().body(updated);

	}

	@DeleteMapping
	public ResponseEntity<?> deleteClasseById(long id) {
		var deletedClasse = classeService.deleteById(id);
		return ResponseEntity.ok("");
	}
}
