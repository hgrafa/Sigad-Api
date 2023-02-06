package br.com.sigad.services;

import java.util.List;
import java.util.Optional;

import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Sigilo;
import br.com.sigad.repositories.SubClasseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.sigad.model.dto.input.ClasseForm;
import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.repositories.ClasseRepository;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import br.com.sigad.services.exceptions.DestinacaoInvalidaException;

@Service
@AllArgsConstructor
public class ClasseService {
	private ClasseRepository classeRepository;
	private SubClasseRepository subClasseRepository;

	public List<Classe> findAll() {
		List<Classe> classes = classeRepository.findAll();
		return classes;
	}
	
	public Classe findById(Long id) {
		Optional<Classe> classe = classeRepository.findById(id);
		return classe.get();
	}

	public Classe register(ClasseForm classeForm) {
		return classeRepository.save(toClasse(classeForm));
	}
	
	public List<Classe> findByDestinacao(String destinacaoFinal) 
		throws DestinacaoInvalidaException {

		Destinacao destinacao;

		switch(destinacaoFinal.toUpperCase()){
			case "ELIMINAÇÃO" -> destinacao = Destinacao.ELIMINACAO;
			case "RECOLHIMENTO" -> destinacao = Destinacao.RECOLHIMENTO;
			default -> throw new DestinacaoInvalidaException(destinacaoFinal);
		}

		return classeRepository.findByDestinacaoFinal(destinacao);
	}

	public Classe updateClasse(Long id, ClasseForm classeUpdateForm) 
		throws ClasseNaoEncontradaException {

		Classe origin = toClasse(classeUpdateForm);
		Classe target = classeRepository
			.findById(id)
			.orElseThrow(() -> new ClasseNaoEncontradaException("Nao encontrada!"));

		updateClasse(origin, target);

		return null;
	}

	private void updateClasse(Classe origin, Classe target) {
		// TODO
	}

	private Classe toClasse(ClasseForm classeForm) {
		return Classe.builder()
				.codigo(classeForm.getCodigo())
				.nome(classeForm.getNome())
				.indicadorAtiva(classeForm.getIndicadorAtiva().equalsIgnoreCase("ativo"))
				.prazoCorrente(classeForm.getPrazoCorrente())
				.prazoIntermediaria(classeForm.getPrazoIntermediaria())
				.observacao(classeForm.getObservacao())
				.destinacaoFinal(Destinacao.valueOf(classeForm
					.getDestinacaoFinal()
					.equalsIgnoreCase("Eliminação") ?
					"ELIMINACAO" : "RECOLHIMENTO") ) // TODO pelo envio do DropdownOption
				.sigilo(Sigilo.valueOf(classeForm.getSigilo().toUpperCase()))
				.grauSigilo(GrauSigilo.valueOf(classeForm.getGrauSigilo().toUpperCase()))
				.build();
	}
	
}
