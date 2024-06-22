package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursosRepository   extends JpaRepository<Cursos, Long> {
}
