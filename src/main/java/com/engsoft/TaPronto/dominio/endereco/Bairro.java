package com.engsoft.TaPronto.dominio.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BAIRRO", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Bairro {

    @Id
    @Column(name = "COD_BAIRRO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // Caso o código seja auto incrementado
    private Integer codBairro;

    @Column(name = "DCR_BAIRRO", length = 45)
    private String dcrBairro;

    @ManyToOne
    @JoinColumn(name = "COD_CIDADE", nullable = false, referencedColumnName = "COD_CIDADE")
    private Cidade cidade;

    @Override
    public String toString() {
        return "Bairro{" +
                "codBairro=" + codBairro +
                ", dcrBairro='" + dcrBairro + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}

