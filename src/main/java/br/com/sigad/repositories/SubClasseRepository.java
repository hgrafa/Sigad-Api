package br.com.sigad.repositories;

import br.com.sigad.model.entities.SubClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubClasseRepository extends JpaRepository<SubClasse, Long> {

}
