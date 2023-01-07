package br.com.sigad.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
import br.com.sigad.entities.enums.Sigilo;
import lombok.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	private Long codigo;
	private String nome;	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	private Boolean indicadorAtiva;	

	public Classe(Long codigo, String nome, String prazoCorrente, String prazoIntermediaria, String observacao,
			Boolean indicadorAtiva, Permissao permissaoDeUso, Destinacao destinacaoFinal, Sigilo sigilo,
			GrauSigilo grauSigilo) {
		this.codigo = codigo;
		this.nome = nome;
		this.prazoCorrente = prazoCorrente;
		this.prazoIntermediaria = prazoIntermediaria;
		this.observacao = observacao;
		this.indicadorAtiva = indicadorAtiva;
		this.permissaoDeUso = permissaoDeUso;
		this.destinacaoFinal = destinacaoFinal;
		this.sigilo = sigilo;
		this.grauSigilo = grauSigilo;
		this.subClasses = new ArrayList<>();
	}

	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacaoFinal;
	
	@Enumerated(EnumType.STRING)
	private Sigilo sigilo;
	
	@Enumerated(EnumType.STRING)
	private GrauSigilo grauSigilo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classe")
	private List<SubClasse> subClasses;

}
