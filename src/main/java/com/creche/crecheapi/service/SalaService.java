package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.repository.CriancaRepository;
import com.creche.crecheapi.repository.ProfessorRepository;
import com.creche.crecheapi.repository.SalaRepository;
import com.creche.crecheapi.request.SalaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SalaService {
    private final SalaRepository salaRepository;
    private final ProfessorRepository professorRepository;
    private final CriancaRepository criancaRepository;

    public Mono<Sala> cadastro(SalaRequest salaRequest){
        //pendente relacionar os dados de Criancas e Professor já cadastrados antes
//        var professor = professorRepository.findById(salaRequest.getIdProfessor());
//        var criancas = criancaRepository.findByNomeIn(salaRequest.getNomeCriancas());
//        var sala = salaRequest.convert(professor, criancas);
        var sala = new Sala(); //para não da erro na hora de subir o código
        return salaRepository.save(sala);
    }

    public Flux<Sala> findAll() {
        return salaRepository.findAllByOrderByProfessor();
    }

    public Mono<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }

}
