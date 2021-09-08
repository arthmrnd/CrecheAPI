package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Professor;
import com.creche.crecheapi.entity.Sala;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaRequest {
    private String idProfessor;
    private List<String> nomeCriancas;

    public Sala convert(Professor professor, List<Crianca> criancas) {
        return Sala.builder()
                .id(UUID.randomUUID().toString())
                .professor(professor)
                .criancas(criancas)
                .build();
    }

}