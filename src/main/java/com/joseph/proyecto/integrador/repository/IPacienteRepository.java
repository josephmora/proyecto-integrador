package com.joseph.proyecto.integrador.repository;

import com.joseph.proyecto.integrador.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
