package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public Mono<Sala> cadastro(Sala sala) {
//        return salaRepository.save(sala);
        return null; //para não subir com erro
    }

    public Flux<Sala> findAll() {
//        return salaRepository.findAll();
        return null; //para não subir com erro
    }

    public Mono<Sala> findById(String id) {
//        return salaRepository.findById(id);
        return null; //para não subir com erro
    }
}
