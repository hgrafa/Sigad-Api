package br.com.sigad.domain.model.audit;

import br.com.sigad.domain.enums.DocumentEvent;
import br.com.sigad.domain.model.document.Document;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "document_audits")
public class DocumentAudit<T, T_EVENTS> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentEvent documentEvent;

    private LocalDate moment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

}
