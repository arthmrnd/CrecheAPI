package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProfessorJaTemSalaException extends RuntimeException {
    public ProfessorJaTemSalaException(String professor) {
        super("Professor de id: "+professor+", já está cadastrado em outra sala!");
    }
}
