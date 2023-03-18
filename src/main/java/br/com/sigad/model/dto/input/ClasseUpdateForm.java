package br.com.sigad.model.dto.input;

import br.com.sigad.model.entities.Classe;
import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Permissao;
import br.com.sigad.model.enums.Sigilo;
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
