package com.agenciabancaria.api.rest.controller.consulta;

import com.agenciabancaria.api.rest.dto.MovimentacaoDto;
import com.agenciabancaria.api.service.ExtratoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Consulta")
@RestController
@RequestMapping("consulta/extrato")
public class ExtratoController {

    @Autowired
    private ExtratoService service;

    @GetMapping("{conta}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MovimentacaoDto> find(@PathVariable Integer conta) {
        return service.extrato(conta);
    }
}
