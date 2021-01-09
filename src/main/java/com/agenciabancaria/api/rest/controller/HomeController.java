package com.agenciabancaria.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "API Funcionando! acesse https://agenciabancaria-api.herokuapp.com/swagger-ui.html " +
                "para documentação do Swagger";
    }
}
