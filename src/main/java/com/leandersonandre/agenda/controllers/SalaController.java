package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Sala;
import com.leandersonandre.agenda.core.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inicio/salas")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> index(){
        return salaService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Sala> visualizar(@PathVariable("id") long id){
        return salaService.obterPeloId(id);
    }

    @PostMapping("/nova-sala")
    public Sala criarNovaSala(@RequestBody Sala sala){
        sala.setId(0);
        return salaService.salvar(sala);
    }
}