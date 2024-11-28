package com.engsoft.TaPronto.Service;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Empreendimento;
import com.engsoft.TaPronto.dominio.endereco.Bairro;
import com.engsoft.TaPronto.dominio.endereco.Cidade;
import com.engsoft.TaPronto.dominio.endereco.Localidade;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.EmpreendimentoRepository;
import com.engsoft.TaPronto.repository.endereco.BairroRepository;
import com.engsoft.TaPronto.repository.endereco.CidadeRepository;
import com.engsoft.TaPronto.repository.endereco.LocalidadeRepository;
import org.hibernate.engine.jdbc.env.spi.SQLStateType;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
public class EmpreendimentoService {

    private EmpreendimentoRepository empreendimentoRepository;

    @Autowired
    public EmpreendimentoService(EmpreendimentoRepository empreendimentoRepository){
        this.empreendimentoRepository = empreendimentoRepository;


    }

    public List<Empreendimento> findAll(){

        return (List<Empreendimento>) this.empreendimentoRepository.findAll();
    }

    public void save(Empreendimento empreendimento){

        Localidade localidade = empreendimento.getLocalidade();
        Bairro bairro = empreendimento.getBairro();
        Cidade cidade = empreendimento.getCidade();


        Boolean localidadeEhDoBairro = Objects.equals(localidade.getBairro().getCodBairro(), bairro.getCodBairro());
        Boolean bairroEhDaCidade = Objects.equals(bairro.getCidade().getCodCidade(), cidade.getCodCidade());
        if(!localidadeEhDoBairro || ! bairroEhDaCidade){

            throw new IllegalArgumentException(
                    String.format("Erro: localidade %s não pertence ao bairro %s", localidade.getDcrLocalidade(), bairro.getDcrBairro()
                    ));
        }
        else{

            //this.empreendimentoRepository.save(empreendimento);
            System.out.println(empreendimento);
        }

                //Objects.equals(bairro.getCidade().getCodCidade(), cidade.getCodCidade())
    }
}
