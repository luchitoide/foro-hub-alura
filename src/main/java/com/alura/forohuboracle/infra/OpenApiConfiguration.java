package com.alura.forohuboracle.infra;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Foro-hub Alura",
        version = "1.0",
        description = "Api Rest recreando algunas de las funcionalidades de un foro.",
        contact = @Contact(name = "Alexis Abarca", url = "https://github.com/AbarcaAlex/")
    )
)
@SecurityScheme(
    name = "bearer token",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"    
)
public class OpenApiConfiguration {

}
