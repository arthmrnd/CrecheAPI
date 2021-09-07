package com.creche.crecheapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "sala")
public class Sala {

    @Id
    @Column(value = "id_sala")
    private Long id;
    private Professor professor;
    private List<Crianca> crianca;

    public Sala(Professor professor, List<Crianca> criancas) {
        this.professor = professor;
        this.crianca = criancas;
    }
}
