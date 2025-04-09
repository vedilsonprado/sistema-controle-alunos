package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.avaliacaoalunos.entities.CriterioAvaliacao;
import com.senai.avaliacaoalunos.repository.CriterioAvaliacaoRepository;

@Service
public class CriterioAvaliacaoService {

    @Autowired
    private CriterioAvaliacaoRepository repository;

    public List<CriterioAvaliacao> listarTodos() {
        return repository.findAll();
    }

    public CriterioAvaliacao buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public CriterioAvaliacao salvar(CriterioAvaliacao criterioAvaliacao) {
        return repository.save(criterioAvaliacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

