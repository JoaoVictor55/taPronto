package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FUNCIONARIO", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Funcionario {

    @Id
    @Column(name = "COD_FUNCIONARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Caso seja auto incrementado
    private Integer codFuncionario;

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
}

