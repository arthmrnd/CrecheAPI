package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoTelefoneNaoExisteException extends RuntimeException{
    public TipoTelefoneNaoExisteException(String tipo) {
        super("O tipo digitado, " + tipo + " não é valido");
    }
}
