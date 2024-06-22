package com.leandersonandre.agenda.controllers;

import com.leandersonandre.agenda.core.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inicio/periodos")
public class PeriodosController {

    @Autowired
    private PeriodoService periodoService;

    @Autowired
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("periodos/periodos");
        view.addObject("periodos", periodoService.obterTodos());
        return view;
    }
}
