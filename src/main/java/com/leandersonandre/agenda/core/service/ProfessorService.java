package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.repository.DisciplinaRepository;
import com.leandersonandre.agenda.core.repository.HorarioRepository;
import com.leandersonandre.agenda.core.repository.ProfessorRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    HorarioRepository horarioRepository;

    public List<Professor> obterTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> obterPeloId(long id) {
        return professorRepository.findById(id);
    }

    public Professor salvar(Professor professor) {
        if(Strings.isBlank(professor.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        if(Strings.isBlank(professor.getSobrenome())){
            throw new RuntimeException("Favor informar o sobrenome");
        }
        if(Strings.isBlank(professor.getEmail())){
            throw new RuntimeException("Favor informar o email");
        }
        return professorRepository.save(professor);
    }

    public void excluirPeloId(long professorId) {
        disciplinaRepository.dissociateDisciplinaFromProfessor(professorId);
        horarioRepository.dissociateHorarioFromProfessor(professorId);
        professorRepository.deleteById(professorId);
    }
}