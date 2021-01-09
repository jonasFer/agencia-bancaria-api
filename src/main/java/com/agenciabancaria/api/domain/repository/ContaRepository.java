package com.agenciabancaria.api.domain.repository;

import com.agenciabancaria.api.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findByNumero(Integer integer);
}
