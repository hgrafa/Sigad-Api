package br.com.sigad.controllers.form;

import javax.validation.constraints.NotBlank;

import br.com.sigad.entities.Classe;
import br.com.sigad.entities.enums.Sigilo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClasseForm {
	
	@NotBlank
	private Long codigo;
	
	@NotBlank
	private String nome;	
	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	
	// boolean
	private String indicadorAtiva;	
	
	// enums
	private String sigilo;
	private String grauSigilo;
	private String destinacaoFinal;
	private String permissaoDeUso;
	
	public Classe toClasse() {
		Classe classeEntity = new Classe();
	
		classeEntity.setIndicadorAtiva(indicadorAtiva.equalsIgnoreCase("ativo"));
		
		classeEntity.setCodigo(codigo);
		classeEntity.setNome(nome);
		// ...
		
		// modelo de enum
		classeEntity.setSigilo(Sigilo.valueOf(sigilo.toUpperCase()));
		
		return classeEntity;
	}
	
}
