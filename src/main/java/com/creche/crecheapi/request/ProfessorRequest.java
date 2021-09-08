package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Endereco;
import com.creche.crecheapi.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorRequest {

    private String nome;
    private Integer idade;
    private String serie;
    private String cep;
    private Integer numeroEndereco;
    private String complementoEndereco;

    public Professor convert() {
        return Professor.builder()
                .id(UUID.randomUUID().toString())
                .nome(this.nome)
                .idade(this.idade)
                .serie(this.serie)
                .endereco(Endereco.builder()
                        .idEndereco(UUID.randomUUID().toString())
                        .cep(this.cep)
                        .numero(this.numeroEndereco)
                        .complemento(this.complementoEndereco)
                        .build())
                .build();
    }

    public Professor atualizar(String id) {
        return Professor.builder()
                .id(id)
                .nome(this.nome)
                .idade(this.idade)
                .serie(this.serie)
                .endereco(Endereco.builder()
                        .idEndereco(UUID.randomUUID().toString())
                        .cep(this.cep)
                        .numero(this.numeroEndereco)
                        .complemento(this.complementoEndereco)
                        .build())
                .build();
    }
}
