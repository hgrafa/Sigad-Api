package br.com.sigad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigad.model.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{

}
