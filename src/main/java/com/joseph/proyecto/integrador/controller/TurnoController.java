package com.joseph.proyecto.integrador.controller;


import com.joseph.proyecto.integrador.exceptions.BadRequestException;
import com.joseph.proyecto.integrador.modelo.dto.TurnoDTO;
import com.joseph.proyecto.integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<String> crearTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Turno creado con exito");
    }

    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.actualizarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Turno actualizado con exito");
    }

    @GetMapping("/{id}")
    public TurnoDTO buscarTurnoPorId(@PathVariable Integer id){
        return turnoService.leerUnTurno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id) throws BadRequestException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK + " Turno eliminado con exito");
    }

    @GetMapping
    public Set<TurnoDTO> leerTodosLosTurnos(){
        return turnoService.listarTodosTurnos();
    }
}
