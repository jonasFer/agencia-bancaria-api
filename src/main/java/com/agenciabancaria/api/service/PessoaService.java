package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Pessoa;

public interface PessoaService {
    Pessoa byCpfCnpj(String cpfCnpj);
}
