package com.teste.GetaoVagas.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Optional;
@EnableMethodSecurity
@Configuration
public class securityConfig {

    @Autowired
    private SecurityFilter securityFilter; // esse é da empresa

    @Autowired
    private SecurityCandidadoFiltro securityCandidadoFiltro; // esse é do caditado
    @Bean // serve para rescrver um metodo que existe ja
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        try {
            httpSecurity.csrf(crsf -> crsf.disable() ).authorizeHttpRequests(auth ->{
                auth.requestMatchers("/candidados/").permitAll()
                        .requestMatchers("/empresa/").permitAll()
                        .requestMatchers("/empresa/autenticacao").permitAll().
                        requestMatchers("/candidados/autenticao").permitAll();
                // aqui vc esta liberando acesso para todos acessar esse endPoints
                auth.anyRequest().authenticated(); // aqui vc esta bloqueando esse endpoint. pq para acessar essa rota o usuario tem que esta logado por exemplo
            })  .addFilterBefore(securityCandidadoFiltro, BasicAuthenticationFilter.class)
                    .addFilterBefore(securityFilter, BasicAuthenticationFilter.class);

            return httpSecurity.build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
