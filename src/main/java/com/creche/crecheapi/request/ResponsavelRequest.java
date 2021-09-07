package com.creche.crecheapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelRequest {

    private String nome;
    private String idade;
    private String telefone;
    private String cep;
}
