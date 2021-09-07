package com.creche.crecheapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

import java.util.Collection;
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
    private Collection<Crianca> crianca;

    public Sala(Mono<Professor> professor) {
        this.professor = professor.block();
    }
}
