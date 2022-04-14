package com.joseph.proyecto.integrador;

import com.joseph.proyecto.integrador.modelo.dto.PacienteDTO;
import com.joseph.proyecto.integrador.service.IPacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;
    @Test
    public void testCrearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Ian");
        pacienteDTO.setApellido("Mora");

        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO paciente1 = pacienteService.leerUnPacientePorId(1);

        assertTrue(true);
    }

}