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
@Table(value = "crianca")
public class Crianca {

    @Id
    @Column(value = "id_crianca")
    private String nome;
    private String idade;
//    @ManyToOne
//    @JoinColumn(name = "id_responsavel", referencedColumnName = "id_responsavel")
    private Responsavel responsavel;
//    @ManyToOne
//    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    private Sala sala;
}
