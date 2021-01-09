package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Cliente;
import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.domain.repository.ClienteRepository;
import com.agenciabancaria.api.exception.NotFoundException;
import com.agenciabancaria.api.service.ClienteService;
import com.agenciabancaria.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaService contaService;

    @Override
    public Cliente byId(Integer id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public List<Cliente> all() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente create(Cliente cliente) {
        Cliente clienteBanco = clienteRepository.save(cliente);
        Conta conta = contaService.create(clienteBanco);
        clienteBanco.setConta(conta);

        return clienteBanco;
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        return clienteRepository
                .findById(id)
                .map(clienteBanco -> {
                    cliente.setId(clienteBanco.getId());
                    clienteRepository.save(cliente);
                    return clienteBanco;
                })
                .orElseThrow(() -> new NotFoundException());
    }
}
