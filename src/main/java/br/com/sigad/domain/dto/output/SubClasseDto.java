package br.com.sigad.domain.dto.output;

import br.com.sigad.domain.model.SubClasse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class SubClasseDto {

	private Long id;
	private Long codigo;
	private String nome;	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String destinacaoFinal;
	private String observacao;

}
