package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.repository.DisciplinaRepository;
import com.leandersonandre.agenda.core.repository.ProfessorRepository;
import com.leandersonandre.agenda.core.repository.SalaRepository;
import com.leandersonandre.agenda.core.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HomeService {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public long obterTurmas(){
        long turmas = turmaRepository.count();
        return turmas;
    }

    public long obterSalas(){
        long salas = salaRepository.count();
        return salas;
    }

    public long obterProfessores(){
        long professores = professorRepository.count();
        return professores;
    }

    public long obterDisciplinas(){
        long disciplinas = disciplinaRepository.count();
        return disciplinas;
    }

}
