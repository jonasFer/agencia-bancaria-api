package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Agencia;

import java.util.List;

public interface AgenciaService {
    List<Agencia> all();
    Agencia byId(Integer id);
    Agencia create(Agencia agencia);
}
