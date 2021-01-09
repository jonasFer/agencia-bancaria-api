package com.agenciabancaria.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo número não pode ser nulo")
    @Min(value = 1, message = "Campo número não pode ser menor que 1")
    private Integer numero;

    @JsonIgnore
    @OneToMany(mappedBy="agencia")
    private List<Cliente> clientes;
}
