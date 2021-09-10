package com.creche.crecheapi.response;

import com.creche.crecheapi.entity.Responsavel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriancaResponse {

    private String id;
    private String nome;
    private String idade;
    private Responsavel responsavel;
}
