package com.agenciabancaria.api.rest.dto;

import com.agenciabancaria.api.domain.enums.TipoTransacao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovimentacaoDto extends ContaDto {
    @NotEmpty(message = "Campo valor obrigatório")
    private Double valor;

    private String data;

    private TipoTransacao tipoTransacao;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public MovimentacaoDto(Integer conta, Double valor, String data, TipoTransacao tipoTransacao) {
        super(conta);
        this.valor = valor;
        this.data = data;
        this.tipoTransacao = tipoTransacao;
    }
}
