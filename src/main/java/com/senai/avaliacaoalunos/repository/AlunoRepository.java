package com.senai.avaliacaoalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.avaliacaoalunos.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
