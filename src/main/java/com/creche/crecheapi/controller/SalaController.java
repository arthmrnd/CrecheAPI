package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.request.SalaRequest;
import com.creche.crecheapi.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Flux<Tuple2<Long, Sala>> buscarTodos(){
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(3));
        Flux<Sala> events = salaService.findAll();
        return Flux.zip(intervalo, events);
    }

    @GetMapping("/buscaPorId/{id}")
    public Mono<Sala> buscaPorId(@PathVariable Long id){
        return salaService.findById(id);
    }

    @PostMapping("/cadastro")
    public Mono<Sala> cadastro(@RequestBody SalaRequest salaRequest){
        return salaService.cadastro(salaRequest);
    }
}
