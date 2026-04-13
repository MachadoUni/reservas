package com.SalaLivre.reservas.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SalaLivre.reservas.model.entities.*;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {
    
    Iterable<Sala> findByNome(String nome);
}
