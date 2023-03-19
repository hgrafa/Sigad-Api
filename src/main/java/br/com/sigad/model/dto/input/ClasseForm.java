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

	@NotBlank(message = "O indicador da classe ativa ou inativa deve ser preenchido.")
	private String indicadorAtiva;

	@NotBlank(message = "A permissão de uso da classe deve ser preenchida.")
	private String permissaoDeUso;

	private String destinacaoFinal;

	@NotBlank(message = "Selecione o nível de sigilo da classe.")
	private String sigilo;

	private String grauSigilo;

}
