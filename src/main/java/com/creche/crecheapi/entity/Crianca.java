package com.creche.crecheapi.entity;

import com.creche.crecheapi.repository.ResponsavelRepository;
import com.creche.crecheapi.response.CriancaResponse;
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

    public CriancaResponse convert(ResponsavelRepository responsavelRepository) {
        Responsavel responsavel = new Responsavel();
        var mono = responsavelRepository.findById(this.idResponsavel);
        mono.subscribe(resp -> Responsavel.builder()
                .id(resp.getId())
                .nome(resp.getNome())
                .idade(resp.getIdade())
                .endereco(resp.getEndereco())
                .build()
                );

        return CriancaResponse.builder()
                .id(this.id)
                .nome(this.nome)
                .idade(this.idade)
                .responsavel(responsavel)
                .build();
    }
}
