package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.avaliacaoalunos.entities.Aluno;
import com.senai.avaliacaoalunos.entities.Turma;
import com.senai.avaliacaoalunos.repository.AlunoRepository;
import com.senai.avaliacaoalunos.repository.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Aluno> listarTodos() {
		return alunoRepository.findAll();
	}

	public Aluno buscarPorId(Long id) {
		return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	}

	public Aluno salvar(Aluno aluno) {
		Turma turma = turmaRepository.findById(aluno.getTurma().getId())
				.orElseThrow(() -> new RuntimeException("Turma não encontrada"));

		aluno.setTurma(turma); // Agora a turma está gerenciada
		return alunoRepository.save(aluno);
	}

	public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
		Aluno alunoExistente = buscarPorId(id);
		alunoExistente.setNome(alunoAtualizado.getNome());
		return alunoRepository.save(alunoExistente);
	}

	public void deletar(Long id) {
		alunoRepository.deleteById(id);
	}
}
