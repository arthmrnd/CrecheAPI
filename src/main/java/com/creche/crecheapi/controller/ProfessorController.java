package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.request.ProfessorRequest;
import com.creche.crecheapi.response.ProfessorResponse;
import com.creche.crecheapi.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService service;

    @GetMapping
    public Flux<ProfessorResponse> listarTodos() {
        return service.listarProfessores();
    }

    @GetMapping("/buscarProfessor/{id}")
    public Mono<ProfessorResponse> procurarProfessor(@PathVariable String id) {
        return service.procurarProfessor(id);
    }

    @PostMapping
    public Mono<Professor> cadastrarProfessor(@RequestBody ProfessorRequest professorRequest) {
        return service.adicionarProfessor(professorRequest);
    }

    @PutMapping("/alterarProfessor/{id}")
    public Mono<Professor> atualizaProfessor(@PathVariable String id,
                                                 @RequestBody ProfessorRequest professorRequest) {
        return service.atualizarProfessor(id, professorRequest);
    }
}
