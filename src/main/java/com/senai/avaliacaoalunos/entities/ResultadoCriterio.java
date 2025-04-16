package com.senai.avaliacaoalunos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado_criterio")
public class ResultadoCriterio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "resultado")
	private String resultado;
	// Valores: "Não Atingido", "Atingido na Avaliação", "Atingido na Recuperação"

	// Getters e Setters
}
