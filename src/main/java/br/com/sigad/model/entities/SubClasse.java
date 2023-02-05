package br.com.sigad.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Permissao;
import br.com.sigad.model.enums.Sigilo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subclasses")
@Getter @Setter @EqualsAndHashCode
public class SubClasse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	private String nome;
	
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;
	
	private String prazoCorrente;
	
	private String prazoIntermediaria;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacaoFinal;
	
	@Enumerated(EnumType.STRING)
	private Sigilo sigilo;
	
	@Enumerated(EnumType.STRING)
	private GrauSigilo grauSigilo;
	
	private Boolean indicadorAtiva;
	
	private String observacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Classe classe;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "subclasse")
	private List<Grupo> grupos;
	
}
