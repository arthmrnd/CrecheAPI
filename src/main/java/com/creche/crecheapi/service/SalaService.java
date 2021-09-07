package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.repository.SalaRepository;
import com.creche.crecheapi.request.SalaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public Mono<Sala> cadastro(SalaRequest salaRequest) {
        Sala salaNova = new Sala();
        return salaRepository.save(salaNova);
    }

    public Flux<Sala> findAll() {
        return salaRepository.findAll();
    }

    public Mono<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }
}
