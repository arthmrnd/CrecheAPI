package com.creche.crecheapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "responsavel")
public class Responsavel {

    @Id
    @Column(value = "id_responsavel")
    private Long id;
    private String nome;
    private String idade;
    private String telefone;
    private String cep;

    public Responsavel(String nome, String idade, String telefone, String cep) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.cep = cep;
    }
}
