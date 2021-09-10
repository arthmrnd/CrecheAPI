package com.creche.crecheapi.entity;

import com.creche.crecheapi.response.SalaResponse;
import com.creche.crecheapi.service.CriancaService;
import com.creche.crecheapi.service.ProfessorService;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
@Table(value = "sala")
public class Sala {

    @Id
    @Column(value = "id_sala")
    private String id;
    private String idProfessor;
    private List<String> idCrianca;

    public SalaResponse response(Sala sala, ProfessorService professorService, CriancaService criancaService){
        return SalaResponse.builder()
                .id(sala.getId())
                .professor(professorService.retornaObjetoProfessor(sala.getIdProfessor()))
                .criancas(criancaService.retornaObjetoCrianca(sala.getIdCrianca()))
                .build();
    }

}
