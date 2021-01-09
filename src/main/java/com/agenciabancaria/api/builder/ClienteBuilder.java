package com.agenciabancaria.api.builder;

import com.agenciabancaria.api.domain.Cliente;
import com.agenciabancaria.api.rest.dto.ClienteDto;
import com.agenciabancaria.api.service.AgenciaService;
import com.agenciabancaria.api.service.ClienteService;
import com.agenciabancaria.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteBuilder {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaBuilder pessoaBuilder;

    @Autowired
    private AgenciaService agenciaService;

    public Cliente buildEntityFromDto(ClienteDto clienteDto)
    {
        return Cliente
                .builder()
                .pessoa(pessoaBuilder.build(clienteDto.getNome(), clienteDto.getCpfCnpj()))
                .agencia(agenciaService.byId(clienteDto.getAgencia()))
                .build();
    }

    public ClienteDto buildDtoFromEntity(Cliente cliente)
    {
        return ClienteDto
                .builder()
                .id(cliente.getId())
                .nome(cliente.getPessoa().getNome())
                .cpfCnpj(cliente.getPessoa().getCpfCnpj())
                .agencia(cliente.getAgencia().getId())
                .build();
    }
}
