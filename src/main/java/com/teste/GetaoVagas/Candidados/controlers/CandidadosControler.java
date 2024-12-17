package com.teste.GetaoVagas.Candidados.controlers;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidados")
public class CandidadosControler {

    @PostMapping("/")
    public String criacaoUsuario(@Valid @RequestBody CandidadosEntity cadidatos){

        return cadidatos.getEmail();
    }
}
