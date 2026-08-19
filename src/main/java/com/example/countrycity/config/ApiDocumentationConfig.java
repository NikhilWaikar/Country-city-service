package com.example.countrycity.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI countryCityApiDocumentation() {
        return new OpenAPI()
                .info(new Info()
                        .title("Country City API")
                        .version("1.0.0")
                        .description("REST API for countries, cities, city details, and paginated city lists.")
                        .contact(new Contact()
                                .name("Country City Service")));
    }
}
