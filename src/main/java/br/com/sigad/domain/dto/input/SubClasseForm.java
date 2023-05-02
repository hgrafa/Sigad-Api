package br.com.sigad.domain.dto.input;

import br.com.sigad.domain.model.SubClasse;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public class SubClasseForm {
	
	@NotBlank
	private Long codigo;
	
	@NotBlank
	private String nomeClasse;
	
	@NotBlank
	private String classe;
	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	
	// boolean
	private String indicadorAtiva;	
	
	// enums
	private String permissaoDeUso;
	private String destinacaoFinal;
	private String sigilo;
	private String grauSigilo;

}
