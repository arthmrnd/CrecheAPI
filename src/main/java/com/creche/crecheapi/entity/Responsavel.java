package com.creche.crecheapi.entity;

import com.creche.crecheapi.response.EnderecoResponse;
import com.creche.crecheapi.response.ResponsavelResponse;
import com.creche.crecheapi.webclient.ConsultaEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
@Table(value = "responsaveis")
public class Responsavel {

    @Id
    @Column(value = "id_responsavel")
    private String id;
    private String nome;
    private Integer idade;
    private Endereco endereco;
    private List<Telefone> telefones;

    public ResponsavelResponse response(Responsavel responsavel,
                                        EnderecoResponse enderecoResponse, ConsultaEndereco consultaEndereco) {
        return ResponsavelResponse.builder()
                .id(responsavel.id)
                .nome(responsavel.nome)
                .idade(responsavel.idade)
                .endereco(enderecoResponse.response(responsavel.endereco,consultaEndereco))
                .telefones(responsavel.getTelefones())
                .build();
    }
}
