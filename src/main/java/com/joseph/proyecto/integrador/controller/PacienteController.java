package com.joseph.proyecto.integrador.controller;

import com.joseph.proyecto.integrador.modelo.Paciente;
import com.joseph.proyecto.integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    //los metodos del controlador  se usa a traves de un servicio

    //creo un atributo de tipo PacienteService, no se crea un objeto new Pacie... porque
    //los datos son obtenidos del Dao a traves del servicio
    private final PacienteService pacienteService; //creo un objeto de tipo pacienteSe.. para usar el controller
    @Autowired //este es el primer metodo de inyección de dependencia con constructor
    public PacienteController(PacienteService pacienteService) { //de donde se passa
        this.pacienteService = pacienteService;
    }


    //si agrego RestController y RequestMapping esto deja de funcionar y no se pueden hacer consultas por url
    //metodo que resuelve la solicitud de la vista
    @GetMapping("/paciente")
    //obtengo el email que viene del endpoint
    public String traerPaciente(Model model, @RequestParam("email") String email){
        //buscar al paciente con el email mediante el servicio , el controller usa al servicio para saber donde buscar los datos pedidos por la vista
        Paciente paciente = pacienteService.buscarPorEmail(email);
        //model me permite devolver atributos que luego se lo pasamos al modelo
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";


    }
    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente){

        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente); //utilizo el servicio para actualizar y le paso como argumento el paciente que viene de la consulta
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable int id){
        return pacienteService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public String eliminarPaciente(@PathVariable int id){
        String respuesta = "Error, el id ingresado no es correcto";
        if(pacienteService.buscarPorId(id)!= null){
            //si existe un id consultado
            String PacienteEncontrado = pacienteService.buscarPorId(id).getNombre() +
                    " "+ pacienteService.buscarPorId(id).getApellido();
            pacienteService.eliminarPaciente(id);
            respuesta= "Se elimino al paciente " + PacienteEncontrado + " con id " + id;
        }
        return respuesta;
    }

    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listaPacientes();
    }

}
