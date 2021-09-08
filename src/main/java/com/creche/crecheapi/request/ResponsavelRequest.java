package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Endereco;
import com.creche.crecheapi.entity.Responsavel;
import com.creche.crecheapi.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelRequest {

    private String nome;
    private Integer idade;
    private String cep;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private List<Telefone> telefone;

    public Responsavel convert() {
        return Responsavel.builder()
                .id(UUID.randomUUID().toString())
                .nome(this.nome)
                .idade(this.idade)
                .endereco(Endereco.builder()
                        .idEndereco(UUID.randomUUID().toString())
                        .cep(this.cep)
                        .numero(this.numeroEndereco)
                        .complemento(this.complementoEndereco)
                        .build())
                .telefones(this.telefone)
                .build();
    }
}
