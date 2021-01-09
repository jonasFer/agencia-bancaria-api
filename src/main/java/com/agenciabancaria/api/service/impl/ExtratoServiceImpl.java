package com.agenciabancaria.api.service.impl;

import com.agenciabancaria.api.domain.Conta;
import com.agenciabancaria.api.rest.dto.MovimentacaoDto;
import com.agenciabancaria.api.service.ContaService;
import com.agenciabancaria.api.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtratoServiceImpl implements ExtratoService {

    @Autowired
    private ContaService contaService;

    @Override
    public List<MovimentacaoDto> extrato(Integer contaId) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Conta conta = contaService.byId(contaId);

        return conta
                .getTransacoes()
                .stream()
                .map(transacao ->
                    new MovimentacaoDto(
                        transacao.getConta().getId(),
                        transacao.getValor(),
                        dateFormat.format(transacao.getDataCriacao()),
                        transacao.getTipoTransacao()
                    )
                ).collect(Collectors.toList());
    }
}
