package com.engsoft.TaPronto.controller;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Empreendimento;
import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.EmpreendimentoFuncionario;
import com.engsoft.TaPronto.dominio.endereco.Bairro;
import com.engsoft.TaPronto.dominio.endereco.Cidade;
import com.engsoft.TaPronto.dominio.endereco.Localidade;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.EmpreendimentoRepository;
import com.engsoft.TaPronto.repository.endereco.BairroRepository;
import com.engsoft.TaPronto.repository.endereco.CidadeRepository;
import com.engsoft.TaPronto.repository.endereco.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cadastro_empreendimento")
public class CadastroEmpreendimento {

    private EmpreendimentoRepository empreendimentoRepository;
    private CidadeRepository cidadeRepository;
    private BairroRepository bairroRepository;
    private LocalidadeRepository localidadeRepository;

    @Autowired
    public CadastroEmpreendimento(EmpreendimentoRepository empreendimentoRepository, CidadeRepository cidadeRepository,
                              BairroRepository bairroRepository, LocalidadeRepository localidadeRepository){

        this.empreendimentoRepository = empreendimentoRepository;
        this.cidadeRepository = cidadeRepository;
        this.bairroRepository = bairroRepository;
        this.localidadeRepository = localidadeRepository;

    }

    @GetMapping
    public String exibirFormularioCadastroEmpreendimento(Model model){

        List<Cidade> cidades = new ArrayList<>();
        List<Bairro> bairros  = new ArrayList<>();
        List<Localidade> localidades = new ArrayList<>();

        this.cidadeRepository.findAll().forEach(cidades::add);
        this.bairroRepository.findAll().forEach(bairros::add);
        this.localidadeRepository.findAll().forEach(localidades::add);

        model.addAttribute("cidades_disponiveis", cidades);
        model.addAttribute("bairros_disponiveis", bairros);
        model.addAttribute("localidades_disponiveis", localidades);

        return "cadastro_empreendimento";

    }

    @PostMapping
    public String processarCadastroEmpreendimento(Empreendimento empreendimento){

        return "";
    }

}
