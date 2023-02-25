package br.com.sigad.model.entities;

import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Permissao;
import br.com.sigad.model.enums.Sigilo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

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
