package com.teste.GetaoVagas.Candidados.UseCase;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.teste.GetaoVagas.Candidados.Dto.AutenticacaoCantidadoDto;
import com.teste.GetaoVagas.Candidados.Dto.AuthCandidateResponseSTO;
import com.teste.GetaoVagas.Candidados.controlers.CanditadoRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AutenficaoCanditadoUseCase {

    @Autowired
    private CanditadoRepository canditadoRepository;

    @Value("${security.token.secret.canditados}")
    private String chaveSecreta ;


    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthCandidateResponseSTO execute(AutenticacaoCantidadoDto autenticacaoCantidadoDto){
        var userName = this.canditadoRepository.findByUserName(autenticacaoCantidadoDto.getUserName()).orElseThrow(
                () -> {
                    throw new UserFounExeption();
                }
        );
        var senha = this.passwordEncoder.matches(autenticacaoCantidadoDto.getSenha(), userName.getSenha());
        if(!senha){
            throw new UserFounExeption();
        }

        Algorithm algorithm = Algorithm.HMAC256(chaveSecreta); // vc que cria a chave
        var token =JWT.create().withIssuer("NomeDAempresa").withExpiresAt(Instant.now().plus(Duration.ofHours(2))) // pra colocar um tempo de duração para o token
                .withClaim("roles", Arrays.asList("canditado"))// isso serve pra falar que é outro tipo de autenficacao, no caso empresa ou canditado
                .withSubject(userName.getId().toString()).sign(algorithm);

        AuthCandidateResponseSTO authCandidateResponseSTO = new AuthCandidateResponseSTO(token,"2 horas" );
        return authCandidateResponseSTO;

    }
}
