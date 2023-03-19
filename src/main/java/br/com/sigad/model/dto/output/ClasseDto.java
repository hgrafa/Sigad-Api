package br.com.sigad.model.dto.output;

import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.Permissao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClasseDto {
	private Long id;
	private Long codigo;
	private String nome; 
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String destinacaoFinal;
	private String observacao;
	private String sigilo;
	private String grauSigilo;
	private String permissaoDeUso;	
	private String indicadorAtiva;
	
	public ClasseDto(Classe classe) {
		this.id = classe.getId();
		this.codigo = classe.getCodigo();
		this.nome = classe.getNome();
		this.prazoCorrente = classe.getPrazoCorrente();
		this.destinacaoFinal = classe.getDestinacaoFinal().getParsedText();
		this.observacao = classe.getObservacao();
		this.permissaoDeUso = classe.getPermissaoDeUso().getParsedText();
		this.indicadorAtiva = classe.getIndicadorAtiva().getParsedText();
		this.sigilo = classe.getSigilo().getParsedText();
		this.grauSigilo = (classe.getGrauSigilo() != null) ? classe.getGrauSigilo().getParsedText() : null;
	}
}
