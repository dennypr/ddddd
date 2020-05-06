package com.javarest.rest;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
        
        @Bean
         public Docket api() {
             return new Docket(DocumentationType.SWAGGER_2).select()
                 .apis(RequestHandlerSelectors
                     .basePackage("com.javarest"))
                 .paths(PathSelectors.regex("/.*"))
                 .build().apiInfo(apiDetails());
         }
               
        private ApiInfo apiDetails(){            
          return new ApiInfo("Rest API","Rest API","1.0",
                  "Free to Use", 
                  new springfox
                          .documentation.service
                          .Contact("Denny Prayudi","081291305506","Denny_pr091@yahoo.com"),
                           "API License","Javarest",Collections.emptyList());            
        }
}
