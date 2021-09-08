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
//    @ManyToOne
//    @JoinColumn(name = "id_professor",referencedColumnName = "id_professor")
    private Professor professor;
//    @ManyToOne
//    @JoinColumn(name = "id_crianca", referencedColumnName = "id_crianca")
    private List<Crianca> crianca;

    public Sala(Professor professor, List<Crianca> criancas) {
        this.professor = professor;
        this.crianca = criancas;
    }
}
