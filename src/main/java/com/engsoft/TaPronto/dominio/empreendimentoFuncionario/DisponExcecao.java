package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.engsoft.TaPronto.dominio.endereco.Localidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DISPON_EXCECAO", schema = "IFOODSOCIAL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DisponExcecao {

    @Id
    @Column(name = "COD_DISPON_EXCECAO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // Caso seja auto incrementado
    private Integer codDisponExcecao;

    @Column(name = "DATA_EXCECAO")
    private LocalDateTime dataExcecao;

    @Column(name = "TIP_EXCECAO", length = 1)
    private Character tipExcecao;

    @Column(name = "HORA_INICIO")
    private LocalDateTime horaInicio;

    @Column(name = "HORA_FIM")
    private LocalDateTime horaFim;

    @ManyToOne
    @JoinColumn(name = "COD_EMPREEDIMENTO", nullable = false, referencedColumnName = "COD_EMPREEDIMENTO")
    private Empreendimento empreendimento;

    @ManyToOne
    @JoinColumn(name = "COD_LOCALIDADE", nullable = false, referencedColumnName = "COD_LOCALIDADE")
    private Localidade localidade;
}


