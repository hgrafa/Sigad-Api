package br.com.sigad.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sigad.model.enums.Destinacao;
import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.enums.Permissao;
import br.com.sigad.model.enums.Sigilo;
import lombok.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long codigo;
	private String nome;	
	private String prazoCorrente;
	private String prazoIntermediaria;	
	private String observacao;
	private Boolean indicadorAtiva;	

	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;
	
	@Enumerated(EnumType.STRING)
	private Destinacao destinacaoFinal;
	
	@Enumerated(EnumType.STRING)
	private Sigilo sigilo;
	
	@Enumerated(EnumType.STRING)
	private GrauSigilo grauSigilo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classe")
	private List<SubClasse> subClasses = new ArrayList<>();

}
