package com.creche.crecheapi.controller;

import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.request.ResponsavelRequest;
import com.creche.crecheapi.service.ResponsavelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("responsavel")
public class ResponsavelController {

    private final ResponsavelService service;

    @GetMapping("/{id}")
    public Mono<Responsavel> procurarResponsavel(@PathVariable Long id) {
        return service.procurarResponsavel(id);
    }

    @PostMapping("/dd")
    public Mono<Responsavel> cadastrarResponsavel(@RequestBody ResponsavelRequest responsavelRequest) {
        return service.cadastrarResponsavel(responsavelRequest);
    }
}
