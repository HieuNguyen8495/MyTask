 package com.example.MyTask.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.MyTask"))
				.build()
				.apiInfo(apiInfo());
		}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Home Exercise")
			.description("This project is used for education purpose only.")
			.license("MIT2")
			.build(); }
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header"); }
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(swaggerAuth()).build();}
	
	private List<SecurityReference> swaggerAuth(){
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "use in all request");
		AuthorizationScope[] scopes = new AuthorizationScope[1];
		scopes[0] = authorizationScope;
		
		SecurityReference ref = new SecurityReference("JWT", scopes);
		
		return Arrays.asList(ref);}  
}
