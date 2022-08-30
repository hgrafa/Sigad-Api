package br.com.sigad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigad.entities.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

}
