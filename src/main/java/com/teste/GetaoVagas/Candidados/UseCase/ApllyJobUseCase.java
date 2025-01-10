package com.teste.GetaoVagas.Candidados.UseCase;

import com.teste.GetaoVagas.Candidados.Entity.AplyJobEntity;
import com.teste.GetaoVagas.Candidados.Repository.ApplyJobRepository;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import com.teste.GetaoVagas.empresa.reposytory.VagasRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApllyJobUseCase {


    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private CanditadoRepository canditadoRepository;

    @Autowired
    private VagasRepository  vagasRepository ;

    public AplyJobEntity execute(UUID idCaditado, UUID idVaga){
        this.canditadoRepository.findById(idCaditado).orElseThrow(()->{
            throw  new UserFounExeption();
        });

        this.vagasRepository.findById(idVaga).orElseThrow(() ->{
           throw  new UserFounExeption();
        });

        var vagaaply = new AplyJobEntity (idCaditado,idVaga);

        vagaaply = this.applyJobRepository.save(vagaaply);
        return vagaaply;

    }

}
