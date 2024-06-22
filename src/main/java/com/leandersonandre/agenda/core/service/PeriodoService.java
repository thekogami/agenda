package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Periodo;
import com.leandersonandre.agenda.core.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoService {

    @Autowired
    PeriodoRepository periodoRepository;

    public List<Periodo> obterTodos() {
        return periodoRepository.findAll();
    }
    public Optional<Periodo> obterPeloId(long id) {
        return periodoRepository.findById(id);
    }
}
