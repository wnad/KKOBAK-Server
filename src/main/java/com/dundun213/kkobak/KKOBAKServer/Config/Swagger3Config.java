package com.dundun213.kkobak.KKOBAKServer.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class Swagger3Config {

    static {
        SpringDocUtils.getConfig()
                .replaceWithSchema(LocalDateTime.class, new StringSchema().example(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .replaceWithSchema(LocalDate.class, new StringSchema().example(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)))
                .replaceWithSchema(LocalTime.class, new StringSchema().example(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)));
    }


    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("kkobak")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI(){

        Info info = new Info()
                .title("kkobak API")
                .description("kkobak 프로젝트 v1 API 명세서입니다.")
                .version("v0.0.1");

        return new OpenAPI()
                .info(info);
    }

}
