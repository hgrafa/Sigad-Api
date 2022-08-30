package br.com.sigad.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sigad.entities.enums.Permissao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter @Setter @EqualsAndHashCode
public class Classe {
	
	@Id
	private Long id; 

	private String nome;
	
	private String faseCorrente;
	private String faseIntermediaria;
	private String destinacaoFinal;
	
	private Boolean status;
	
	@Enumerated(EnumType.STRING)
	private Permissao permissaoDeUso;

}
