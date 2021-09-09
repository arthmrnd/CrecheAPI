package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Crianca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriancaDBRepository  extends MongoRepository<Crianca, String> {
    List<Crianca> findByNomeIn(List<String> nomeCriancas);
}
