package com.Cep.projetoCep.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API REST cadastro de endereco de clientes via CEP")
                        .description("Busca de informacao de endereco de cliente via CEP com integracao da API ViaCEP")
                        .version("v1.04.29")
                        .termsOfService("https://www.linkedin.com/in/gabriel-mascarenhas-/")
                        .license(new License()
                                .name("ApacheCep")
                                .url("https://www.linkedin.com/in/gabriel-mascarenhas-/")));
    }


}
