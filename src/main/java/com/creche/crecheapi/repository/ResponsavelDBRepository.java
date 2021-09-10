package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Responsavel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsavelDBRepository extends MongoRepository<Responsavel, String> {
}
