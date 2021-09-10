package com.creche.crecheapi.response;

import com.creche.crecheapi.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelResponse {

    private String id;
    private String nome;
    private Integer idade;
    private EnderecoResponse endereco;
    private List<Telefone> telefones;


}
