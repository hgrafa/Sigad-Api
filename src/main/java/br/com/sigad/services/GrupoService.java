package br.com.sigad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigad.model.entities.Grupo;
import br.com.sigad.repositories.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public List<Grupo> findAll(){
		List<Grupo> grupos = grupoRepository.findAll();
		return grupos;		
	}
	
	public Grupo findById(Long id) {
		Optional<Grupo> grupo = grupoRepository.findById(id);
		return grupo.get();
	}

}
