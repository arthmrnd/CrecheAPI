package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Crianca;
import lombok.Data;

import java.util.UUID;

@Data
public class CriancaRequest {

    private String nome;
    private String idade;
    private String idResponsavel;

    public Crianca convert() {

        return Crianca.builder()
                .id(UUID.randomUUID().toString())
                .idResponsavel(this.idResponsavel)
                .nome(this.nome)
                .idade(this.idade)
                .build();
    }
}
