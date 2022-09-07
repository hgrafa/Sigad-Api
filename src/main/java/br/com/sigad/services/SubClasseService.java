package br.com.sigad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigad.entities.SubClasse;
import br.com.sigad.repositories.SubClasseRepository;

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
