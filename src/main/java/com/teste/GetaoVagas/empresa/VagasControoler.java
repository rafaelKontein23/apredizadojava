package com.teste.GetaoVagas.empresa;

import com.teste.GetaoVagas.empresa.UseCase.CreateVagasUseCase;
import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/empresa")
public class VagasControoler {

    @Autowired
    private CreateVagasUseCase createVagasUseCase;

    @PostMapping("/vagas")
    @PreAuthorize("hasRole('empresa')")
    public ResponseEntity<Object> execute(@Valid @RequestBody VagasEntite vagasEntite, HttpServletRequest request){
        try {
            var companyID = request.getAttribute("company_id");
            vagasEntite.setId_empresa(UUID.fromString(companyID.toString()));
            var result = this.createVagasUseCase.execute(vagasEntite);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("vc fez alguma burrice, ver ai que vc fez e depois me fala");
        }
    }

}
