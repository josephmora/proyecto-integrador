package com.joseph.proyecto.integrador;

import com.joseph.proyecto.integrador.modelo.dto.DomicilioDTO;
import com.joseph.proyecto.integrador.modelo.dto.PacienteDTO;
import com.joseph.proyecto.integrador.service.IDomicilioService;
import com.joseph.proyecto.integrador.service.IPacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IDomicilioService domicilioService;



    private PacienteDTO cargarDatos(){
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("Ian");
        pacienteDTO1.setApellido("Mora");
        pacienteDTO1.setDni("12345");
        pacienteDTO1.setEmail("prueba@mail.com");
        pacienteDTO1.setFechaIngreso(LocalDate.ofEpochDay(2021-02-02));
        //Seteo domicilio
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Cuarta Norte");
        domicilioDTO.setLocalidad("Zona 1");
        domicilioDTO.setNumero(240);
        domicilioDTO.setProvincia("Buenos Aires");


        pacienteDTO1.setDomicilio(domicilioDTO);
        return pacienteDTO1;
    }


    //test crear y leer un paciente
    @Test
    public void testCrearPaciente() {
        PacienteDTO pacienteDTO1 = cargarDatos();
        //Creando paciente 1
        pacienteService.crearPaciente(pacienteDTO1);
        //Test paciente creado y Listando paciente por Id
        PacienteDTO paciente1 = pacienteService.leerUnPacientePorId(1);
        assertTrue(paciente1 != null);
    }

    @Test
    public void testActualizarPaciente() {

        PacienteDTO pacienteDTO1 = pacienteService.leerUnPacientePorId(1);
        //Test actualizar paciente 1
        pacienteDTO1.setId(1); //paso el id del paciente a actualizar
        pacienteDTO1.setNombre("pepito");
        pacienteService.actualizarUnPaciente(pacienteDTO1);
        assertEquals("pepito", pacienteDTO1.getNombre());
        System.out.println("actualizado: " + pacienteDTO1.getNombre());

    }

    @Test
    public void testListarTodosPacientes() {
        PacienteDTO pacienteDTO1 = cargarDatos();
        //Creando paciente
        pacienteService.crearPaciente(pacienteDTO1);
        //Test listar todos los pacientes
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        pacientesDTO = pacienteService.ListarTodosPacientes();
        assertEquals(1, pacientesDTO.size());
        System.out.println("cantidad de pacientes listados: " + pacientesDTO.size());
    }

    @Test
    public void testEliminarPaciente(){
        //Test eliminar paciente con id 1
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        pacienteService.eliminarPaciente(1);
        //vuelvo a obtener todos los pacientes
        pacientesDTO = pacienteService.ListarTodosPacientes();

        assertTrue(pacientesDTO.isEmpty());
        System.out.println("Cantidad de pacientes: " + pacientesDTO.size());

    }






}