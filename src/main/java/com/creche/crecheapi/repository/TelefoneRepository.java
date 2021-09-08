package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Telefone;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends ReactiveMongoRepository<Telefone, String> {
}
