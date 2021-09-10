package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.repository.ProfessorDBRepository;
import com.creche.crecheapi.repository.ProfessorRepository;
import com.creche.crecheapi.request.ProfessorRequest;
import com.creche.crecheapi.response.EnderecoResponse;
import com.creche.crecheapi.response.ProfessorResponse;
import com.creche.crecheapi.webclient.ConsultaEndereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;
    private final EnderecoResponse enderecoResponse;
    private final ConsultaEndereco consultaEndereco;
    private final ProfessorDBRepository dbRepository;

    public Mono<Professor> adicionarProfessor(ProfessorRequest professorRequest) {
        var professor = professorRequest.convert();
        return repository.save(professor);
    }

    public Flux<ProfessorResponse> listarProfessores() {
        return repository.findAll().map(professor -> professor.response(professor,enderecoResponse,consultaEndereco));
    }

    public Mono<ProfessorResponse> procurarProfessor(String id) {
        return repository.findById(id).map(professor -> professor.response(professor,enderecoResponse,consultaEndereco));
    }

    public Mono<Professor> atualizarProfessor(String id, ProfessorRequest professorRequest) {
        var professor = professorRequest.atualizar(id);
        return repository.save(professor);
    }

    public ProfessorResponse retornaProfessorResponse(String id){
        var professorOptional = dbRepository.findById(id);
        if (professorOptional.isEmpty()) return new ProfessorResponse();
        else return professorOptional.get().response(professorOptional.get(),enderecoResponse,consultaEndereco);
    }

    public boolean professorExiste(String id){
        return dbRepository.existsById(id);
    }
}
