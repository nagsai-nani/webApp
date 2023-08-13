package com.spring.webApp.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
@Bean
public Docket someApi() {
   return (new Docket(DocumentationType.SWAGGER_2)).select().apis(RequestHandlerSelectors.basePackage("com")).paths(PathSelectors.any()).build().apiInfo(getApiInfo());
}
private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
            .title("WebApp API")
            .version("1.0")
            .description("THE PRACTICE PROJECT FOR THE SPRING BOOT API")
            .contact(new Contact("NagaSai.Baliwada", "www.vncit.com", "harrynagsai6@gmail.com"))
            .license("BNS _ V1.0")
            .build();
}
}
