package br.com.sigad.domain.model;

import br.com.sigad.domain.enums.Destinacao;
import br.com.sigad.domain.enums.GrauSigilo;
import br.com.sigad.domain.enums.Permissao;
import br.com.sigad.domain.enums.Sigilo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subgrupos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
