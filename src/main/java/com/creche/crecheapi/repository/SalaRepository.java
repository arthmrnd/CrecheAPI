package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, String> {

}
