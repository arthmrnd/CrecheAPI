package com.creche.crecheapi.entity;

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
}
