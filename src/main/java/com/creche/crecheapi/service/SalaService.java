package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.exception.CriancaNaoExisteException;
import com.creche.crecheapi.exception.ProfessorNaoExisteException;
import com.creche.crecheapi.repository.SalaRepository;
import com.creche.crecheapi.request.SalaRequest;
import com.creche.crecheapi.request.SalaRequestAtualizar;
import com.creche.crecheapi.response.SalaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaService{

    private final SalaRepository salaRepository;
    private final CriancaService criancaService;
    private final ProfessorService professorService;

    public Flux<SalaResponse> findAll() {
        return salaRepository.findAll().map(sala -> sala.response(sala, professorService, criancaService));
    }

    public Mono<SalaResponse> findById(String id) {
        return salaRepository.findById(id).map(sala -> sala.response(sala,professorService, criancaService));
    }

    public Mono<Sala> cadastro(SalaRequest salaRequest){
        checkProfessor(salaRequest.getIdProfessor());
        checkCriancas(salaRequest.getIdCriancas());
        return salaRepository.save(salaRequest.convert());
    }

    public Mono<Sala> atualizar (SalaRequestAtualizar salaRequestAtualizar, String id){
        checkProfessor(salaRequestAtualizar.getIdProfessor());
        checkCriancas(salaRequestAtualizar.getIdCriancas());
        return salaRepository.save(salaRequestAtualizar.convert(id));
    }

    private void checkProfessor(String professor) {
        if (!professorService.professorExiste(professor)){
            throw new ProfessorNaoExisteException(professor);
        }
    }

    private void checkCriancas(List<String> criancas) {
        for (String crianca : criancas){
            if (!criancaService.criancaExiste(crianca)) {
                throw new CriancaNaoExisteException(crianca);
            }
        }
    }
}