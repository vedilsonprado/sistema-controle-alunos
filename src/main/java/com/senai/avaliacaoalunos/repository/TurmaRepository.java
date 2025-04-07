package com.senai.avaliacaoalunos.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.avaliacaoalunos.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
}