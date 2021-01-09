package com.agenciabancaria.api.rest.controller;

import com.agenciabancaria.api.domain.Agencia;
import com.agenciabancaria.api.service.AgenciaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Agencia")
@RestController
@RequestMapping("agencia")
public class AgenciaController {

    @Autowired
    private AgenciaService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Agencia> all() {
        return service.all();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Agencia find(@PathVariable Integer id) {
        return service.byId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agencia save(@RequestBody @Valid Agencia agencia) {
        return service.create(agencia);
    }
}
