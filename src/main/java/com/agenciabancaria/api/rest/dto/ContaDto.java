package com.agenciabancaria.api.rest.dto;

import javax.validation.constraints.NotEmpty;

public class ContaDto {
    @NotEmpty(message = "Campo conta obrigatório")
    protected Integer conta;

    public ContaDto(Integer conta) {
        this.conta = conta;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }
}
