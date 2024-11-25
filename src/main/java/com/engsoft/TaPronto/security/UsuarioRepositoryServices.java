package com.engsoft.TaPronto.security;

import com.engsoft.TaPronto.dominio.usuario.Usuario;
import com.engsoft.TaPronto.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioRepositoryServices implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioRepositoryServices(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Username: "+username+" wasn't found");
        }
        return  usuario;
    }
}
