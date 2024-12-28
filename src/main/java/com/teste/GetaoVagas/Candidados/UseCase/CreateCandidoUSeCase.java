package com.teste.GetaoVagas.Candidados.UseCase;

import com.teste.GetaoVagas.Candidados.controlers.CandidadosEntity;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service // aq2ui vc tem que colocar essa anotação pq o spring gerencia o siglo de vida
public class CreateCandidoUSeCase {
    @Autowired
    private CanditadoRepository canditadoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public CandidadosEntity  execute(CandidadosEntity candidadosEntity){
        this.canditadoRepository.findByUserNameOrEmail(candidadosEntity.getUsername(),candidadosEntity.getEmail()).ifPresent(
                (user) ->{
                    throw new UserFounExeption();
                }
        );
        var passowordEncode = this.passwordEncoder.encode(candidadosEntity.getSenha());
        candidadosEntity.setSenha(passowordEncode);
        return this.canditadoRepository.save(candidadosEntity);
    }

}
