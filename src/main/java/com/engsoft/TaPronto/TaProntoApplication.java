package com.engsoft.TaPronto;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Funcionario;
import com.engsoft.TaPronto.dominio.endereco.Cidade;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.FuncionarioRepository;
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
	public static FuncionarioRepository funcionarioRepository;

	@Autowired
	public TaProntoApplication(CidadeRepository cidadeRepository, LocalidadeRepository localidadeRepository,
							   FuncionarioRepository funcionarioRepository	){
		TaProntoApplication.cidadeRepository = cidadeRepository;
		TaProntoApplication.localidadeRepository = localidadeRepository;
		TaProntoApplication.funcionarioRepository = funcionarioRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(TaProntoApplication.class, args);
		//System.out.println(funcionarioRepository.findAll());

	}

}
