package com.creche.crecheapi.entity;

import com.creche.crecheapi.response.EnderecoResponse;
import com.creche.crecheapi.response.ProfessorResponse;
import com.creche.crecheapi.webclient.ConsultaEndereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "professor")
public class Professor {

    @Id
    @Column(value = "id_professor")
    private String id;
    private String nome;
    private Integer idade;
    private String serie;
    private Endereco endereco;

    public ProfessorResponse response(Professor professor,
                                      EnderecoResponse enderecoResponse, ConsultaEndereco consultaEndereco) {
        return ProfessorResponse.builder()
                .id(professor.id)
                .nome(professor.nome)
                .idade(professor.idade)
                .endereco(enderecoResponse.response(professor.endereco,consultaEndereco))
                .serie(professor.serie)
                .build();
    }
}
