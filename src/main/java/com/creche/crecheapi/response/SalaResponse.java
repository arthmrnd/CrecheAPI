package com.creche.crecheapi.response;

import com.creche.crecheapi.entity.Crianca;
import com.creche.crecheapi.entity.Professor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SalaResponse {

    private String id;
    private Professor professor;
    private List<Crianca> criancas;

}
