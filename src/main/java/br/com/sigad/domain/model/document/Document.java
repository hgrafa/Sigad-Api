package br.com.sigad.domain.model.document;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String protocolNumber; // TODO: validate with regex

    private String descricao; // TODO

    private LocalDate createdAt;
    // TODO: private User createdBy;

    private LocalDate updatedAt;
    // TODO: private User updatedBy;

    private LocalDate deletedAt;
    // TODO: private User deletedBy;

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
