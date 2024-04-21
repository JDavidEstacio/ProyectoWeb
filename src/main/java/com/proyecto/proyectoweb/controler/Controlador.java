package com.proyecto.proyectoweb.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.proyectoweb.interfaceService.ISalonService;
import com.proyecto.proyectoweb.modelo.Salon;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;


@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private ISalonService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Salon> salones = service.listar();
        model.addAttribute("salones", salones);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("salon", new Salon());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Validated Salon s, Model model){
        service.save(s);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar (@PathVariable int id, Model model){
        Optional<Salon> salon = service.listarId(id);
        model.addAttribute("salon", salon);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model) {
        service.delete(id);
        return "redirect:/listar";
    }
}
