package com.agenciabancaria.api.rest.dto;

public class SaldoDto extends ContaDto {
    private Double saldo;

    public SaldoDto(Integer conta, Double saldo) {
        super(conta);
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
