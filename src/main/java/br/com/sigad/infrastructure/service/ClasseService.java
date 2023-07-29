package br.com.sigad.infrastructure.service;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.infrastructure.exception.ClasseNaoEncontradaException;
import br.com.sigad.domain.model.Classe;
import br.com.sigad.infrastructure.profiles.ClasseMapper;
import br.com.sigad.infrastructure.repository.ClasseRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasseService {

	@NonNull private ClasseMapper classeMapper;
	@NonNull private ClasseRepository classeRepository;

	public Page<ClasseViewDto> getAll(Pageable pageable) {
		// TODO validar find all
		var classes = classeRepository
				.findAll(pageable)
				.map(classeMapper::classeToView);

		return classes;
	}

	public ClasseViewDto getById(Long id) {
		// TODO tratar excessão not found
		var classe = classeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("DocumentClass não encontrada"));

		return classeMapper.classeToView(classe);
	}

	public ClasseViewDto register(ClasseForm classeForm) {
		var classeToSave = classeMapper.formToClasse(classeForm);
		var savedClasse = classeRepository.save(classeToSave);
		return classeMapper.classeToView(savedClasse);
	}

	public ClasseViewDto updateClasse(Long id, ClasseForm updateForm)
			throws ClasseNaoEncontradaException {

		Classe source = classeMapper.formToClasse(updateForm);
		Classe destination = classeRepository
				.findById(id)
				.orElseThrow(() -> new ClasseNaoEncontradaException("Nao encontrada!"));

		classeMapper.updateClasse(destination, source);
		var updated = classeRepository.save(destination);
		return classeMapper.classeToView(updated);
	}

	public ClasseViewDto deleteById(long id) {
		var classe = classeRepository.findById(id);

		if(classe.isEmpty()) {
			return null;
		}

		classeRepository.deleteById(id);
		return classeMapper.classeToView(classe.get());
	}
}
