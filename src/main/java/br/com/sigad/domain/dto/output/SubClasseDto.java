package br.com.sigad.domain.dto.output;

public record SubClasseDto (
	Long id,
	Long codigo,
	String nome,
	String prazoCorrente,
	String prazoIntermediaria,
	String destinacaoFinal,
	String observacao
) {

}
