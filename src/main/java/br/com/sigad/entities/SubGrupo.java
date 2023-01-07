package br.com.sigad.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sigad.entities.enums.Destinacao;
import br.com.sigad.entities.enums.GrauSigilo;
import br.com.sigad.entities.enums.Permissao;
import br.com.sigad.entities.enums.Sigilo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subgrupos")
@Getter
@Setter
@EqualsAndHashCode
public class SubGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long codigo;
	private String nome;
	private String prazoCorrente;
	private String prazoIntermediaria;
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
	private Grupo grupo;

}
