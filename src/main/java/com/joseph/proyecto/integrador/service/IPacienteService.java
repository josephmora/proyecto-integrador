package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.modelo.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerUnPacientePorId(int id);
    PacienteDTO leerUnPacientePorEmail(String email);
    void actualizarUnPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(int id);
    Set<PacienteDTO> ListarTodosPacientes();

}
