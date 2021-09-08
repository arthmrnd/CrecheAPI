package com.creche.crecheapi.repository;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Responsavel;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

public interface CriancaRepository extends ReactiveSortingRepository<Crianca, String> {

    Mono<Crianca> findByNome(String nome);
    Mono<Crianca> findByResponsavel(Responsavel responsavel);
    Flux<Crianca> findAllByResponsavel(Responsavel responsavel);
    Mono<List<Crianca>> findByNomeIn(List<String> criancas);
}
