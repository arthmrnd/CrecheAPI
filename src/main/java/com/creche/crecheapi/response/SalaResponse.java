package com.creche.crecheapi.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SalaResponse {

    private String id;
    private ProfessorResponse professor;
    private List<CriancaResponse> criancas;

}
