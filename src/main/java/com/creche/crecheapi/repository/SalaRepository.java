package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Sala;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends ReactiveMongoRepository<Sala, String> {

}
