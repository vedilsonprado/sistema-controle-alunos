package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.avaliacaoalunos.entities.Disciplina;
import com.senai.avaliacaoalunos.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	private final DisciplinaRepository disciplinaRepository;

	public DisciplinaService(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}

	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}

	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	public void deletar(Long id) {
		disciplinaRepository.deleteById(id);
	}
}
