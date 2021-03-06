package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Responsavel;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface CriancaRepository extends ReactiveSortingRepository<Crianca, String> {

    Mono<Crianca> findByNome(String nome);
    Mono<Crianca> findByIdResponsavel(String idResponsavel);
    Flux<Crianca> findAllByIdResponsavel(String idResponsavel);
    Mono<List<Crianca>> findByNomeIn(List<String> criancas);
}
