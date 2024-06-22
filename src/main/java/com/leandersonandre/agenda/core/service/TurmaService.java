package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Turma;
import com.leandersonandre.agenda.core.repository.HorarioRepository;
import com.leandersonandre.agenda.core.repository.TurmaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    HorarioRepository horarioRepository;

    public List<Turma> obterTodos() {
        return turmaRepository.findAll();
    }
    public Optional<Turma> obterPeloId(long id) {
        return turmaRepository.findById(id);
    }

    public void salvar(Turma turma) {
        if (Strings.isBlank(turma.getSemestre())) {
            throw new RuntimeException("Favor informar o nome");
        }
        if (Strings.isBlank(turma.getCodTurma())) {
            throw new RuntimeException("Favor informar o código da turma");
        }
        if (turma.getCurso() == null) {
            throw new RuntimeException("Favor informar o curso");
        }
        turmaRepository.save(turma);
    }

    public void excluirPeloId(long id) {
        horarioRepository.dissociateHorarioFromTurma(id);
        turmaRepository.deleteById(id);
    }
}
