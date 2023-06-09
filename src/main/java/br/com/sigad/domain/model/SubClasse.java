package br.com.sigad.domain.model;

import br.com.sigad.domain.enums.Destinacao;
import br.com.sigad.domain.enums.GrauSigilo;
import br.com.sigad.domain.enums.Permissao;
import br.com.sigad.domain.enums.Sigilo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subclasses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
