package com.creche.crecheapi.exception;

public class CriancaNaoExisteException extends RuntimeException {
    public CriancaNaoExisteException(String nome){
        super("Criança de nome: "+nome+", não existe!");
    }
}
