package com.creche.crecheapi.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorResponse {

    private String id;
    private String nome;
    private Integer idade;
    private String serie;
    private EnderecoResponse endereco;
}
