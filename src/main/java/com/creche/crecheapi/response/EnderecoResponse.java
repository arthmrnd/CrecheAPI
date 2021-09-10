package com.creche.crecheapi.response;

import com.creche.crecheapi.entity.Endereco;
import com.creche.crecheapi.webclient.ConsultaEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoResponse response(Endereco endereco, ConsultaEndereco consultaEndereco) {
        var enderecoCompleto = consultaEndereco.getEndereco(endereco.getCep());
        return EnderecoResponse.builder()
                .cep(enderecoCompleto.getCep())
                .logradouro(enderecoCompleto.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(enderecoCompleto.getBairro())
                .localidade(enderecoCompleto.getLocalidade())
                .uf(enderecoCompleto.getUf())
                .build();
    }
}
