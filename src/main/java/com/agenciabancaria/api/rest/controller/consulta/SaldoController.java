package com.agenciabancaria.api.rest.controller.consulta;

import com.agenciabancaria.api.rest.dto.SaldoDto;
import com.agenciabancaria.api.service.SaldoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Consulta")
@RestController
@RequestMapping("consulta/saldo")
public class SaldoController {
    @Autowired
    private SaldoService service;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public SaldoDto find(@PathVariable Integer id) {
        Double saldo = service.saldo(id);
        return new SaldoDto(id, saldo);
    }
}
