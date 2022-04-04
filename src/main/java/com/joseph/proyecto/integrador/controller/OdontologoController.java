package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.dominio.Odontologo;
import com.joseph.proyecto.integrador.dominio.Paciente;
import com.joseph.proyecto.integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService= odontologoService;
    }
//cuando trabajamos como api , esta vista deja de funcionar (thymeleaf)
    @GetMapping("/odontologo")

    public String traerOdontologo(Model model, @RequestParam("id") int id){
        Odontologo odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre_odontologo", odontologo.getNombre() );
        model.addAttribute("apellido_odontologo", odontologo.getApellido());

        return "index";
    }
    @PostMapping
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){

        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.actualizarOdontologo(odontologo); //utilizo el servicio para actualizar y le paso como argumento el paciente que viene de la consulta
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologo(@PathVariable int id){
        return odontologoService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public String eliminarOdontologo(@PathVariable int id){
        String respuesta = "Error, el id ingresado no es correcto";
        if(odontologoService.buscarPorId(id)!= null){
            //si existe un id consultado
            String odontologoEncontrado = odontologoService.buscarPorId(id).getNombre() +
                    " "+ odontologoService.buscarPorId(id).getApellido();
            odontologoService.eliminarOdontologo(id);
            respuesta= "Se elimino al odontologo " + odontologoEncontrado + " con id " + id;
        }
        return respuesta;
    }

    @GetMapping
    public List<Odontologo> listarOdontologo(){
        return odontologoService.listaOdontologos();
    }


}
