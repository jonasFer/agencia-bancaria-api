package com.agenciabancaria.api.rest.controller;

import com.agenciabancaria.api.builder.ClienteBuilder;
import com.agenciabancaria.api.rest.dto.ClienteDto;
import com.agenciabancaria.api.service.ClienteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Cliente")
@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteBuilder clienteBuilder;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDto> all() {
        return service
                .all()
                .stream()
                .map(cliente -> {
                    return clienteBuilder.buildDtoFromEntity(cliente);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDto find(@PathVariable Integer id) {
        return clienteBuilder.buildDtoFromEntity(service.byId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto create(@RequestBody @Valid ClienteDto clienteDto) {
        return clienteBuilder.buildDtoFromEntity(
                service.create(clienteBuilder.buildEntityFromDto(clienteDto))
        );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteDto update(@PathVariable Integer id, @RequestBody @Valid ClienteDto clienteDto) {
        return clienteBuilder.buildDtoFromEntity(
                service.update(id, clienteBuilder.buildEntityFromDto(clienteDto))
        );
    }
}
