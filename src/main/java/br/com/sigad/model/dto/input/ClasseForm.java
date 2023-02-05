package br.com.sigad.model.dto.input;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class ClasseForm {

	// @NotBlank(message = "O código não deve estar em branco.")
	private Long codigo;
	@NotBlank(message = "O código nome deve estar em branco.")
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
