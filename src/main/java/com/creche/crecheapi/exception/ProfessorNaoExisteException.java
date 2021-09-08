package com.creche.crecheapi.exception;

public class ProfessorNaoExisteException extends RuntimeException {
    public ProfessorNaoExisteException(String id){
        super("Professor de id: "+id+", informado não existe");
    }
}
