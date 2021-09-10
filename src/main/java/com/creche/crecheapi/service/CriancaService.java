package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.repository.CriancaRepository;
import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.request.CriancaRequest;
import com.creche.crecheapi.response.CriancaResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CriancaService {

    private final CriancaRepository criancaRepository;
    private final ResponsavelRepository responsavelRepository;

    public Mono<Crianca> findAByName(String name){
        return criancaRepository.findByNome(name);
    }

    public Mono<Crianca> findById(String id){
        return criancaRepository.findById(id);
    }

    public Mono<Crianca> findByResponsavel(String idResponsavel){
        return criancaRepository.findByIdResponsavel(idResponsavel);
    }

    public Flux<Crianca> findAllByResponsavel(String idResponsave){
        return criancaRepository.findAllByIdResponsavel(idResponsave);
    }

    public Flux<CriancaResponse> findAll(){
        return criancaRepository.findAll().map(crianca -> crianca.convert(responsavelRepository));
    }

    public Mono<Crianca> adicionar(CriancaRequest criancaRequest) {
        var crianca = criancaRequest.convert();
        return criancaRepository.save(crianca);

    }
}
