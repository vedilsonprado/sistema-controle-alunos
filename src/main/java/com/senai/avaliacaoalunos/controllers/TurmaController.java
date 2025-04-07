package com.senai.avaliacaoalunos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.avaliacaoalunos.entities.Turma;
import com.senai.avaliacaoalunos.services.TurmaService;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> listar() {
        return turmaService.listar();
    }

    @PostMapping
    public Turma salvar(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        turmaService.deletar(id);
    }
}