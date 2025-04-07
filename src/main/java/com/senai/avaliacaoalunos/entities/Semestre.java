package com.senai.avaliacaoalunos.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // Exemplo: "2024/1", "2024/2"

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Turma> turmas;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}