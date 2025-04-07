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

import com.senai.avaliacaoalunos.entities.Semestre;
import com.senai.avaliacaoalunos.services.SemestreService;

@RestController
@RequestMapping("/semestres")
@CrossOrigin("*")
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping
    public List<Semestre> listar() {
        return semestreService.listar();
    }

    @PostMapping
    public Semestre salvar(@RequestBody Semestre semestre) {
        return semestreService.salvar(semestre);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        semestreService.deletar(id);
    }
}