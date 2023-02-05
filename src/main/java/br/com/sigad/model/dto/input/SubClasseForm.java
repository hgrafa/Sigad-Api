package br.com.sigad.model.dto.input;

import javax.validation.constraints.NotBlank;

import br.com.sigad.model.entities.SubClasse;
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
	
	public SubClasse toSubClasse() {
		SubClasse subClassEntity = new SubClasse();
		
		subClassEntity.setCodigo(codigo);
		subClassEntity.setNome(nomeClasse);
		subClassEntity.setClasse(null); /*como settar o nome da classe?*/
		
		return subClassEntity;
	
	}

}
