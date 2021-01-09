package com.agenciabancaria.api.builder;

import com.agenciabancaria.api.domain.Pessoa;
import org.springframework.stereotype.Service;

@Service
public class PessoaBuilder {

    public Pessoa build(String nome, String cpfCnpj) {
        return new Pessoa(nome, cpfCnpj);
    }
}
