package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.entity.Disciplina;
import com.leandersonandre.agenda.core.service.DisciplinaService;
import com.leandersonandre.agenda.core.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080") // Substitua com o URL do seu frontend
@RestController
@RequestMapping("/inicio/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Disciplina> index(){
        return disciplinaService.obterTodos();
    }

    @GetMapping("/{id}")
    public ModelAndView visualizar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("disciplinas/visualizar");
        var opt = disciplinaService.obterPeloId(id);
        opt.ifPresent(entidade -> view.addObject("entidade", entidade));
        return view;
    }

    @GetMapping("/{id}/editar-disciplina")
    public ModelAndView editar(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("disciplinas/editar-disciplina");
        var opt = disciplinaService.obterPeloId(id);
        opt.ifPresent(entidade -> {
            view.addObject("entidade", entidade);
            view.addObject("professores", professorService.obterTodos());
        });
        return view;
    }

    @GetMapping("/nova-disciplina")
    public ModelAndView criarNovaDisciplina(){
        ModelAndView view = new ModelAndView("disciplinas/nova-disciplina");
        view.addObject("entidade", new Disciplina());
        view.addObject("professores", professorService.obterTodos());
        return view;
    }

    @PostMapping("/nova-disciplina")
    public ModelAndView criarNovaDisciplina(@ModelAttribute("entidade") Disciplina disciplina, @RequestParam("professorId") long professorId){
        try {
            var professor = professorService.obterPeloId(professorId).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
            disciplina.setProfessor(professor);
            disciplinaService.salvar(disciplina);
            return new ModelAndView("redirect:/inicio/disciplinas/" + disciplina.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("disciplinas/nova-disciplina");
            model.addObject("erro", e.getMessage());
            model.addObject("entidade", disciplina);
            model.addObject("professores", professorService.obterTodos());
            return model;
        }
    }

    @PostMapping("/atualizar")
    public ModelAndView salvar(@ModelAttribute("entidade") Disciplina disciplina, @RequestParam("professorId") long professorId){
        try {
            var professor = professorService.obterPeloId(professorId).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
            disciplina.setProfessor(professor);
            disciplinaService.salvar(disciplina);
            return new ModelAndView("redirect:/inicio/disciplinas/" + disciplina.getId());
        }catch (Exception e){
            ModelAndView model = new ModelAndView("disciplinas/editar-disciplina");
            model.addObject("erro", e.getMessage());
            model.addObject("entidade", disciplina);
            model.addObject("professores", professorService.obterTodos());
            return model;
        }
    }
    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable("id") long id) {
        disciplinaService.excluirPeloId(id);
        return "redirect:/inicio/disciplinas";
    }
}
