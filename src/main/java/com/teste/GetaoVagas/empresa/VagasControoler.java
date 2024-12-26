package com.teste.GetaoVagas.empresa;

import com.teste.GetaoVagas.empresa.UseCase.CreateVagasUseCase;
import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vagas")
public class VagasControoler {

    @Autowired
    private CreateVagasUseCase createVagasUseCase;

    @PostMapping("/")
    private ResponseEntity<Object> execute(@Valid @RequestBody VagasEntite vagasEntite){
        try {
            var result = this.createVagasUseCase.execute(vagasEntite);
            return ResponseEntity.ok().body("Vaga cadastrada com sucesso");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("vc fez alguma burrice, ver ai que vc fez e depois me fala");
        }
    }

}
