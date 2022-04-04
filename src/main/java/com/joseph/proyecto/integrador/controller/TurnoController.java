package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.dominio.Odontologo;
import com.joseph.proyecto.integrador.dominio.Paciente;
import com.joseph.proyecto.integrador.dominio.Turno;
import com.joseph.proyecto.integrador.service.OdontologoService;
import com.joseph.proyecto.integrador.service.PacienteService;
import com.joseph.proyecto.integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService ;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }



    @PostMapping
    public ResponseEntity<Turno> registraTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        //controlar si los id son existentes
        Paciente paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscarPorId(turno.getPaciente().getId());
        if(paciente!=null && odontologo!= null){
            //okey, podemos agregar el turno
            respuesta = ResponseEntity.ok(turnoService.registrarTurno(turno));
        }
        else{
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }

    @GetMapping
    //devuelve una respuesta de tipo http 500, 400 etc
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }


}
