package br.com.sigad.domain.model;

import br.com.sigad.domain.enums.*;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long codigo;
	private String nome;

	private IndicadorAtiva indicadorAtiva;

	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacaoFinal;
	
	@Enumerated(EnumType.STRING)
	private Sigilo sigilo;
	
	@Enumerated(EnumType.STRING) @Nullable
	private GrauSigilo grauSigilo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<DocumentSubClass> documentSubClasses = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<Document> documents = new ArrayList<>();

}
