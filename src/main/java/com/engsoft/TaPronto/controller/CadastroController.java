package com.engsoft.TaPronto.controller;

import com.engsoft.TaPronto.dominio.endereco.Localidade;
import com.engsoft.TaPronto.repository.endereco.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    private LocalidadeRepository localidadeRepository;

    @Autowired
    CadastroController(LocalidadeRepository localidadeRepository){

        this.localidadeRepository = localidadeRepository;
    }

    @GetMapping
    public String exibirInfoCadastro(Model model){

        List<Localidade> localidades = new ArrayList<>();
        this.localidadeRepository.findAll().forEach(localidade -> {
            localidades.add(localidade);
        });

        model.addAttribute("localidades", localidades);

        return "cadastro";
    }

    @PostMapping
    public String login(@ModelAttribute Usuario usuario){



        //Usuario usuario = (Usuario) model.getAttribute("usuario");
        System.out.println(usuario.getSenha());

        return "cadastro";
    }

    public class Usuario{
        private String senha;

        public void setSenha(String senha){
            this.senha = senha;
        }

        public String getSenha(){
            return senha;
        }
    }

}
