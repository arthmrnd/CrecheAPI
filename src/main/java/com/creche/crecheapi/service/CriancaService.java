package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.repository.CriancaRepository;
import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.request.CriancaRequest;
import com.creche.crecheapi.request.CriancaRequestAtualizar;
import com.creche.crecheapi.response.CriancaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CriancaService {

    private final CriancaRepository criancaRepository;
    private final ResponsavelRepository responsavelRepository;

    public Mono<Crianca> findByNome(String nome){
        return criancaRepository.findByNome(nome);
    }

    public Mono<Crianca> findById(String id){
        return criancaRepository.findById(id);
    }

//    public Flux<CriancaResponse> findAll(){
//        return criancaRepository.findAll().map(crianca -> crianca.convert(responsavelRepository));
//    }

    public Flux<Crianca> findAll(){
        return criancaRepository.findAll();
    }

    public Mono<Crianca> adicionar(CriancaRequest criancaRequest) {
        var crianca = criancaRequest.convert();
        return criancaRepository.save(crianca);

    }

    public Mono<Crianca> atualizar(CriancaRequestAtualizar criancaRequest, String id){
        return criancaRepository.save(criancaRequest.convert(id));
    }
}
