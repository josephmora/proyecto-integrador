package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.modelo.dto.DomicilioDTO;
import com.joseph.proyecto.integrador.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/domicilio")

public class DomicilioController {

        //instancio el servicio
        @Autowired
        private DomicilioService domicilioService;


        @PostMapping
        //requestBody asigna el cuerpo de la solicitud http al objeto PacienteDTO  (Los vincula)
        public ResponseEntity<String> crearUnDomicilio(@RequestBody DomicilioDTO domicilioDTO){

            domicilioService.crearDomicilio(domicilioDTO);
            return ResponseEntity.ok(HttpStatus.OK + " Domicilio creado con éxito");
        }

        @PutMapping
        public ResponseEntity<String> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
            domicilioService.actualizarDomicilio(domicilioDTO); //utilizo el servicio para actualizar y le paso como argumento el paciente que viene de la consulta
            return ResponseEntity.ok(HttpStatus.OK + " Domicilio actualizado con éxito");
        }


}
