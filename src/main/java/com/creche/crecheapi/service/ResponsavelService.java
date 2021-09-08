package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Endereco;
import com.creche.crecheapi.entity.Responsavel;
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
    private final TelefoneRepository telefoneRepository;

    public Mono<Responsavel> cadastrarResponsavel(ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelRequest.convert();
        for(int i = 0; i < responsavelRequest.getTelefone().size(); i++) {
            telefoneRepository.save(responsavelRequest.getTelefone().get(i));
        }
        return repository.save(responsavel);
    }

    public Mono<Responsavel> procurarResponsavel(String id) {
        return repository.findById(id);
    }

    public Flux<Responsavel> listarTodos() {
        return repository.findAll();
    }

    public Mono<Responsavel> atualizarResponsavel(String id, ResponsavelRequest responsavelRequest) {
        var responsavel = Responsavel.builder()
                .id(id)
                .nome(responsavelRequest.getNome())
                .idade(responsavelRequest.getIdade())
                .endereco(Endereco.builder()
                        .idEndereco(repository.findById(id).map(Responsavel::getId).toString())
                        .cep(responsavelRequest.getCep())
                        .numero(responsavelRequest.getNumeroEndereco())
                        .complemento(responsavelRequest.getComplementoEndereco())
                        .build())
                .build();
        return repository.save(responsavel);
    }
}
