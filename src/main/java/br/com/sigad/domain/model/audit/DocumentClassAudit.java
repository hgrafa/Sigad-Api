package br.com.sigad.domain.model.audit;

import br.com.sigad.domain.enums.DocumentEvent;
import br.com.sigad.domain.model.document.Document;
import jakarta.persistence.*;

import java.time.LocalDate;

public class DocumentClassAudit {

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
