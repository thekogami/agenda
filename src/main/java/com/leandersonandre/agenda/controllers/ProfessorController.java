package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inicio/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professoresService;

    @GetMapping
    public List<Professor> index(){
        return professoresService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Professor> visualizar(@PathVariable("id") long id){
        return professoresService.obterPeloId(id);
    }

    @GetMapping("/{id}/editar-professor")
    public Optional<Professor> editar(@PathVariable("id") long id){
        return professoresService.obterPeloId(id);
    }

    @PostMapping("/novo-professor")
    public Professor criarNovoProfessor(@RequestBody Professor professor){
        try {
            System.out.println(professor);
            professor.setId(0);
            Professor savedProfessor = professoresService.salvar(professor);
            return savedProfessor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/atualizar")
    public Professor salvar(@RequestBody Professor professor){
        try {
            Professor savedProfessor = professoresService.salvar(professor);
            return savedProfessor;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}/excluir")
    public void excluir(@PathVariable("id") long id) {
        professoresService.excluirPeloId(id);
    }
}