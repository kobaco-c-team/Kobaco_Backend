package com.kobaco.kobaco_project.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Default Server URL")
})
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("API")
                .addOpenApiCustomizer(openApi -> openApi.info(
                        new Info()
                                .title("Kobaco API")
                                .version("1.0")
                                .description("Kobaco C팀 API 명세")
                )).pathsToMatch("/api/**")
                .build();
    }

}
