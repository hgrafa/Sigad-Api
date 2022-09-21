package br.com.sigad.controllers.form;

import javax.validation.constraints.NotBlank;

import br.com.sigad.entities.Classe;
import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
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
	private String permissaoDeUso;

	private String destinacaoFinal;
	private String sigilo;
	private String grauSigilo;
	
	public Classe toClasse() {
		Classe classeEntity = new Classe();
	
		classeEntity.setIndicadorAtiva(indicadorAtiva.equalsIgnoreCase("ativo"));
		
		classeEntity.setCodigo(codigo);
		classeEntity.setNome(nome);
		classeEntity.setPrazoCorrente(prazoCorrente);
		classeEntity.setPrazoIntermediaria(prazoIntermediaria);
		classeEntity.setObservacao(observacao);
		// ...
		
		// modelo de enum

		classeEntity.setDestinacaoFinal(Destinacao.valueOf(destinacaoFinal.toUpperCase()));
		classeEntity.setSigilo(Sigilo.valueOf(sigilo.toUpperCase()));
		classeEntity.setGrauSigilo(GrauSigilo.valueOf(grauSigilo.toUpperCase()));//verify underline
		
		return classeEntity;
	}
	
}
