package com.teste.GetaoVagas.empresa.UseCase;

import com.teste.GetaoVagas.empresa.entities.EmpresaEntity;
import com.teste.GetaoVagas.empresa.reposytory.EmpresaRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private final EmpresaRepository empresaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreateCompanyUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaEntity execute(EmpresaEntity empresaEntity){

        this.empresaRepository.findByUserNameOrEmail(empresaEntity.getUserName(), empresaEntity.getEmail()).ifPresent(
                (user) ->{
                    throw new UserFounExeption();
                }
        );
        var passoword =  this.passwordEncoder.encode(empresaEntity.getSenha());
        empresaEntity.setSenha(passoword);
       return this.empresaRepository.save(empresaEntity);
    }
}
