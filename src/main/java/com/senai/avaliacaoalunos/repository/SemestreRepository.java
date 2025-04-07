package com.senai.avaliacaoalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.avaliacaoalunos.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
}
