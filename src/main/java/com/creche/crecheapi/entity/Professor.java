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
@Table(value = "professor")
public class Professor {

    @Id
    @Column(value = "id_professor")
    private Long id;
    private String nome;
    private String serie;
    private String cep;
}
