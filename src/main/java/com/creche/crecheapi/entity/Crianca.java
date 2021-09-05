package com.creche.crecheapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crianca")
public class Crianca {

    @Id
    @Column(name = "id_crianca")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String idade;
    @ManyToOne
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id_responsavel")
    private Responsavel responsavel;
    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    private Sala sala;
}
