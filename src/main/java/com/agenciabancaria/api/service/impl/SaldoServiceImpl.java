package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.service.ContaService;
import com.agenciabancaria.api.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoServiceImpl implements SaldoService {

    @Autowired
    private ContaService contaService;

    @Override
    public Double saldo(Integer contaId) {
        Conta conta = contaService.byId(contaId);

        return conta.getSaldo();
    }
}
