package br.com.sigad.infrastructure.repository;

import br.com.sigad.domain.enums.Destinacao;
import br.com.sigad.domain.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClasseRepository extends JpaRepository<Classe, Long>{
    // TODO optimize with native queries
    Optional<Classe> findByNome(String nome);
    List<Classe> findByDestinacaoFinal(Destinacao destinacao);
}