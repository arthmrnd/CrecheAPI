package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.repository.SalaRepository;
import com.creche.crecheapi.request.SalaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaService {
    private final SalaRepository salaRepository;

    public Mono<Sala> cadastro(SalaRequest salaRequest) {
        Professor professor = new Professor(); //professorRepository.findById(idProfessor); aguardando impl
        List<Crianca> criancas = (List<Crianca>) new Crianca(); //criancaRepository.findById(idCrianca); aguardando impl
        Sala sala = new Sala(professor, criancas);
        return salaRepository.save(sala);
    }

    public Flux<Sala> findAll() {
        return salaRepository.findAllByOrderByProfessor();
    }

    public Mono<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }
}
