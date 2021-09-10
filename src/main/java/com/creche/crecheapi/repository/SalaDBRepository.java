package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalaDBRepository extends MongoRepository <Sala, String> {
}
