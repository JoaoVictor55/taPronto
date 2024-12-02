package com.engsoft.TaPronto.controller;

import com.engsoft.TaPronto.Service.EmpreendimentoService;
import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Empreendimento;
import com.engsoft.TaPronto.dominio.endereco.Bairro;
import com.engsoft.TaPronto.dominio.endereco.Cidade;
import com.engsoft.TaPronto.dominio.endereco.Localidade;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.EmpreendimentoRepository;
import com.engsoft.TaPronto.repository.endereco.BairroRepository;
import com.engsoft.TaPronto.repository.endereco.CidadeRepository;
import com.engsoft.TaPronto.repository.endereco.LocalidadeRepository;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cadastro_empreendimento")
public class CadastroEmpreendimentoController {

    private EmpreendimentoService empreendimentoService;
    private CidadeRepository cidadeRepository;
    private BairroRepository bairroRepository;
    private LocalidadeRepository localidadeRepository;

    @Autowired
    public CadastroEmpreendimentoController(EmpreendimentoService empreendimentoService,
            CidadeRepository cidadeRepository,
            BairroRepository bairroRepository, LocalidadeRepository localidadeRepository) {

        this.empreendimentoService = empreendimentoService;
        this.cidadeRepository = cidadeRepository;
        this.bairroRepository = bairroRepository;
        this.localidadeRepository = localidadeRepository;

    }

    @PostMapping
    public String processarCadastroEmpreendimento(Empreendimento empreendimento,
                                                  HttpRequest request) {

        this.empreendimentoService.save(empreendimento);
        return "redirect:/cadastro_empreendimento_sucesso";
    }

    @ModelAttribute("empreendimento")
    public Empreendimento empreendimento() {
        return new Empreendimento();
    }

    @GetMapping
    public String exibirFormularioCadastroEmpreendimento(Model model) {

        List<Cidade> cidades = new ArrayList<>();
        this.cidadeRepository.findAll().forEach(cidades::add);
        model.addAttribute("cidade", cidades);

        List<Bairro> bairros = new ArrayList<>();
        this.bairroRepository.findAll().forEach(bairros::add);
        model.addAttribute("bairro", bairros);

        List<Localidade> localidades = new ArrayList<>();
        this.localidadeRepository.findAll().forEach(localidades::add);
        model.addAttribute("localidade", localidades);

        return "cadastro_empreendimento";

    }

}
