package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "FUNCIONARIO", schema = "IFOODSOCIAL")
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@AllArgsConstructor
@Setter
@Getter
public class Funcionario implements UserDetails {

    @Id
    @Column(name = "COD_FUNCIONARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Caso seja auto incrementado
    private Integer codFuncionario;

    @Column(name = "senha_usuario")
    private final String senhaUsuario;

    @Column(name = "NOME_FUNCIONARIO", length = 45)
    private String nomeFuncionario;

    @Column(name = "NUM_TELEFONE", length = 15)
    private String numTelefone;

    @Column(name = "DCR_EMAIL", length = 45)
    private String dcrEmail;

    @Override
    public String toString() {
        return "Funcionario{" +
                "codFuncionario=" + codFuncionario +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", numTelefone='" + numTelefone + '\'' +
                ", dcrEmail='" + dcrEmail + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senhaUsuario;
    }

    @Override
    public String getUsername() {
        return this.dcrEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

