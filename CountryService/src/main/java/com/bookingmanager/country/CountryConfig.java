package com.bookingmanager.country;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class CountryConfig {

	@Bean(name = "mapper")
	public DozerBeanMapper dozerBean() {
		List<String> mappingFiles = Arrays.asList("dozer.xml");

		DozerBeanMapper dozerBean = new DozerBeanMapper();
		dozerBean.setMappingFiles(mappingFiles);
		return dozerBean;
	}
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	public ApiInfo apiInfo(){
		
		 return new ApiInfo(
			       "Hotel Booking API", 
			       "Hotel Booking Country microservice", 
			       "1.0", 
			       "Terms of service", 
				new Contact("Chirag Doda", "www.sapient.com", "chirag.doda@gmail.com"), 
			       "License of API", "API license URL");
	}

}
