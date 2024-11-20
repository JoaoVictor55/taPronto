package com.engsoft.TaPronto.dominio.empreendimentoFuncionario;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.engsoft.TaPronto.dominio.endereco.Localidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DISPONIBILIDADE", schema = "IFOODSOCIAL")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Disponibilidade {

    @Id
    @Column(name = "COD_DISPONIBILIDADE", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Caso seja auto incrementado
    private Integer codDisponibilidade;

    @Column(name = "NUM_DIA_SEMANA")
    private Integer numDiaSemana;

    @Column(name = "HORA_FIM")
    private LocalDateTime horaFim;

    @Column(name = "HORA_INICIO")
    private LocalDateTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "COD_LOCALIDADE", nullable = false, referencedColumnName = "COD_LOCALIDADE")
    private Localidade localidade;

    @ManyToOne
    @JoinColumn(name = "COD_EMPREEDIMENTO", nullable = false, referencedColumnName = "COD_EMPREEDIMENTO")
    private Empreendimento empreendimento;

}

