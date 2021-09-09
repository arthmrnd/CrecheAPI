package com.creche.crecheapi.service;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.entity.Sala;
import com.creche.crecheapi.exception.CriancaNaoExisteException;
import com.creche.crecheapi.exception.ProfessorNaoExisteException;
import com.creche.crecheapi.repository.CriancaDBRepository;
import com.creche.crecheapi.repository.ProfessorDBRepository;
import com.creche.crecheapi.repository.SalaRepository;
import com.creche.crecheapi.request.SalaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SalaService{
    private final SalaRepository salaRepository;
    private final ProfessorDBRepository professorDBRepository;
    private final CriancaDBRepository criancaDBRepository;

    public Flux<Sala> findAll() {
        return salaRepository.findAllByOrderByProfessor();
    }

    public Mono<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }

    public Mono<Sala> cadastro(SalaRequest salaRequest){
        var professor = getProfessor(salaRequest);
        var criancas = getCriancas(salaRequest) ;
        return salaRepository.save(salaRequest.convert(professor, criancas));
    }

    private List<Crianca> getCriancas(SalaRequest salaRequest) {
        var criancas = criancaDBRepository.findByNomeIn(salaRequest.getNomeCriancas());
        if (criancas.contains(null) || criancas.isEmpty()){
            throw new CriancaNaoExisteException();
        }
        return criancas;
    }

    private Professor getProfessor(SalaRequest salaRequest) {
        var professor = professorDBRepository.findById(salaRequest.getIdProfessor());
        if(professor.isEmpty()){
            throw new ProfessorNaoExisteException(salaRequest.getIdProfessor());
        }
        return professor.get();
    }

}
