package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CriancaNaoExisteException extends RuntimeException {
    public CriancaNaoExisteException(String id){
        super("Criança de id: "+id+", informado não existe!");
    }
}
