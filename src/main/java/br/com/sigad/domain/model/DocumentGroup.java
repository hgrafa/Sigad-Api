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
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentGroup {
	
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
	private DocumentSubClass documentSubClass;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentGroup")
	private List<DocumentSubGroup> documentSubGroups = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<Document> documents = new ArrayList<>();
}
