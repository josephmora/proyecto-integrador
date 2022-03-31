package com.joseph.proyecto.integrador.service;

import com.joseph.proyecto.integrador.dominio.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listaPacientes();
    Paciente buscarPorEmail(String email);

}
