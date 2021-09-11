package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.repository.ResponsavelDBRepository;
import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.repository.TelefoneRepository;
import com.creche.crecheapi.request.ResponsavelRequest;
import com.creche.crecheapi.response.EnderecoResponse;
import com.creche.crecheapi.response.ResponsavelResponse;
import com.creche.crecheapi.webclient.ConsultaEndereco;
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
    private final EnderecoResponse enderecoResponse;
    private final ConsultaEndereco consultaEndereco;

    public Mono<Responsavel> cadastrarResponsavel(ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelRequest.convert();
        responsavelRequest.getTelefone().forEach(telefoneRepository::save);
        return repository.save(responsavel);
    }

    public Mono<ResponsavelResponse> procurarResponsavel(String id) {
        return repository.findById(id).map(responsavel -> responsavel.response(responsavel,enderecoResponse,consultaEndereco));
    }

    public Flux<ResponsavelResponse> listarTodos() {
        return repository.findAll().map(responsavel -> responsavel.response(responsavel,enderecoResponse,consultaEndereco));
    }

    public Mono<Responsavel> atualizarResponsavel(String id, ResponsavelRequest responsavelRequest) {
        var responsavel = responsavelRequest.atualizar(id);
        return repository.save(responsavel);
    }

    public ResponsavelResponse retornaResponsavelResponse(String id) {
        var responsavelOptional = dbRepository.findById(id);
        if (responsavelOptional.isEmpty()) return new ResponsavelResponse();
        else return responsavelOptional.get().response(responsavelOptional.get(),
                enderecoResponse,consultaEndereco);
    }

    public boolean responsavelExiste(String id) {
        return repository.existsById(id).subscribe().isDisposed();
    }
}
