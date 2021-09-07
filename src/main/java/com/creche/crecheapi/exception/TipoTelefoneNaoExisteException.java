package com.creche.crecheapi.exception;

public class TipoTelefoneNaoExisteException extends RuntimeException{
    public TipoTelefoneNaoExisteException(String tipo) {
        super("O tipo digitado, " + tipo + " não é valido");
    }
}
