package br.com.sigad.model.dto.output;

import br.com.sigad.model.entities.SubClasse;
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
	private String observacao;
	
	public SubClasseDto (SubClasse subClasse) {
		this.codigo = subClasse.getCodigo();
		this.nome = subClasse.getNome();
		this.prazoCorrente = subClasse.getPrazoCorrente();
		this.prazoIntermediaria = subClasse.getPrazoIntermediaria();
		this.destinacaoFinal = subClasse.getDestinacaoFinal().toString().toLowerCase();
		this.observacao = subClasse.getObservacao();
	}

}
