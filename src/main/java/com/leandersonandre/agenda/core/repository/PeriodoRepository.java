package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository  extends JpaRepository<Periodo, Long> {
}
