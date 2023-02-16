/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.controller;


import com.tienda.tienda.entity.Pais;
import com.tienda.tienda.entity.Persona;
import com.tienda.tienda.service.IPaisService;
import com.tienda.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mathi
 */
@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/persona") // aca definimos el endpoint para el html persona. Se triggerea ese mapping 
    //el restful api ejecuta todo mediante requests.
    public String index(Model model) { //el model permite pasarle al frontend la info mediante el addAttribute
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
        
    }
    
    @GetMapping("/personaN")
    public String crearPersona(Model model){
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    
    }
  
}
