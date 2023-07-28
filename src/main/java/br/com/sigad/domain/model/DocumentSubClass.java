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
@Table(name = "subclasses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentSubClass {

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
	private DocumentClass documentClass;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentSubClass")
	private List<DocumentGroup> documentGroups;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<Document> documents = new ArrayList<>();
	
}
