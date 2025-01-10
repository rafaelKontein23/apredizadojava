package com.teste.GetaoVagas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(// isso é pra ativar o swagger
		info = @Info (
				title =  "Gestão de vagas",
				description = "api gestão de vagas ",
				version = "1.0.0"
		)
)
@SecurityScheme(name = "jwt_token",scheme = "bearer",type = SecuritySchemeType.HTTP,bearerFormat = "JWT", in = SecuritySchemeIn.HEADER) // aqui serve para o swegger aceitar auteficação jwt
public class GetaoVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetaoVagasApplication.class, args);
	}

}
