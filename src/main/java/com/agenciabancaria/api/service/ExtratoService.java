package com.agenciabancaria.api.service;

import com.agenciabancaria.api.rest.dto.MovimentacaoDto;

import java.util.List;

public interface ExtratoService {
    List<MovimentacaoDto> extrato(Integer contaId);
}
