package com.teste.GetaoVagas.empresa.UseCase;

import com.teste.GetaoVagas.empresa.entities.VagasEntite;
import com.teste.GetaoVagas.empresa.reposytory.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateVagasUseCase {
    @Autowired
    private VagasRepository vagasRepository;

    public VagasEntite
    execute(
            VagasEntite vagasEntite
    ){
      return  this.vagasRepository.save(vagasEntite);
    }
}
