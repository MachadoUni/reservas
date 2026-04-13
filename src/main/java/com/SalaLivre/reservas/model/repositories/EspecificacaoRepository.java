package com.SalaLivre.reservas.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SalaLivre.reservas.model.entities.Especificacao;

@Repository
public interface EspecificacaoRepository extends CrudRepository<Especificacao, Long> {

    Iterable<Especificacao> findByNome(String nome);
    
}
