package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Agencia;
import com.agenciabancaria.api.domain.repository.AgenciaRepository;
import com.agenciabancaria.api.exception.DomainException;
import com.agenciabancaria.api.exception.NotFoundException;
import com.agenciabancaria.api.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Override
    public List<Agencia> all() {
        return agenciaRepository.findAll();
    }

    @Override
    public Agencia byId(Integer id) {
        return this.agenciaRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Agencia create(Agencia agencia) {
        if (agenciaRepository.findByNumero(agencia.getNumero()).isPresent()) {
            throw new DomainException("Agência com mesmo número já cadastrada!");
        }
        return agenciaRepository.save(agencia);
    }
}
