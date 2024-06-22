package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository   extends JpaRepository<Sala, Long> {

    @Override
    long count();
}
