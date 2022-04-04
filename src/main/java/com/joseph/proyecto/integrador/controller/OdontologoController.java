package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.dominio.Odontologo;
import com.joseph.proyecto.integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService= odontologoService;
    }

    @GetMapping("/odontologo")

    public String traerOdontologo(Model model, @RequestParam("id") int id){
        Odontologo odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre_odontologo", odontologo.getNombre() );
        model.addAttribute("apellido_odontologo", odontologo.getApellido());

        return "index";
    }


}
