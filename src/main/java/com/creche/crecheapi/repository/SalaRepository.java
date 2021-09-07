package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Sala;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends ReactiveSortingRepository<Sala, Long> {

}
