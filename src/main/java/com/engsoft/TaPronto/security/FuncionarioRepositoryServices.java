package com.engsoft.TaPronto.security;

import com.engsoft.TaPronto.dominio.empreendimentoFuncionario.Funcionario;
import com.engsoft.TaPronto.repository.empreendimentoFuncionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioRepositoryServices implements UserDetailsService {

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioRepositoryServices(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      //  System.out.println(username);

        Funcionario usuario = funcionarioRepository.findFuncionarioByDcrEmail(username);

        if(usuario == null){
            throw new UsernameNotFoundException("O nome de usuário: "+username+" não foi encontrado");
        }
        return  usuario;
    }
}
