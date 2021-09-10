package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResponsavelNaoExisteException extends RuntimeException {
    public ResponsavelNaoExisteException(String id) {
        super("Responsavel id:"+id+" não existe.");
    }
}
