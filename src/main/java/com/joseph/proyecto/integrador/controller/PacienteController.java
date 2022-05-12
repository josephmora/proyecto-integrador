package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.modelo.dto.PacienteDTO;
import com.joseph.proyecto.integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    //instancio el servicio
    @Autowired
    private PacienteService pacienteService;



    @GetMapping("/email/{email}")

    public ResponseEntity<PacienteDTO> traerPacientePorEmail(@PathVariable String email){
        return ResponseEntity.ok(pacienteService.leerUnPacientePorEmail(email));


    }
    @PostMapping
    //requestBody asigna el cuerpo de la solicitud http al objeto PacienteDTO  (Los vincula)
    public ResponseEntity<String> crearUnPaciente(@RequestBody PacienteDTO pacienteDTO){

       pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK + " Paciente creado con éxito");
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.actualizarUnPaciente(pacienteDTO); //utilizo el servicio para actualizar y le paso como argumento el paciente que viene de la consulta
        return ResponseEntity.ok(HttpStatus.OK + " Paciente actualizado con éxito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientePorId(@PathVariable int id){
        if(pacienteService.leerUnPacientePorId(id) != null){
        return ResponseEntity.ok(pacienteService.leerUnPacientePorId(id));

        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable int id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK + "Se elimino el registro con éxito") ;
    }

    @GetMapping
    public Set<PacienteDTO> listarTodosPacientes(){
        return pacienteService.ListarTodosPacientes();
    }

}
