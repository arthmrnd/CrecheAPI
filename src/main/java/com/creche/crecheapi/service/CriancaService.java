package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.repository.CriancaRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Service
public class CriancaService {

    private CriancaRepository criancaRepository;

    public Mono<Crianca> findAByName(String name){
        return criancaRepository.findByNome(name);
    }

    public Mono<Crianca> findById(String id){
        return criancaRepository.findById(id);
    }

    public Mono<Crianca> findByResponsavel(Responsavel responsavel){
        return criancaRepository.findByResponsavel(responsavel);
    }

    public Flux<Crianca> findAllByResponsavel(Responsavel responsavel){
        return criancaRepository.findAllByResponsavel(responsavel);
    }

    public Flux<Crianca> findAll(){
        return criancaRepository.findAll();
    }
}
