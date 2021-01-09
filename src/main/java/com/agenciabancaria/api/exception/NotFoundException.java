package com.agenciabancaria.api.exception;

public class NotFoundException extends  RuntimeException {
    public NotFoundException() {
        super("Registro não encontrado");
    }

    public NotFoundException(String mensagem) {
        super(mensagem);
    }

}
