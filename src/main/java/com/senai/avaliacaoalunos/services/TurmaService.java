package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.senai.avaliacaoalunos.entities.Aluno;
import com.senai.avaliacaoalunos.entities.Turma;
import com.senai.avaliacaoalunos.repository.AlunoRepository;
import com.senai.avaliacaoalunos.repository.TurmaRepository;

@Service
public class TurmaService {
 
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;


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
    
    public List<Aluno> buscarAlunosPorTurma(@PathVariable Long id) {
        return alunoRepository.findByTurmaId(id);
    }
    
    public ResponseEntity<Aluno> adicionarAlunoNaTurma(@PathVariable Long id, @RequestBody Aluno aluno) {
        Turma turma = turmaRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada"));
        aluno.setTurma(turma); // Lembre que o Aluno tem que ter o campo 'turma' mapeado
        alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

}