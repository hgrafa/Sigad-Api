package br.com.sigad.domain.dto.output;

public record ClasseViewDto (
		Long id,
		Long codigo,
		String nome,
		String prazoCorrente,
		String prazoIntermediaria,
		String destinacaoFinal,
		String observacao,
		String sigilo,
		String grauSigilo,
		String permissaoDeUso,
		String indicadorAtiva
) {

}

//	public ClasseDto(DocumentClass classe) {
//		this.id = classe.getId();
//		this.codigo = classe.getCodigo();
//		this.nome = classe.getNome();
//		this.prazoCorrente = classe.getPrazoCorrente();
//		this.destinacaoFinal = classe.getDestinacaoFinal().getParsedText();
//		this.observacao = classe.getObservacao();
//		this.permissaoDeUso = classe.getPermissaoDeUso().getParsedText();
//		this.indicadorAtiva = classe.getIndicadorAtiva().getParsedText();
//		this.sigilo = classe.getSigilo().getParsedText();
//		this.grauSigilo = (classe.getGrauSigilo() != null) ? classe.getGrauSigilo().getParsedText() : null;
//	}
