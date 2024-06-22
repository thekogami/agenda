package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Cursos;
import com.leandersonandre.agenda.core.service.CursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inicio/cursos")
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping
    public List<Cursos> index(){
        return cursosService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cursos> visualizar(@PathVariable("id") long id){
        return cursosService.obterPeloId(id);
    }

    @GetMapping("/{id}/editar-curso")
    public Optional<Cursos> editar(@PathVariable("id") long id){
        return cursosService.obterPeloId(id);
    }

    @PostMapping("/novo-curso")
    public Cursos criarNovoCurso(@RequestBody Cursos curso){
        curso.setId(0);
        System.out.println("Criando novo curso");
        return cursosService.salvar(curso);

    }

    @PostMapping("/atualizar")
    public Cursos salvar(@RequestBody Cursos cursos){
        return cursosService.salvar(cursos);
    }

    @DeleteMapping("/{id}/excluir")
    public void excluir(@PathVariable("id") long id) {
        cursosService.excluirPeloId(id);
    }
}