package com.engsoft.TaPronto.dominio.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CIDADE", schema = "IFOODSOCIAL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {

    @Id
    @Column(name = "COD_CIDADE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // Caso o código seja auto incrementado
    private Integer codCidade;

    @Column(name = "DCR_CIDADE", length = 45)
    private String dcrCidade;

    @Override
    public String toString() {
        return "Cidade{" +
                "codCidade=" + codCidade +
                ", dcrCidade='" + dcrCidade + '\'' +
                '}';
    }
}
