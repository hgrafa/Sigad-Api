package br.com.sigad.controllers.dto;

import br.com.sigad.entities.Classe;
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
		this.destinacaoFinal = classe.getDestinacaoFinal().toString().toLowerCase();
		this.observacao = classe.getObservacao();
		this.permissaoDeUso = classe.getPermissaoDeUso().toString().toLowerCase();
		this.indicadorAtiva = classe.getIndicadorAtiva();
		this.sigilo = classe.getSigilo().toString().toLowerCase();
		this.grauSigilo = classe.getGrauSigilo().toString().toLowerCase();
	}
}
