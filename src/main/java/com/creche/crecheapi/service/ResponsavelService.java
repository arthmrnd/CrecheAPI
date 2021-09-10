package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.repository.ResponsavelDBRepository;
import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.repository.TelefoneRepository;
import com.creche.crecheapi.request.ResponsavelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository repository;
    private final ResponsavelDBRepository dbRepository;
    private final TelefoneRepository telefoneRepository;

    public Mono<Responsavel> cadastrarResponsavel(ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelRequest.convert();
        responsavelRequest.getTelefone().forEach(telefoneRepository::save);
        return repository.save(responsavel);
    }

    public Mono<Responsavel> procurarResponsavel(String id) {
        return repository.findById(id);
    }

    public Flux<Responsavel> listarTodos() {
        return repository.findAll();
    }

    public Mono<Responsavel> atualizarResponsavel(String id, ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelRequest.atualizar(id);
        return repository.save(responsavel);
    }

    public Responsavel retornaObjetoResponsavel(String id) {
        var responsavelOptional = dbRepository.findById(id);
        if (responsavelOptional.isEmpty()) return new Responsavel();
        else return responsavelOptional.get();
    }

    public Boolean responsavelExiste(String id) {
        return dbRepository.existsById(id);
    }
}
