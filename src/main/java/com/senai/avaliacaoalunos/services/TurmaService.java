package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.avaliacaoalunos.entities.Turma;
import com.senai.avaliacaoalunos.repository.TurmaRepository;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
}