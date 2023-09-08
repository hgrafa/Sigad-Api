package br.com.sigad.domain.model.document;

import br.com.sigad.domain.model.classifications.Confidentiality;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

	private String code;

	private String name;

	@OneToOne
	@JoinColumn(name = "confidentiality_id")
	private Confidentiality confidentiality = Confidentiality.getInstance();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<DocumentSubClass> documentSubClasses = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "documentClass")
	private List<Document> documents = new ArrayList<>();

}
