package com.ronaldo.dojos_y_ninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaldo.dojos_y_ninjas.models.Dojo;
import com.ronaldo.dojos_y_ninjas.services.DojoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("dojos")
public class DojosController {
    private final DojoService dojoService;

    public DojosController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "index.jsp";
    }

    @GetMapping("/new")
    public String newHojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojos/new.jsp";
    }

    @PostMapping("/new")
    public String saveDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {
        dojoService.save(dojo);
        return "redirect:/dojos";
    }

    @GetMapping("/{id}")
    public String showDojo(@PathVariable Long id, Model model) {
        Dojo dojo = dojoService.findById(id);
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", dojo.getNinjas());
        return "/dojos/show.jsp";
    }

    @DeleteMapping("/{id}")
    public String deleteDojo(@PathVariable Long id) {
        dojoService.delete(id);
        return "redirect:/dojos";
    }
}
