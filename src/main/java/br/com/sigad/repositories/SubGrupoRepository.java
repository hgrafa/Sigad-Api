package br.com.sigad.repositories;

import br.com.sigad.model.entities.SubGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {

}
