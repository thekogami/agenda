package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Disciplina d SET d.professor = null WHERE d.professor.id = :professorId")
    void dissociateDisciplinaFromProfessor(@Param("professorId") Long cursoId);

    @Override
    long count();
}
