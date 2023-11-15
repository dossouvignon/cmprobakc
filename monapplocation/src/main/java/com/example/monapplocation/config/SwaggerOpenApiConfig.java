package com.example.monapplocation.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerOpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .info(new Info().title("CmPro API")
                        .description("Contact of API.")
                        .version("1.0")
                        .version("1.0").contact(new Contact().name("Vignon Dossou")
                                .email( "dossouvignon82@gmail.com").url("www.vignon.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }

}

