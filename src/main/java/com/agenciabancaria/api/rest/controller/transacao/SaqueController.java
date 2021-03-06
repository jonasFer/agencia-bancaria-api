package com.agenciabancaria.api.rest.controller.transacao;

import com.agenciabancaria.api.domain.Transacao;
import com.agenciabancaria.api.rest.dto.MovimentacaoDto;
import com.agenciabancaria.api.rest.dto.SaldoDto;
import com.agenciabancaria.api.service.SaqueService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Transações")
@RestController
@RequestMapping("transacao/saque")
public class SaqueController {

    @Autowired
    private SaqueService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaldoDto create(@RequestBody @Valid MovimentacaoDto movimentacaoDto) {
        Transacao transacao = service.saque(movimentacaoDto);
        return new SaldoDto(transacao.getConta().getNumero(), transacao.getConta().getSaldo());
    }
}
