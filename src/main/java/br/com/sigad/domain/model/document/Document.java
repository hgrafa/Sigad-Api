package br.com.sigad.domain.model.document;

import br.com.sigad.domain.enums.DocumentProcessType;
import br.com.sigad.domain.model.audit.DocumentAudit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID processNumber;

    private DocumentProcessType documentProcessType;

    private String protocolNumber; // TODO: validate with regex

    private String description;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private List<DocumentAudit> audits = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="class_id")
    private DocumentClass documentClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subclass_id")
    private DocumentSubClass documentSubClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private DocumentGroup documentGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subgroup_id")
    private DocumentSubGroup documentSubGroup;

    public String getClassificationNumber() {
        return ""; // TODO concatenate id numbers
    }
}
