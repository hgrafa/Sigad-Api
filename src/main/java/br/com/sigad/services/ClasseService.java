package br.com.sigad.services;

import br.com.sigad.model.dto.input.ClasseForm;
import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Permissao;
import br.com.sigad.model.enums.Sigilo;
import br.com.sigad.repositories.ClasseRepository;
import br.com.sigad.repositories.SubClasseRepository;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import br.com.sigad.services.exceptions.DestinacaoInvalidaException;
import br.com.sigad.util.NullableUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

		Classe source = toClasse(classeUpdateForm);
		Classe destination = classeRepository
			.findById(id)
			.orElseThrow(() -> new ClasseNaoEncontradaException("Nao encontrada!"));

		updateClasse(source, destination);

		return classeRepository.save(destination);
	}

	private void updateClasse(Classe source, Classe destination) {
		destination.setNome(NullableUtils.getNewValueIfNotNull(destination.getNome(), source.getNome()));
		destination.setCodigo(NullableUtils.getNewValueIfNotNull(destination.getCodigo(), source.getCodigo()));
		destination.setObservacao(NullableUtils.getNewValueIfNotNull(destination.getObservacao(), source.getObservacao()));
		destination.setSigilo(NullableUtils.getNewValueIfNotNull(destination.getSigilo(), source.getSigilo()));
		// TODO completar campos a serem atualizados
	}

	private Classe toClasse(ClasseForm classeForm) {
		return Classe.builder()
				.codigo(classeForm.getCodigo())
				.nome(classeForm.getNome())
				.indicadorAtiva(classeForm.getIndicadorAtiva().equalsIgnoreCase("ativo"))
				.permissaoDeUso(Permissao.valueOf(classeForm
						.getPermissaoDeUso()
						.equalsIgnoreCase("Estrutura Hierárquica") ?
						"ESTRUTURA_HIERARQUICA" : "TEMPORALIDADE_E_DESTINACAO") )
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
