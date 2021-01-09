package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente byId(Integer id);
    List<Cliente> all();
    Cliente create(Cliente cliente);
    Cliente update(Integer id, Cliente animal);
}
