package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.exception.ResponsavelNaoExisteException;
import com.creche.crecheapi.repository.CriancaRepository;
import com.creche.crecheapi.request.CriancaRequest;
import com.creche.crecheapi.request.CriancaRequestAtualizar;
import com.creche.crecheapi.response.CriancaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CriancaService {

    private final CriancaRepository criancaRepository;
    private final ResponsavelService responsavelService;

    public Mono<CriancaResponse> findByNome(String nome){
        return criancaRepository.findByNome(nome).map(crianca -> crianca.response(crianca,responsavelService));
    }

    public Mono<CriancaResponse> findById(String id){
        return criancaRepository.findById(id).map(crianca -> crianca.response(crianca,responsavelService));
    }

    public Flux<CriancaResponse> findAll(){
        return criancaRepository.findAll().map(crianca -> crianca.response(crianca,responsavelService));
    }

    public Mono<Crianca> adicionar(CriancaRequest criancaRequest) {
        if (responsavelService.responsavelExiste(criancaRequest.getIdResponsavel())) {
            var crianca = criancaRequest.convert();
            return criancaRepository.save(crianca);
        } else {
            throw new ResponsavelNaoExisteException(criancaRequest.getIdResponsavel());
        }
    }

    public Mono<Crianca> atualizar(CriancaRequestAtualizar criancaRequest, String id){
        return criancaRepository.save(criancaRequest.convert(id));
    }

    public List<CriancaResponse> retornaCriancaResponse(List<String> idCrianca) {
        List<CriancaResponse> criancaResponseList = new ArrayList<>();
        criancaRepository.findAllById(idCrianca).subscribe(crianca -> criancaResponseList
                .add(crianca.response(crianca, responsavelService)));
        return criancaResponseList;
    }

    public boolean criancaExiste(String nomeCriancas) {
        return criancaRepository.existsById(nomeCriancas).subscribe().isDisposed();
    }

}
