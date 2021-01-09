package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.domain.enums.TipoTransacao;
import com.agenciabancaria.api.domain.repository.TransacaoRespository;
import com.agenciabancaria.api.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRespository respository;

    @Override
    public Transacao create(Conta conta, Double valor, TipoTransacao tipoTransacao) {
        return respository.save(
                new Transacao()
                        .builder()
                        .valor(valor)
                        .conta(conta)
                        .tipoTransacao(tipoTransacao)
                        .dataCriacao(new Date())
                        .build()
        );
    }
}
