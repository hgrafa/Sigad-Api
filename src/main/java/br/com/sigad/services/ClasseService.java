package br.com.sigad.services;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.domain.model.Classe;
import br.com.sigad.domain.enums.*;
import br.com.sigad.domain.profiles.ClasseMapper;
import br.com.sigad.repositories.ClasseRepository;
import br.com.sigad.repositories.SubClasseRepository;
import br.com.sigad.services.exceptions.ClasseNaoEncontradaException;
import br.com.sigad.services.exceptions.DestinacaoInvalidaException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClasseService {

	private ClasseMapper classeMapper = ClasseMapper.INSTANCE;
	@NonNull
	private ClasseRepository classeRepository;
	@NonNull
	private SubClasseRepository subClasseRepository;

	public List<ClasseViewDto> findAll() {

		var classes = classeRepository.findAll()
				.stream()
				.map(classeMapper::classeToView)
				.toList();

		return classes;
	}

	public ClasseViewDto findById(Long id) {
		Optional<Classe> classe = classeRepository.findById(id);
		return classeMapper.classeToView(classe.get());
	}

	public ClasseViewDto register(ClasseForm classeForm) {
		var classeToSave = classeMapper.formToClasse(classeForm);
		var savedClasse = classeRepository.save(classeToSave);
		return classeMapper.classeToView(savedClasse);
	}

	public List<Classe> findByDestinacao(String destinacaoFinal)
			throws DestinacaoInvalidaException {

		Destinacao destinacao;

		switch (destinacaoFinal.toUpperCase()) {
			case "ELIMINAÇÃO" -> destinacao = Destinacao.ELIMINACAO;
			case "RECOLHIMENTO" -> destinacao = Destinacao.RECOLHIMENTO;
			default -> throw new DestinacaoInvalidaException(destinacaoFinal);
		}

		return classeRepository.findByDestinacaoFinal(destinacao);
	}

	public ClasseViewDto buscarClassePorId(Long id) {
		// TODO tratar excessão not found
		var classe = classeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Classe não encontrada"));

		return classeMapper.classeToView(classe);
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

}

//	private void updateClasse(Classe source, Classe destination) {
//		//Cadastro Classe
//		destination.setCodigo(NullableUtils.getNewValueIfNotNull(destination.getCodigo(), source.getCodigo()));
//		destination.setNome(NullableUtils.getNewValueIfNotNull(destination.getNome(), source.getNome()));
//		destination.setIndicadorAtiva(NullableUtils.getNewValueIfNotNull(destination.getIndicadorAtiva(),source.getIndicadorAtiva()));
//		destination.setPermissaoDeUso(NullableUtils.getNewValueIfNotNull(destination.getPermissaoDeUso(), source.getPermissaoDeUso()));
//		//Temporalidade e Destinação
//		destination.setPrazoCorrente(NullableUtils.getNewValueIfNotNull(destination.getPrazoCorrente(), source.getPrazoCorrente()));
//		destination.setPrazoIntermediaria(NullableUtils.getNewValueIfNotNull(destination.getPrazoIntermediaria(), source.getPrazoIntermediaria()));
//		destination.setDestinacaoFinal(NullableUtils.getNewValueIfNotNull(destination.getDestinacaoFinal(), source.getDestinacaoFinal()));
//		//Sigilo associado à classe
//		destination.setSigilo(NullableUtils.getNewValueIfNotNull(destination.getSigilo(), source.getSigilo()));
//		destination.setGrauSigilo(NullableUtils.getNewValueIfNotNull(destination.getGrauSigilo(), source.getGrauSigilo()));
//		//Observações associadas à classe
//		destination.setObservacao(NullableUtils.getNewValueIfNotNull(destination.getObservacao(), source.getObservacao()));
//		// TODO completar campos a serem atualizados OK
//	}

//	private Classe toClasse(ClasseForm classeForm) {
//
//		// TODO ver se é ostensivo e não precisa do grauSigilo OK
//		GrauSigilo grauSigilo = classeForm.getGrauSigilo() != null ?
//				GrauSigilo.valueOf(classeForm.getGrauSigilo().toUpperCase()) :
//				null;
//
//		// TODO melhorar usando getAbsoluteText e getParsedText
//		return Classe.builder()
//				.codigo(classeForm.getCodigo())
//				.nome(classeForm.getNome())
//				.indicadorAtiva(IndicadorAtiva.valueOf(classeForm.getIndicadorAtiva()))
//				.permissaoDeUso(Permissao.valueOf(classeForm
//						.getPermissaoDeUso()
//						.equalsIgnoreCase("Estrutura Hierárquica") ?
//						"ESTRUTURA_HIERARQUICA" : "TEMPORALIDADE_E_DESTINACAO"))
//				.prazoCorrente(classeForm.getPrazoCorrente())
//				.prazoIntermediaria(classeForm.getPrazoIntermediaria())
//				.observacao(classeForm.getObservacao())
//				.destinacaoFinal(Destinacao.valueOf(classeForm
//						.getDestinacaoFinal()
//						.equalsIgnoreCase("Eliminação") ?
//						"ELIMINACAO" : "RECOLHIMENTO")) // TODO pelo envio do DropdownOption
//				.sigilo(Sigilo.valueOf(classeForm.getSigilo().toUpperCase()))
//				.grauSigilo(grauSigilo)
//
//				//.grauSigilo(GrauSigilo.valueOf(classeForm.getGrauSigilo().toUpperCase()))
//				.build();
//	}
