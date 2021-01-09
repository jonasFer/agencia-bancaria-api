package com.agenciabancaria.api.domain.repository;

import com.agenciabancaria.api.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRespository extends JpaRepository<Transacao, Integer> {
}
