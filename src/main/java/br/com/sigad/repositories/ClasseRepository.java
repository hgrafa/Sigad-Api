package br.com.sigad.repositories;

import br.com.sigad.domain.model.Classe;
import br.com.sigad.domain.enums.Destinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
    Optional<Classe> findByNome(String nome);
    List<Classe> findByDestinacaoFinal(Destinacao destinacao);
}