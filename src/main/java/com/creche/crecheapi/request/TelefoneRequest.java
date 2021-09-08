package com.creche.crecheapi.request;

import com.creche.crecheapi.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneRequest {

    private String numero;
    private String tipo;

    public static List<Telefone> convert(List<TelefoneRequest> telefoneRequest) {
        return telefoneRequest.stream().map(Telefone::new).collect(Collectors.toList());
    }
}