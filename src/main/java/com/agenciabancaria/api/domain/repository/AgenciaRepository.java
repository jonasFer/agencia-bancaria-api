package com.agenciabancaria.api.domain.repository;

import com.agenciabancaria.api.domain.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
    Optional<Agencia> findByNumero(Integer numero);
}
