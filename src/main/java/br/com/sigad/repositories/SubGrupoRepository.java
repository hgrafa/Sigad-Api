package br.com.sigad.repositories;

import br.com.sigad.domain.model.SubGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGrupoRepository extends JpaRepository<SubGrupo, Long> {

}
