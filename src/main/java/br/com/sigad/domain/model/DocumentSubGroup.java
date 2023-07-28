package br.com.sigad.domain.model;

import br.com.sigad.domain.enums.Destinacao;
import br.com.sigad.domain.enums.GrauSigilo;
import br.com.sigad.domain.enums.Permissao;
import br.com.sigad.domain.enums.Sigilo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subgroups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentSubGroup {

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
	private DocumentGroup documentGroup;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<Document> documents = new ArrayList<>();

}