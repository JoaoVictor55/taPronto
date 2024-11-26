package com.engsoft.TaPronto.dominio.endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LOCALIDADE", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Localidade {

    @Id
    @Column(name = "COD_LOCALIDADE", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // Caso o código seja auto incrementado
    private Integer codLocalidade;

    @Column(name = "DCR_LOCALIDADE", length = 45)
    private String dcrLocalidade;

    @ManyToOne
    @JoinColumn(name = "COD_BAIRRO", nullable = false, referencedColumnName = "COD_BAIRRO")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "LOCALIDADE_COD_LOCALIDADE", nullable = false, referencedColumnName = "COD_LOCALIDADE")
    private Localidade localidadePai;

    @Override
    public String toString() {
        return "Localidade{" +
                "codLocalidade=" + codLocalidade +
                ", dcrLocalidade='" + dcrLocalidade + '\'' +
                ", bairro=" + bairro +
                ", localidadePai=" + (localidadePai != null ? localidadePai.getCodLocalidade() : "null") +
                '}';
    }
}

