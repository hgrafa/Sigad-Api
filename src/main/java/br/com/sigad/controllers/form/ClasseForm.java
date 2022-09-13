package br.com.sigad.controllers.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
import br.com.sigad.entities.enums.Sigilo;

public class ClasseForm {

	private Long codigo;
	private String nome;	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	
	private String indicadorAtiva;	
	
	private String permissaoDeUso;
	private String destinacaoFinal;
	private String sigilo;
	private String grauSigilo;
	
	
}
