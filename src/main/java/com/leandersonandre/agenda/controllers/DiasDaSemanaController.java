package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.service.DiaDaSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inicio/dias-da-semana")
public class DiasDaSemanaController {

    @Autowired
    private DiaDaSemanaService diaDaSemanaService;

    @Autowired
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("dias-da-semana/dias-da-semana");
        view.addObject("semana", diaDaSemanaService.obterTodos());
        return view;
    }
}
