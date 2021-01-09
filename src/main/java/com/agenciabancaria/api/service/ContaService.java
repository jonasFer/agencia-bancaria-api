package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Cliente;
import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.enums.TipoTransacao;

public interface ContaService {
    Conta create(Cliente cliente);
    Conta byId(Integer id);
    Conta updateSaldo(Conta conta, Double valor, TipoTransacao tipoTransacao);
}
