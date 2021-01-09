package com.agenciabancaria.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {
    private Integer id;
    @NotNull
    private String nome;

    @JsonProperty("cpf_cnpj")
    @NotNull
    private String cpfCnpj;

    @NotNull
    private Integer agencia;
}
