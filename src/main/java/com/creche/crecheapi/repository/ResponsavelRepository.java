package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Responsavel;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends ReactiveSortingRepository<Responsavel, Long> {
}
