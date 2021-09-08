package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Responsavel;
import lombok.Data;

@Data
public class CriancaRequest {

    private String nome;
    private String idade;
    private Responsavel responsavel;

}
