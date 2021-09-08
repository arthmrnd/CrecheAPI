package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Sala;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SalaRepository extends ReactiveMongoRepository<Sala, Long> {
    Flux<Sala> findAllByOrderByProfessor();
}
