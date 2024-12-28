package com.teste.GetaoVagas.security;

import com.teste.GetaoVagas.provider.JWTProvider;
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
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private JWTProvider jwtProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String hearder = request.getHeader("Authorization") != null ? request.getHeader("Authorization") : "";

        System.out.println(hearder);

        if (request.getRequestURI().startsWith("/empresa")){
            if(!hearder.isEmpty()){
                var token = this.jwtProvider.validacaoToken(hearder);
                System.out.println(token);
                if(token == null){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// aqui serve para retorna um erro e mao ir para a controller
                    return;
                }
                request.setAttribute("company_id", token.getSubject());
                var roles = token.getClaim("roles").asList(Object.class);
                var grands = roles.stream().map(
                        role-> new SimpleGrantedAuthority("ROLE_" + role.toString()) // isso aqui vc esta meio que dando permissao de quem so é candidado acesse essa roda
                ).toList();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(token, null,grands);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }


       filterChain.doFilter(request,response); // encaminha para a contrller

    }
}
