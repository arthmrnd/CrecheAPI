package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.request.SalaRequest;
import com.creche.crecheapi.request.SalaRequestAtualizar;
import com.creche.crecheapi.response.SalaResponse;
import com.creche.crecheapi.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sala")
public class SalaController {
    private final SalaService salaService;

    @GetMapping(value = "/buscarTodos", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Tuple2<Long, SalaResponse>> buscarTodos(){
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(3));
        Flux<SalaResponse> events = salaService.findAll();
        return Flux.zip(intervalo, events);
    }

    @GetMapping("/buscaPorId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<SalaResponse> buscaPorId(@PathVariable String id){
        return salaService.findById(id);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Sala> cadastro(@RequestBody SalaRequest salaRequest){
        return salaService.cadastro(salaRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public Mono<Sala> atualizar(@RequestBody SalaRequestAtualizar salaRequestAtualizar, @PathVariable String id){
        return salaService.atualizar(salaRequestAtualizar, id);
    }
}
