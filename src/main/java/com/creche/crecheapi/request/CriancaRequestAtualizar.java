package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Crianca;
import lombok.Data;

@Data
public class CriancaRequestAtualizar {

    private String nome;
    private String idade;
    private String idResponsavel;

    public Crianca convert(String id) {
        return Crianca.builder()
                .id(id)
                .nome(nome)
                .idade(idade)
                .idResponsavel(idResponsavel)
                .build();
    }
}
