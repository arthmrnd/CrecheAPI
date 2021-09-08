package com.creche.crecheapi.entity;

import com.creche.crecheapi.exception.TipoTelefoneNaoExisteException;
import com.creche.crecheapi.request.TelefoneRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
@Table(value = "telefone")
public class Telefone {

    @Id
    @Column(value = "numero_telefone")
    private String numero;
    private String tipo;
    @JsonIgnore
    private Responsavel responsavel;

    public Telefone(TelefoneRequest telefoneRequest) {
        this.numero = telefoneRequest.getNumero();
        if(telefoneRequest.getTipo().equalsIgnoreCase("fixo")) {
            this.tipo = String.valueOf(TipoTelefone.FIXO);
        } else if (telefoneRequest.getTipo().equalsIgnoreCase("celular")) {
            this.tipo = String.valueOf(TipoTelefone.CELULAR);
        } else if (telefoneRequest.getTipo().equalsIgnoreCase("comercial")) {
            this.tipo = String.valueOf(TipoTelefone.COMERCIAL);
        } else {
            throw new TipoTelefoneNaoExisteException(telefoneRequest.getTipo());
        }
    }
}
