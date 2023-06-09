package br.com.sigad.infrastructure.repository;

import br.com.sigad.domain.model.SubGrupo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {
    // TODO optimize with native queries

}
