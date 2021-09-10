package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.repository.ProfessorRepository;
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
    private final ProfessorRepository professorRepository;

    public Mono<Sala> cadastro(SalaRequest salaRequest) {
        var professor = professorRepository.findById(salaRequest.getIdProfessor());
//        var sala = new Sala(professor);
//        return salaRepository.save(sala);
        return null;
    }

    public Flux<Sala> findAll() {
        return salaRepository.findAllByOrderByProfessor();
    }

    public Mono<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }
}
