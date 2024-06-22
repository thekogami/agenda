package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Sala;
import com.leandersonandre.agenda.core.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    public List<Sala> obterTodos() {
        return salaRepository.findAll();
    }

    public Optional<Sala> obterPeloId(long id) {
        return salaRepository.findById(id);
    }

    public Sala salvar(Sala sala) {
        return salaRepository.save(sala);
    }
}