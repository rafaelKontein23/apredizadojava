package com.teste.GetaoVagas.empresa;


import com.teste.GetaoVagas.empresa.UseCase.CreateCompanyUseCase;
import com.teste.GetaoVagas.empresa.entities.EmpresaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaControler {

    @Autowired
    private CreateCompanyUseCase empresaService;

    @PostMapping("/")
    private ResponseEntity<Object> empresa( @Valid @RequestBody EmpresaEntity empresaEntity){
        try {
            var result = this.empresaService.execute(empresaEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
