package br.com.sigad.domain.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClasseUpdateForm {
	
	private Long codigo;
	private String nome;	
	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	
	// goes to boolean
	private String indicadorAtiva;	
	
	// goes to enums
	private String permissaoDeUso;

	private String destinacaoFinal;
	private String sigilo;
	private String grauSigilo;
	
}
