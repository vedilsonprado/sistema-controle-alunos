package com.senai.avaliacaoalunos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.senai.avaliacaoalunos.entities.Aluno;
import com.senai.avaliacaoalunos.entities.Turma;
import com.senai.avaliacaoalunos.repository.AlunoRepository;
import com.senai.avaliacaoalunos.repository.TurmaRepository;
import com.senai.avaliacaoalunos.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
    private final TurmaService turmaService;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> listar() {
        return turmaService.listar();
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> buscarAlunosPorTurma(@PathVariable Long id) {
        return alunoRepository.findByTurmaId(id);
    }
    
    @PostMapping("{id}/alunos")
    public ResponseEntity<Aluno> adicionarAlunoNaTurma(@PathVariable Long id, @RequestBody Aluno aluno) {
        Turma turma = turmaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada"));
        aluno.setTurma(turma); // Lembre que o Aluno tem que ter o campo 'turma' mapeado
        alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
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