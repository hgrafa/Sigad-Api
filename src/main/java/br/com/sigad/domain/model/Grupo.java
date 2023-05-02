package br.com.sigad.domain.model;

import br.com.sigad.domain.enums.Destinacao;
import br.com.sigad.domain.enums.GrauSigilo;
import br.com.sigad.domain.enums.Permissao;
import br.com.sigad.domain.enums.Sigilo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupos")
@Getter @Setter @EqualsAndHashCode
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	private String nome;
	private Long codigo;	
	private String prazoIntermediaria;
	private String prazoCorrente;
	private Boolean indicadorAtiva;
	private String observacao;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacaoFinal;
	
	@Enumerated(EnumType.STRING)
	private Sigilo sigilo;
	
	@Enumerated(EnumType.STRING)
	private GrauSigilo grauSigilo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SubClasse subclasse;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "grupo")
	private List<SubGrupo> subGrupo;
}
