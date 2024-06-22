package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.DiaDaSemana;
import com.leandersonandre.agenda.core.repository.DiaDaSemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaDaSemanaService {

    @Autowired
    DiaDaSemanaRepository diaDaSemanaRepository;

    public List<DiaDaSemana> obterTodos() {
        return diaDaSemanaRepository.findAll();
    }
    public Optional<DiaDaSemana> obterPeloId(long id) {
        return diaDaSemanaRepository.findById(id);
    }
}
