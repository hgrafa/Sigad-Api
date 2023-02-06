package br.com.sigad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigad.model.entities.SubGrupo;

@Repository
public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {

}
