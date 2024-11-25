package com.engsoft.TaPronto.repository.usuario;

import com.engsoft.TaPronto.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

   // @Query("select Usuario from Usuario where nome_usuario = ?1")
    public Usuario findByNomeUsuario(String nome);
}
