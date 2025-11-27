package io.github.filiperodrigues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//configuração para gerar documentação swagger
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30) // OpenAPI 3.0
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.filiperodrigues.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
