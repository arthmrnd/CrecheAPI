package com.creche.crecheapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorNaoExisteException extends RuntimeException {
    public ProfessorNaoExisteException(String id){
        super("Professor de id: "+id+", informado não existe");
    }
}
