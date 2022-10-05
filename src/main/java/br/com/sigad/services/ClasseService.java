package br.com.sigad.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigad.controllers.dto.ClasseDto;
import br.com.sigad.controllers.form.ClasseForm;
import br.com.sigad.entities.Classe;
import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.repositories.ClasseRepository;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import br.com.sigad.services.exceptions.DestinacaoInvalidaException;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;

	public List<Classe> findAll() {
		List<Classe> classes = classeRepository.findAll();
		return classes;
	}
	
	public Classe findById(Long id) {
		Optional<Classe> classe = classeRepository.findById(id);
		return classe.get();
	}

	public Classe register(ClasseForm classeForm) {
		return classeRepository.save(classeForm.toClasse());
	}
	
	public List<Classe> findByDestinacao(String destinacaoFinal) 
		throws DestinacaoInvalidaException {

		Destinacao destinacao;

		if(destinacaoFinal.equalsIgnoreCase("ELIMINAÇÃO")) {
			destinacao = Destinacao.ELIMINACAO;
		} else if (destinacaoFinal.equalsIgnoreCase("RECOLHIMENTO")){
			destinacao = Destinacao.RECOLHIMENTO;
		} else {
			throw new DestinacaoInvalidaException(destinacaoFinal);
		}

		List<Classe> classes = classeRepository
				.findAll()
				.stream()
				.filter(c -> c.getDestinacaoFinal().equals(destinacao))
				.collect(Collectors.toList());
				
		return classes;
	}

	public ClasseDto updateClasse(Long id, ClasseForm classeUpdateForm) {

		Classe origin = classeUpdateForm.toClasse();
		Classe target = classeRepository
			.findById(id)
			.orElseThrow(() -> new ClasseNaoEncontradaException("Nao encontrada!"));

		updateClasse(origin, target);

		return null;
	}

	private void updateClasse(Classe origin, Classe target) {
		// TODO
	}
	
}
