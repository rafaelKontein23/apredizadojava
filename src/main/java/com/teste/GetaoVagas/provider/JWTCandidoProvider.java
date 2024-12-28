package com.teste.GetaoVagas.provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTCandidoProvider {

    @Value("${security.token.secret.canditados}")
    private String cahveSecreta;

    public DecodedJWT validarToken(String token){
        token = token.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(cahveSecreta);
        try {
            var tokenDecode = JWT.require(algorithm).build().verify(token);
            return tokenDecode;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }

}
