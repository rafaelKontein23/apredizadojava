package com.teste.GetaoVagas.empresa.UseCase;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.teste.GetaoVagas.empresa.dto.AuteticacaoEmpresaDTO;
import com.teste.GetaoVagas.empresa.reposytory.EmpresaRepository;
import com.teste.GetaoVagas.exeptions.UserFounExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AutenficacaoEmpresaUseCase {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Value("${security.token.secret}")
    private String chaveSecreta ;

    @Autowired
    private PasswordEncoder passwordEncoder ;
    public String exeute(AuteticacaoEmpresaDTO autenficacaoEmpresaDTO) throws AuthenticationException {
        var company = this.empresaRepository.findByUserName(autenficacaoEmpresaDTO.getUserName()).orElseThrow(// aqui serve se ele nao encontrar essa informacao ele vai para exeption
                () -> {
                    throw new UserFounExeption();
                }
        );
        // verififca a senha
       var password = this.passwordEncoder.matches(autenficacaoEmpresaDTO.getSenha(), company.getSenha()); // o objtivo de usar isso é pq a senha que está no banco esta criptografada e isso serve para fazer a verificao mesmo com elea criptografada
        if(!password){
            throw new AuthenticationException();
        }
        Algorithm algorithm = Algorithm.HMAC256(chaveSecreta); // vc que cria a chave
        var token =JWT.create().withIssuer("NomeDAempresa").withExpiresAt(Instant.now().plus(Duration.ofHours(2))) // pra colocar um tempo de duração para o token
                .withSubject(company.getId().toString()).sign(algorithm); // para ciar o token jwt
        return token;
    }
}
