package com.teste.GetaoVagas.empresa.UseCase;

import com.teste.GetaoVagas.empresa.entities.EmpresaEntity;
import com.teste.GetaoVagas.empresa.reposytory.EmpresaRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private final EmpresaRepository empresaRepository;

    public CreateCompanyUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaEntity execute(EmpresaEntity empresaEntity){

        this.empresaRepository.findByUserNameOrEmail(empresaEntity.getUserName(), empresaEntity.getEmail()).ifPresent(
                (user) ->{
                    throw new UserFounExeption();
                }
        );
       return this.empresaRepository.save(empresaEntity);
    }
}
