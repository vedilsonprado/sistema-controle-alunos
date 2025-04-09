package com.senai.avaliacaoalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.avaliacaoalunos.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}