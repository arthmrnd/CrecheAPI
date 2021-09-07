package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.request.ResponsavelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository repository;

    public Mono<Responsavel> cadastrarResponsavel(ResponsavelRequest responsavelRequest) {
        var responsavel = new Responsavel(
                responsavelRequest.getNome(),
                responsavelRequest.getIdade(),
                responsavelRequest.getTelefone(),
                responsavelRequest.getCep());
        return repository.save(responsavel);
    }

    public Mono<Responsavel> procurarResponsavel(Long id) {
        return repository.findById(id);
    }
}
