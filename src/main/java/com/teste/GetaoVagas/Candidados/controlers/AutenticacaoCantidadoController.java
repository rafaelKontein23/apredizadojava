package com.teste.GetaoVagas.Candidados.controlers;

import com.teste.GetaoVagas.Candidados.Dto.AutenticacaoCantidadoDto;
import com.teste.GetaoVagas.Candidados.UseCase.AutenficaoCanditadoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidados")
public class AutenticacaoCantidadoController {

    @Autowired
    private AutenficaoCanditadoUseCase autenficaoCanditadoUseCase;
    @PostMapping("/autenticao")
    @Tag(name = "Autenticação", description = "valida o canditado")
    @Operation(description = "auentenfica o usaurio")
    @SecurityRequirement(name = "jwt_token")
    private ResponseEntity<Object> execute(@Valid @RequestBody AutenticacaoCantidadoDto autenticacaoCantidadoDto){
        try {
            var result = this.autenficaoCanditadoUseCase.execute(autenticacaoCantidadoDto);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
