package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.repository.ProfessorDBRepository;
import com.creche.crecheapi.repository.ProfessorRepository;
import com.creche.crecheapi.request.ProfessorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;
    private final ProfessorDBRepository dbRepository;

    public Mono<Professor> adicionarProfessor(ProfessorRequest professorRequest) {
        var professor = professorRequest.convert();
        return repository.save(professor);
    }

    public Flux<Professor> listarProfessores() {
        return repository.findAll();
    }

    public Mono<Professor> procurarProfessor(String id) {
        return repository.findById(id);
    }

    public Mono<Professor> atualizarProfessor(String id, ProfessorRequest professorRequest) {
        var professor = professorRequest.atualizar(id);
        return repository.save(professor);
    }

    public Professor retornaObjetoProfessor(String id){
        var professorOptional = dbRepository.findById(id);
        if (professorOptional.isEmpty()) return new Professor();
        else return professorOptional.get();
    }

    public boolean professorExiste(String id){
        return dbRepository.existsById(id);
    }
}
