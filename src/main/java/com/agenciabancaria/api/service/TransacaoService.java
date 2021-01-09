package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.domain.enums.TipoTransacao;

public interface TransacaoService {
    Transacao create(Conta conta, Double valor, TipoTransacao tipoTransacao);
}
