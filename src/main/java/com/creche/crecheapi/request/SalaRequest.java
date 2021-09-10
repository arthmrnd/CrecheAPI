package com.creche.crecheapi.request;

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
    private List<String> idCriancas;

    public Sala convert() {
        return Sala.builder()
                .id(UUID.randomUUID().toString())
                .idProfessor(this.idProfessor)
                .idCrianca(this.getIdCriancas())
                .build();
    }

}