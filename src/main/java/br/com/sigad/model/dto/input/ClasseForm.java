package br.com.sigad.model.dto.input;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ClasseForm {

	private Long codigo;

	@NotBlank(message = "O nome deve estar em branco.")
	private String nome;

	private String prazoCorrente;
	private String prazoIntermediaria;
	private String observacao;

	// goes to boolean
	@NotBlank(message = "O indicador ativa deve estar em branco.")
	private String indicadorAtiva;

	// goes to enums
	// TODO
	@NotBlank(message = "O código nome deve estar em branco.")
	private String permissaoDeUso;

	private String destinacaoFinal;

	@NotBlank(message = "O código nome deve estar em branco.")
	private String sigilo;

	private String grauSigilo;

}
