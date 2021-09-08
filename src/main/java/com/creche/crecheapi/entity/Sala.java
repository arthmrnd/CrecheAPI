package com.creche.crecheapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "sala")
public class Sala {

    @Id
    @Column(value = "id_sala")
    private String id;
    private Professor professor;
    private List<Crianca> criancas;
}
