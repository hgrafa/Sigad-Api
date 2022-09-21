package br.com.sigad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigad.entities.Classe;
import br.com.sigad.entities.SubClasse;
import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
import br.com.sigad.entities.enums.Sigilo;
import br.com.sigad.repositories.ClasseRepository;

@Service
public class ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	public void save() {
		List<Classe> input = new ArrayList<>();

		input.add(new Classe(2L, "b1", "c", "d", "e", true, Permissao.ESTRUTURA_HIERARQUICA, Destinacao.ELIMINACAO, Sigilo.OSTENSIVO, GrauSigilo.CONFIDENCIAL));

		input.add(new Classe(2L, "b2", "c", "d", "e", true, Permissao.ESTRUTURA_HIERARQUICA, Destinacao.ELIMINACAO, Sigilo.OSTENSIVO, GrauSigilo.CONFIDENCIAL));

		input.add(new Classe( 2L, "b3", "c", "d", "e", true, Permissao.ESTRUTURA_HIERARQUICA, Destinacao.ELIMINACAO, Sigilo.OSTENSIVO, GrauSigilo.CONFIDENCIAL));

		classeRepository.saveAll(input);
	}

	public List<Classe> findAll() {
		List<Classe> classes = classeRepository.findAll();
		return classes;
	}
	
	public Classe findById(Long id) {
		Optional<Classe> classe = classeRepository.findById(id);
		return classe.get();
	}
	
	
}
