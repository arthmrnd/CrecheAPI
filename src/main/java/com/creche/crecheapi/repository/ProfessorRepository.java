package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Professor;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository  extends ReactiveSortingRepository<Professor, Long> {

}
