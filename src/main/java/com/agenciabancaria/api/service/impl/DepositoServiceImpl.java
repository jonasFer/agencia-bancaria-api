package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.domain.enums.TipoTransacao;
import com.agenciabancaria.api.rest.dto.MovimentacaoDto;
import com.agenciabancaria.api.service.ContaService;
import com.agenciabancaria.api.service.DepositoService;
import com.agenciabancaria.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImpl implements DepositoService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private TransacaoService transacaoService;

    @Override
    public Transacao deposito(MovimentacaoDto depositoDto) {
        Conta conta = contaService.byNumero(depositoDto.getConta());
        Transacao transacao = transacaoService.create(conta, depositoDto.getValor(), TipoTransacao.DEPOSITO);
        contaService.updateSaldo(conta, depositoDto.getValor(), TipoTransacao.DEPOSITO);

        return transacao;
    }
}
