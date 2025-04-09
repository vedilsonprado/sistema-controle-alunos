package com.senai.avaliacaoalunos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "criterio_avaliacao")
public class CriterioAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "tipo_criterio_id")
    private TipoCriterio tipoCriterio;

    @ManyToOne
    @JoinColumn(name = "resultado_criterio_id")
    private ResultadoCriterio resultadoCriterio;

    // Getters e Setters
}
