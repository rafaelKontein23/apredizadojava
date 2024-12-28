package com.teste.GetaoVagas.Candidados.controlers;


import com.teste.GetaoVagas.Candidados.UseCase.CreateCandidoUSeCase;
import com.teste.GetaoVagas.Candidados.UseCase.ProfileCadidado;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidados")
public class CandidadosControler {

    @Autowired
    private CreateCandidoUSeCase createCandidoUSeCase;

    @Autowired
    private ProfileCadidado profileCadidado;

    @PostMapping("/")
    public ResponseEntity<Object> criacaoUsuario(@Valid @RequestBody CandidadosEntity cadidatos){
       try {
           var result =   this.createCandidoUSeCase.execute(cadidatos);
           return ResponseEntity.ok(result);
       }catch (Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('canditado')")
    public ResponseEntity<Object> get(HttpServletRequest request){
        var idcandidado = request.getAttribute("cadidado_id");
       try {
           var profile = this.profileCadidado.execute(UUID.fromString(idcandidado.toString()));
           return ResponseEntity.ok().body(profile);
       }catch (Exception e){
           e.getMessage();
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

}
