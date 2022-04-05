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
    @Autowired //este es el tercer metodo de inyección de dependencias
    private TurnoService turnoService ;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;





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

//    @PostMapping
//    public ResponseEntity<String> registraTurno(@RequestBody Turno turno){
//        ResponseEntity<String> respuesta;
//        //controlar si los id son existentes
//        Paciente paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
//        Odontologo odontologo = odontologoService.buscarPorId(turno.getPaciente().getId());
//        if(paciente!=null && odontologo!= null){
//            //okey, podemos agregar el turno
//           respuesta = new ResponseEntity<>("Turno registrado con exito",HttpStatus.OK  );
//        }
//        else{
//          respuesta =  new ResponseEntity<>("Ha fallado el registro",HttpStatus.BAD_REQUEST );
//        }
//        return respuesta;
//    }

    @GetMapping
    //devuelve una respuesta de tipo http 500, 400 etc
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }


}
