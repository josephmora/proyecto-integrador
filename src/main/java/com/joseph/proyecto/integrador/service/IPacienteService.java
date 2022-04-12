package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.modelo.Paciente;
import com.joseph.proyecto.integrador.modelo.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerUnPaciente(int id);
    PacienteDTO leerUnPaciente(String email);
    void actualizarUnPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(int id);
    Set<PacienteDTO> ListarTodosPacientes();

}
