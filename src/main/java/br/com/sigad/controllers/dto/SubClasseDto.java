package br.com.sigad.controllers.dto;

import br.com.sigad.entities.SubClasse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SubClasseDto {
	
	private Long codigo;
	private String nome;	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String destinacaoFinal;
	
	public SubClasseDto (SubClasse subClasse) {
		this.codigo = subClasse.getCodigo();
		this.nome = subClasse.getNome();
		this.prazoCorrente = subClasse.getPrazoCorrente();
		this.prazoIntermediaria = subClasse.getPrazoIntermediaria();
		this.destinacaoFinal = subClasse.getDestinacaoFinal().toString().toLowerCase();
	}

}
