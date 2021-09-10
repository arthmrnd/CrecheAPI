package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Sala;
import lombok.Data;

import java.util.List;

@Data
public class SalaRequestAtualizar {

    private String idProfessor;
    private List<String> idCriancas;

    public Sala convert(String id){
        return Sala.builder()
                .id(id)
                .idProfessor(idProfessor)
                .idCrianca(idCriancas)
                .build();
    }
}
