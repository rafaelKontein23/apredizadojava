package com.teste.GetaoVagas.security;

import com.teste.GetaoVagas.provider.JWTCandidoProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;


@Component
public class SecurityCandidadoFiltro extends OncePerRequestFilter {
    @Autowired
    private JWTCandidoProvider jwtCandidoProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String hearder = request.getHeader("Authorization") != null ? request.getHeader("Authorization") : "";


        if(request.getRequestURI().startsWith("/candidados")){
            if(!hearder.isEmpty()){
                var token = this.jwtCandidoProvider.validarToken(hearder); // aqui é validação
                if(token == null){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                var roles = token.getClaim("roles").asList(Object.class);
                request.setAttribute("cadidado_id", token.getSubject()); // aqui esta setananto o id que vc vai pegar na contrroler
                var grands = roles.stream().map(
                        role-> new SimpleGrantedAuthority("ROLE_" + role.toString()) // isso aqui vc esta meio que dando permissao de quem so é candidado acesse essa roda
                ).toList();
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(token.getSubject(), null,grands);
                SecurityContextHolder.getContext().setAuthentication(auth);


            }
        }


        filterChain.doFilter(request, response); // aqui é quando ele manda para controller

    }
}
