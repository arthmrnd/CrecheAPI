package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDBRepository extends MongoRepository<Professor, String> {
}
