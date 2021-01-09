package com.agenciabancaria.api.exception;

public class DomainException extends RuntimeException {
    public DomainException() {
        super("Ocorreu um erro");
    }

    public DomainException(String mensagem) {
        super(mensagem);
    }
}
