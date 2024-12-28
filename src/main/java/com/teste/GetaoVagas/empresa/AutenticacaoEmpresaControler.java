package com.teste.GetaoVagas.empresa;

import com.teste.GetaoVagas.empresa.UseCase.AutenficacaoEmpresaUseCase;
import com.teste.GetaoVagas.empresa.dto.AuteticacaoEmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/empresa")
public class AutenticacaoEmpresaControler {
    @Autowired
    private AutenficacaoEmpresaUseCase autenficacaoEmpresaUseCase;

    @PostMapping("/autenticacao")
    public ResponseEntity<Object> create(@RequestBody AuteticacaoEmpresaDTO autenficacaoEmpresaDTO){
        try {
            var resultado = this.autenficacaoEmpresaUseCase.exeute(autenficacaoEmpresaDTO);
            return  ResponseEntity.ok().body(resultado);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
