package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@ToString
public class FormularioRegistro {

    private final String senhaFuncionario;
    private String nomeFuncionario;
    private String numTelefone;
    private String dcrEmail;
    private String dcrCpf;

    public Funcionario paraFuncionario(PasswordEncoder passwordEncoder){
        return new Funcionario(passwordEncoder.encode(senhaFuncionario), nomeFuncionario, numTelefone,
                dcrEmail);
    }
}

