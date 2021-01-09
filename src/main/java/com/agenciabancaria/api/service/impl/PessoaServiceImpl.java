package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Pessoa;
import com.agenciabancaria.api.domain.repository.PessoaRepository;
import com.agenciabancaria.api.exception.NotFoundException;
import com.agenciabancaria.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa byCpfCnpj(String cpfCnpj) {
        return repository
                .findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new NotFoundException());
    }
}
