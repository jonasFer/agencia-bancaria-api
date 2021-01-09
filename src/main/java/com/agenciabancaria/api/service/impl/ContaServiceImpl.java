package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Cliente;
import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.enums.TipoTransacao;
import com.agenciabancaria.api.domain.repository.ContaRepository;
import com.agenciabancaria.api.exception.NotFoundException;
import com.agenciabancaria.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository repository;

    @Override
    public Conta create(Cliente cliente) {
        Conta conta = new Conta()
                .builder()
                .numero(new Random().nextInt(Integer.MAX_VALUE) + 1)
                .saldo(0.00)
                .cliente(cliente)
                .build();

        return repository.save(conta);
    }

    @Override
    public Conta byNumero(Integer numero) {
        return repository
                .findByNumero(numero)
                .orElseThrow(() -> new NotFoundException("Agência não encontrada"));
    }

    @Override
    public Conta updateSaldo(Conta conta, Double valor, TipoTransacao tipoTransacao) {
        Double valorNovo = tipoTransacao == TipoTransacao.DEPOSITO
                ? conta.getSaldo() + valor
                : conta.getSaldo() - valor;

        conta.setSaldo(valorNovo);
        return repository.save(conta);
    }
}
