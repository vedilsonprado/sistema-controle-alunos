package com.senai.avaliacaoalunos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.avaliacaoalunos.entities.CriterioAvaliacao;
import com.senai.avaliacaoalunos.services.CriterioAvaliacaoService;

@RestController
@RequestMapping("/api/criterios-avaliacao")
public class CriterioAvaliacaoController {

    @Autowired
    private CriterioAvaliacaoService service;

    @GetMapping
    public List<CriterioAvaliacao> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CriterioAvaliacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CriterioAvaliacao salvar(@RequestBody CriterioAvaliacao criterioAvaliacao) {
        return service.salvar(criterioAvaliacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}