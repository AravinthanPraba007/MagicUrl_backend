package com.project.magicurl.swagger;

import java.net.URL;

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
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors
				.basePackage("com.project.magicurl"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Magic Url Rest API Documentation")
				.description("Create a temporary, self-destructing short URL for your message or link and Share the generated Magic Url"
						+ "\n Developer : Aravinthan \n")
				.contact(new Contact("Aravinthan", "https://www.linkedin.com/in/aravinthan-p/", null)).build();
	}
}
