package br.com.sigad.domain.dto.input;

public record ClasseUpdateForm (
	Long codigo,
	String nome,
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
