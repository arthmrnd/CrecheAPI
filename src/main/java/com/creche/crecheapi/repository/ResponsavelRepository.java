package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Responsavel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends ReactiveMongoRepository<Responsavel, String> {
}
