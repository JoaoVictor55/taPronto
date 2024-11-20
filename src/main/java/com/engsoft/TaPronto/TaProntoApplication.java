package com.engsoft.TaPronto;

import com.engsoft.TaPronto.dominio.endereco.Cidade;
import com.engsoft.TaPronto.repository.endereco.CidadeRepository;
import com.engsoft.TaPronto.repository.endereco.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class TaProntoApplication {


	public static CidadeRepository cidadeRepository;
	public static LocalidadeRepository localidadeRepository;

	@Autowired
	public TaProntoApplication(CidadeRepository cidadeRepository, LocalidadeRepository localidadeRepository){
		TaProntoApplication.cidadeRepository = cidadeRepository;
		TaProntoApplication.localidadeRepository = localidadeRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(TaProntoApplication.class, args);

		Optional<Cidade> cidade = TaProntoApplication.cidadeRepository.findById(1);
		System.out.println(cidade.get().getDcrCidade());

	}

}
