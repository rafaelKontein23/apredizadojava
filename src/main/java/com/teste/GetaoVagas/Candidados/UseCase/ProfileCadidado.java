package com.teste.GetaoVagas.Candidados.UseCase;

import com.teste.GetaoVagas.Candidados.Dto.CadidadoProfileResponseDTo;
import com.teste.GetaoVagas.Candidados.controlers.CandidadosEntity;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileCadidado {

    @Autowired
    private CanditadoRepository canditadoRepository;

    public CadidadoProfileResponseDTo execute(UUID idCaditados){
        var cadidado = this.canditadoRepository.findById(idCaditados).orElseThrow(()->{
            throw new UsernameNotFoundException("Erro ao procurar cliente");
        });
        var caditadoProfile = new CadidadoProfileResponseDTo(cadidado.getDescricao(), cadidado.getUsername(), cadidado.getNome());

        return caditadoProfile;

    }
}
