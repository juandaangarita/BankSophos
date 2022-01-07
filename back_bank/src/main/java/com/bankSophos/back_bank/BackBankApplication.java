package com.bankSophos.back_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.bankSophos.back_bank.*"})
@EnableJpaRepositories(basePackages="com.bankSophos.back_bank.*")
public class BackBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackBankApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurerClients() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/clients").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurerProducts() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurerTransactions() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/transaction").allowedOrigins("http://localhost:4200");
			}
		};
	}

}