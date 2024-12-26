package com.teste.GetaoVagas.Candidados.controlers;


import com.teste.GetaoVagas.Candidados.UseCase.CreateCandidoUSeCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidados")
public class CandidadosControler {

    @Autowired
    private CreateCandidoUSeCase createCandidoUSeCase;

    @PostMapping("/")
    public ResponseEntity<Object> criacaoUsuario(@Valid @RequestBody CandidadosEntity cadidatos){
       try {
           var result =   this.createCandidoUSeCase.execute(cadidatos);
           return ResponseEntity.ok(result);
       }catch (Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
