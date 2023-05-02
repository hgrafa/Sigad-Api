package br.com.sigad.services;

import br.com.sigad.domain.model.SubClasse;
import br.com.sigad.repositories.SubClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubClasseService {
	
	@Autowired
	private SubClasseRepository subClasseRepository;
	
	public List<SubClasse> findAll(){
		List<SubClasse> subclasses = subClasseRepository.findAll();
		return subclasses;
	}
	
	public SubClasse findById(Long id) {
		Optional<SubClasse> subClasse = subClasseRepository.findById(id);
		return subClasse.get();
	}

}
