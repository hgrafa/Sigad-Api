package br.com.sigad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigad.model.entities.SubGrupo;
import br.com.sigad.repositories.SubGrupoRepository;

@Service
public class SubGrupoService {
	
	@Autowired
	private SubGrupoRepository subGrupoRepository;
	
	public List<SubGrupo> findAll(){
		List<SubGrupo> subgrupos = subGrupoRepository.findAll();
		return subgrupos;
	}
	
	public SubGrupo findById(Long Id) {
		Optional<SubGrupo> subgrupo = subGrupoRepository.findById(Id);
		return subgrupo.get();
	}
	

}
