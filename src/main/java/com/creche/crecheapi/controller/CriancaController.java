package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.request.CriancaRequest;
import com.creche.crecheapi.request.CriancaRequestAtualizar;
import com.creche.crecheapi.response.CriancaResponse;
import com.creche.crecheapi.service.CriancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Flux<Crianca> listarTodos(){
        return criancaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Crianca> buscarPorId(@PathVariable String id){
        return criancaService.findById(id);
    }

    @GetMapping("nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Crianca> buscarPorNome(@PathVariable String nome){
        return criancaService.findByNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Crianca> adiiconarCrianca(@RequestBody CriancaRequest criancaRequest) {
        return criancaService.adicionar(criancaRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public Mono<Crianca> atualizar(@RequestBody CriancaRequestAtualizar criancaRequestAtualizar,@PathVariable String id){
        return criancaService.atualizar(criancaRequestAtualizar, id);
    }
}
