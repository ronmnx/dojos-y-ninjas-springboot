package com.ronaldo.dojos_y_ninjas.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronaldo.dojos_y_ninjas.models.Dojo;
import com.ronaldo.dojos_y_ninjas.models.Ninja;
import com.ronaldo.dojos_y_ninjas.services.DojoService;
import com.ronaldo.dojos_y_ninjas.services.NinjaService;

import jakarta.validation.Valid;

@RequestMapping("ninjas")
@Controller
public class NinjasController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public NinjasController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/new")
    public String newNinja(@ModelAttribute() Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "/ninjas/new.jsp";
    }

    @PostMapping("/new")
    public String createNinja(@Valid @ModelAttribute() Ninja ninja) {
        ninjaService.saveNinja(ninja);
        return "redirect:/dojos";
    }

    @DeleteMapping("/{id}")
    public String deleteNinja(@PathVariable Long id) {
        ninjaService.delete(id);
        return "redirect:/dojos";
    }

    @GetMapping("pages")
    public String getNinjasPerPage(Model model, @RequestParam int p) {
        // Tenemos que restar 1 porque las páginas iterables empiezan con índice 0. Esto
        // es para que nuestros enlaces puedan mostrarse desde 1...maxPage(última
        // página)

        Page<Ninja> ninjas = ninjaService.ninjasPerPage(p - 1);
        // Total número de páginas que tenemos
        int totalPages = ninjas.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("ninjas", ninjas);
        return "ninjas/ninjas.jsp";
    }
}
