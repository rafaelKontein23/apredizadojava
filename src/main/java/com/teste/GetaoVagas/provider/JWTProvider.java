package com.teste.GetaoVagas.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {
    @Value("${security.token.secret}")
    private String chaveSecreta ;
    public DecodedJWT validacaoToken(String token){
        token = token.replace("Bearer ", "").replace("Bearer:", "");
        Algorithm algorithm = Algorithm.HMAC256(chaveSecreta); // vc que cria a chave

        try {
            var tokenDecoded = JWT.require(algorithm).build().verify(token);
            return tokenDecoded;
        }catch (JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }
}
