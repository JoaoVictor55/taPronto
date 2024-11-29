package com.engsoft.TaPronto;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;


@SpringBootApplication
public class TaProntoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {

		SpringApplication.run(TaProntoApplication.class, args);

	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/").setViewName("home"); // exibe a tela inicial
		registry.addViewController("/cadastro_empreendimento_sucesso").setViewName("cadastro_empreendimento_sucesso");
	}

}
