package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.GradeHoraria;
import com.leandersonandre.agenda.core.repository.GradeHorariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GradeHorariaService {

    @Autowired
    GradeHorariaRepository gradeHorariaRepository;

    public List<GradeHoraria> obterTodos() {
        return gradeHorariaRepository.findAll();
    }
    public Optional<GradeHoraria> obterPeloId(long id) {
        return gradeHorariaRepository.findById(id);
    }


    public void salvar(GradeHoraria gradeHoraria) {
        if (Objects.isNull(gradeHoraria.getPrimeiroHorario())) {
            throw new RuntimeException("Favor informar primeiro horário");
        }
        if (Objects.isNull(gradeHoraria.getSegundoHorario())) {
            throw new RuntimeException("Favor informar segundo horário");
        }

        gradeHorariaRepository.save(gradeHoraria);
    }

    public void excluirPeloId(long id) {
        gradeHorariaRepository.deleteById(id);
    }
}