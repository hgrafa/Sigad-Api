package br.com.sigad.domain.dto.input;

import jakarta.validation.constraints.NotBlank;


public record SubClasseForm (
	@NotBlank Long codigo,
	@NotBlank String nomeClasse,
	@NotBlank String classe,
	String prazoCorrente,
	String prazoIntermediaria,
	String observacao,
	String indicadorAtiva,
	String permissaoDeUso,
	String destinacaoFinal,
	String sigilo,
	String grauSigilo
) {

}
