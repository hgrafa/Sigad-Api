package br.com.sigad.infrastructure.repository;

import br.com.sigad.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    // TODO optimize with native queries

}
