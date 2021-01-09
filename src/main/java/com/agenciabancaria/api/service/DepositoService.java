package com.agenciabancaria.api.service;

import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.rest.dto.MovimentacaoDto;

public interface DepositoService {
    Transacao deposito(MovimentacaoDto depositoDto);
}
