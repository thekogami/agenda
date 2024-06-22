package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Cursos;
import com.leandersonandre.agenda.core.repository.CursosRepository;
import com.leandersonandre.agenda.core.repository.TurmaRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService {

    @Autowired
    CursosRepository cursosRepository;

    @Autowired
    private TurmaRepository turmaRepository;


    public List<Cursos> obterTodos() {
        return cursosRepository.findAll();
    }
    public Optional<Cursos> obterPeloId(long id) {
        return cursosRepository.findById(id);
    }

    public Cursos salvar(Cursos curso) {
        if(Strings.isBlank(curso.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        cursosRepository.save(curso);
        return curso;
    }
    @Transactional
    public void excluirPeloId(long cursoId) {
        turmaRepository.dissociateTurmasFromCurso(cursoId);
        cursosRepository.deleteById(cursoId);
    }
}
