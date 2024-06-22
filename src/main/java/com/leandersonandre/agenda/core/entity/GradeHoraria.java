package com.leandersonandre.agenda.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class GradeHoraria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Horario primeiroHorario;

    @ManyToOne
    private Horario segundoHorario;

    public GradeHoraria(Horario primeiroHorario, Horario segundoHorario) {
        this.primeiroHorario = primeiroHorario;
        this.segundoHorario = segundoHorario;
    }

    public void MostrarGradeHoraria(Logger log) {
        log.info("Grade Horaria De " + primeiroHorario.getData());
        log.info("Curso: " + primeiroHorario.getTurma().getCurso().getNome());
        log.info("Horario: 01");
        log.info("Turma Código: " + primeiroHorario.getTurma().getCodTurma());
        log.info("Turma Semestre: " + primeiroHorario.getTurma().getSemestre());
        log.info("Dia Da Semana: " + primeiroHorario.getDiaDaSemana().getNome());
        log.info("Período: " + primeiroHorario.getPeriodo().getDescricao());
        log.info("Disciplina: " + primeiroHorario.getDisciplina().getNome());
        log.info("Professor: " + primeiroHorario.getProfessor().getNome());
        log.info("Sala: " + primeiroHorario.getSala().getCodigoDaSala());
        log.info("Horario: 02");
        log.info("Turma Código: " + segundoHorario.getTurma().getCodTurma());
        log.info("Turma Semestre: " + segundoHorario.getTurma().getSemestre());
        log.info("Dia Da Semana: " + segundoHorario.getDiaDaSemana().getNome());
        log.info("Período: " + segundoHorario.getPeriodo().getDescricao());
        log.info("Disciplina: " + segundoHorario.getDisciplina().getNome());
        log.info("Professor: " + segundoHorario.getProfessor().getNome());
        log.info("Sala: " + segundoHorario.getSala().getCodigoDaSala());
    }
}
