package com.teste.GetaoVagas.Candidados.UseCase;

import com.teste.GetaoVagas.Candidados.controlers.CandidadosEntity;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service // aq2ui vc tem que colocar essa anotação pq o spring gerencia o siglo de vida
public class CreateCandidoUSeCase {
    @Autowired
    private CanditadoRepository canditadoRepository;

    public CandidadosEntity  execute(CandidadosEntity candidadosEntity){




        return this.canditadoRepository.save(candidadosEntity);
    }

}
