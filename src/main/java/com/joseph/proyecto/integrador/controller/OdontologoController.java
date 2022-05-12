package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.modelo.dominio.Odontologo;
import com.joseph.proyecto.integrador.modelo.dto.OdontologoDTO;
import com.joseph.proyecto.integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    //instancio el servicio
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    //requestBody asigna el cuerpo de la solicitud http al objeto PacienteDTO  (Los vincula)
    public ResponseEntity<String> crearUnOdontologo(@RequestBody OdontologoDTO odontologoDTO){

        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Odontologo creado con éxito");
    }

    @PutMapping
    public ResponseEntity<String> actualizarUnOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.actualizarUnOdontologo(odontologoDTO); //utilizo el servicio para actualizar y le paso como argumento el paciente que viene de la consulta
        return ResponseEntity.ok(HttpStatus.OK + " Odontologo actualizado con éxito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologoPorId(@PathVariable int id){
        if(odontologoService.leerUnOdontologo(id) != null){
            return ResponseEntity.ok(odontologoService.leerUnOdontologo(id));

        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable int id){
        odontologoService.elimiarUnOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK + "Se elimino el registro con éxito") ;
    }

    @GetMapping
    public Set<OdontologoDTO> listarTodosOdontologos(){
        return odontologoService.listarTodosOdontologos();
    }

}
