package br.com.sigad.domain.dto.input;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record ClasseForm (
	Long codigo,
	@NotBlank(message = "O nome deve estar em branco.")
	String nome,
	String prazoCorrente,
	String prazoIntermediaria,
	String observacao,
	@NotBlank(message = "O indicador da classe ativa ou inativa deve ser preenchido.")
	String indicadorAtiva,
	@NotBlank(message = "A permissão de uso da classe deve ser preenchida.")
	String permissaoDeUso,
	String destinacaoFinal,
	@NotBlank(message = "Selecione o nível de sigilo da classe.")
	String sigilo,
	String grauSigilo
) {

}