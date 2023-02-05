package br.com.sigad.model.dto.output;

import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.Permissao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClasseDto {
	private Long codigo;
	private String nome; 
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String destinacaoFinal;
	private String observacao;
	private String sigilo;
	private String grauSigilo;
	
	/*Enum*/
	private String permissaoDeUso;	
	private Boolean indicadorAtiva;
	
	public ClasseDto(Classe classe) {
		this.codigo = classe.getCodigo();
		this.nome = classe.getNome();
		this.prazoCorrente = classe.getPrazoCorrente();

		this.destinacaoFinal = (classe.getDestinacaoFinal() == Destinacao.ELIMINACAO) ? 
				"Eliminação" : "Recolhimento";
		
		this.observacao = classe.getObservacao();
		
		this.permissaoDeUso = (classe.getPermissaoDeUso() == Permissao.ESTRUTURA_HIERARQUICA) ?
				"Estrutura Hierarquica" : "Temporalidade e destinação";
		
		this.indicadorAtiva = classe.getIndicadorAtiva();
		this.sigilo = classe.getSigilo().toString().toLowerCase();
		this.grauSigilo = classe.getGrauSigilo().toString().toLowerCase();
	}
}
