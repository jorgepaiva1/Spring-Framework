package com.example.prueba.maven.controller;


import com.example.prueba.maven.Dao.iPersonaDao;
import com.example.prueba.maven.Servicio.PersonaService;
import com.example.prueba.maven.domain.Persona;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j  //manejo de loggin
public class controlador {

    /*@Value("${index.saludo}")
    private String VariableDeApplicationProperties;*/

    @Autowired
    private PersonaService PersonaService;

    @GetMapping("/")
    public String Inicio(Model model){
        //var mensaje = "Mensaje con Thymeleaf";
        var Personas = PersonaService.ListarPersonas();

        log.info("corre el controlador Spring MVC");
        model.addAttribute("ListaPersonas",Personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String Agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String Guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        PersonaService.Guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String Editar(Persona persona, Model model){
        persona= PersonaService.EncontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String Eliminar(Persona persona){
        PersonaService.Eliminar(persona);
        return "redirect:/";
    }

}
