package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import jakarta.persistence.*;
import com.engsoft.TaPronto.dominio.endereco.*;
import lombok.*;

@Entity
@Table(name = "EMPREENDIMENTO", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Empreendimento {

    @Id
    @Column(name = "COD_EMPREEDIMENTO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // Caso seja auto incrementado
    private Integer codEmpreendimento;

    @Column(name = "DCR_EMPREENDIMENTO", length = 45)
    private String dcrEmpreendimento;

    @Column(name = "DCR_NOME_FANTASIA", length = 45)
    private String dcrNomeFantasia;

    @Column(name = "DCR_ENDERECO", length = 45)
    private String dcrEndereco;

    @Column(name = "DCR_COMPLEMENTO", length = 45)
    private String dcrComplemento;

    @Column(name = "NUM_CEP", length = 10)
    private String numCep;

    @ManyToOne
    @JoinColumn(name = "COD_CIDADE", nullable = false, referencedColumnName = "COD_CIDADE")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "BAIRRO_COD_BAIRRO", nullable = false, referencedColumnName = "COD_BAIRRO")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "COD_LOCALIDADE", nullable = false, referencedColumnName = "COD_LOCALIDADE")
    private Localidade localidade;

    @Lob
    @Column(name = "IMG_EMPREENDIMENTO")
    private byte[] imgEmpreendimento;

}
