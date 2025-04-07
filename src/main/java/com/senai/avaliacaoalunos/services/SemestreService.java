package com.senai.avaliacaoalunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.avaliacaoalunos.entities.Semestre;
import com.senai.avaliacaoalunos.repository.SemestreRepository;

@Service
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public List<Semestre> listar() {
        return semestreRepository.findAll();
    }

    public Semestre salvar(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    public void deletar(Long id) {
        semestreRepository.deleteById(id);
    }
}