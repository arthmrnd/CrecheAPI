package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.request.CriancaRequest;
import com.creche.crecheapi.response.CriancaResponse;
import com.creche.crecheapi.service.CriancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/crianca")
public class CriancaController {

    private final CriancaService criancaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CriancaResponse> listarTodos(){
        return criancaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Crianca> buscarPorId(@PathVariable String id){
        return criancaService.findById(id);
    }

    @GetMapping("/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Crianca> buscarPorNome(@PathVariable String nome){
        return criancaService.findAByName(nome);
    }

    @GetMapping("/{idResponsave}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Crianca> buscarPorResponsavel(@PathVariable String idResponsave){
        return criancaService.findByResponsavel(idResponsave);
    }

    @GetMapping("/todos/{idResponsave}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Crianca> buscarTodosPorResponsavel(@PathVariable String idResponsave){
        return criancaService.findAllByResponsavel(idResponsave);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Crianca> adiiconarCrianca(@RequestBody CriancaRequest criancaRequest) {
        return criancaService.adicionar(criancaRequest);
    }
}
