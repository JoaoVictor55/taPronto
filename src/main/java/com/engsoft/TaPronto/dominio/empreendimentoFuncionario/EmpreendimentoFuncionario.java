package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPREND_FUNCIONARIO", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmpreendimentoFuncionario {

    @Id
    @Column(name = "COD_EMPREEND_FUNCIONARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Caso seja auto incrementado
    private Integer codEmpreendFuncionario;

    @Column(name = "TIP_FUNCIONARIO", length = 1)
    private Character tipFuncionario;

    @ManyToOne
    @JoinColumn(name = "COD_EMPREEDIMENTO", nullable = false, referencedColumnName = "COD_EMPREEDIMENTO")
    private Empreendimento empreendimento;

    @ManyToOne
    @JoinColumn(name = "COD_FUNCIONARIO", nullable = false, referencedColumnName = "COD_FUNCIONARIO")
    private Funcionario funcionario;

    @Lob
    @Column(name = "IMG_EMPREEND_FUNCIONARIO")
    private byte[] imgEmpreendFuncionario;

    @Override
    public String toString() {
        return "EmpreendimentoFuncionario{" +
                "codEmpreendFuncionario=" + codEmpreendFuncionario +
                ", tipFuncionario=" + tipFuncionario +
                ", empreendimento=" + empreendimento +
                ", funcionario=" + funcionario +
                '}';
    }
}
