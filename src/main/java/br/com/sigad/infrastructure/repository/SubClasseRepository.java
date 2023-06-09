package br.com.sigad.infrastructure.repository;

import br.com.sigad.domain.model.SubClasse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubClasseRepository extends JpaRepository<SubClasse, Long> {
    // TODO optimize with native queries

}
