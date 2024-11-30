package com.engsoft.TaPronto.Service;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Empreendimento;
import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.EmpreendimentoFuncionario;
import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Funcionario;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.EmpreendimentoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EmpreendimentoFuncionarioService {

    public EmpreendimentoFuncionarioRepository empreendimentoFuncionarioRepository;

    @Autowired
    public EmpreendimentoFuncionarioService(EmpreendimentoFuncionarioRepository empreendimentoFuncionarioRepository){

        this.empreendimentoFuncionarioRepository = empreendimentoFuncionarioRepository;
    }

    public void vincularDonoAEmpreendimento(Empreendimento empreendimento){

        Funcionario dono = (Funcionario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EmpreendimentoFuncionario empreendimentoFuncionario = new EmpreendimentoFuncionario();
        empreendimentoFuncionario.setEmpreendimento(empreendimento);
        empreendimentoFuncionario.setFuncionario(dono);
        empreendimentoFuncionario.setTipFuncionario('D');

        this.empreendimentoFuncionarioRepository.save(empreendimentoFuncionario);
    }
}
