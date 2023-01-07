package br.com.sigad.controllers.form;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ClasseForm {

	@NotBlank
	private Long codigo;

	@NotBlank
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
