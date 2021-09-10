package com.creche.crecheapi.entity;

import com.creche.crecheapi.response.CriancaResponse;
import com.creche.crecheapi.service.ResponsavelService;
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
@Table(value = "crianca")
public class Crianca {

    @Id
    @Column(value = "id_crianca")
    private String id;
    private String nome;
    private String idade;
    private String idResponsavel;

    public CriancaResponse response(Crianca crianca, ResponsavelService responsavelService) {
        return CriancaResponse.builder()
                .id(crianca.getId())
                .nome(crianca.getNome())
                .idade(crianca.getIdade())
                .responsavel(responsavelService.retornaObjetoResponsavel(crianca.getIdResponsavel()))
                .build();
    }
}
