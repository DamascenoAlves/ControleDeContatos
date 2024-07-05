package br.com.mda.ControleDecontatos.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes("bearerAuth",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")
                        )
                )
                .info(
                        new Info()
                                .title("App de cadastro de pessoas e contatos")
                                .description("Este app faz controle de cadastro de pessoas" +
                                        " bem como o cadastro e controle de seus contatos telefonicos.")
                                .contact(new Contact()
                                        .name("Matheus Damasceno Alves")
                                        .email("matheusd.alves@hotmail.com")
                                        .url("https://github.com/DamascenoAlves")
                                )
                                .version("Versão 0.0.1-SNAPSHOT")
                );
                //.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));

    }
}
