package com.engsoft.TaPronto.controller;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Empreendimento;
import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.FormularioRegistro;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroFuncionarioController {

    private FuncionarioRepository funcionarioRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    CadastroFuncionarioController(FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder){

        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public String exibirInfoCadastro(Model model){

        return "cadastro";
    }

    @PostMapping
    public String processarCadastro(FormularioRegistro formularioRegistro){



        this.funcionarioRepository.save(formularioRegistro.paraFuncionario(this.passwordEncoder));

        return "redirect:/cadastro_empreendimento";
    }
}
