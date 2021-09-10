package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CriancaJaTemSalaException extends RuntimeException {
    public CriancaJaTemSalaException(String crianca) {
        super("Criança de id: "+crianca+", já está cadastrada em outra sala!");
    }
}
