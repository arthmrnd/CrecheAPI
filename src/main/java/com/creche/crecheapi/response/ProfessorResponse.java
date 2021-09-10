package com.creche.crecheapi.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorResponse {

    private String id;
    private String nome;
    private Integer idade;
    private String serie;
    private EnderecoResponse endereco;
}
