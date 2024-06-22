package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("inicio")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/inicio");
        // obter valores
        long professores = homeService.obterProfessores();
        long disciplinas = homeService.obterDisciplinas();
        long turmas = homeService.obterTurmas();
        long salas = homeService.obterSalas();
        // adicionar valores
        view.addObject("professores", professores);
        view.addObject("disciplinas", disciplinas);
        view.addObject("turmas", turmas);
        view.addObject("salas", salas);
        return view;
    }

    @GetMapping("inicio/sair")
    public String sair() {
        return "/sair";
    }
}
