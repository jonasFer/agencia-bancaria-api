package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.domain.enums.TipoTransacao;
import com.agenciabancaria.api.exception.DomainException;
import com.agenciabancaria.api.rest.dto.MovimentacaoDto;
import com.agenciabancaria.api.service.ContaService;
import com.agenciabancaria.api.service.SaqueService;
import com.agenciabancaria.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaqueServiceImpl implements SaqueService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private TransacaoService transacaoService;

    @Override
    public Transacao saque(MovimentacaoDto movimentacaoDto) {
        Conta conta = contaService.byId(movimentacaoDto.getConta());

        if (conta.getSaldo() < movimentacaoDto.getValor()) {
            throw new DomainException("Valor maior que o saldo atual");
        }

        Transacao transacao = transacaoService.create(conta, movimentacaoDto.getValor(), TipoTransacao.SAQUE);
        contaService.updateSaldo(conta, movimentacaoDto.getValor(), TipoTransacao.SAQUE);

        return transacao;
    }
}
